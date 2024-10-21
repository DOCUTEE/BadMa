package BadMa.controller;

import BadMa.Model.BadmintonClass;
import BadMa.Model.Group;
import BadMa.Model.Report;
import BadMa.Model.Student;
import jakarta.servlet.http.Cookie;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/waiting")
public class WaitingController extends HttpServlet {
    private static final String FILE_URL = "https://docs.google.com/spreadsheets/d/e/2PACX-1vQTcHsRqB6m-hEIK_HXg6dMxiAl0TqThlhzbEDz2IOqHttOJLfAGnZXCM0XsR-7wEfaAoCSJzUeun3N/pub?output=xlsx";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int weekNeed = Integer.parseInt(request.getParameter("week"));
        URL url = new URL(FILE_URL);
        URLConnection con = url.openConnection();
        BadmintonClass badClass = new BadmintonClass();
        try (InputStream inputStream = con.getInputStream()){

            Workbook workbook = new XSSFWorkbook(inputStream);

            for(int i = 0; i < 5; i++){

                Sheet sheet = workbook.getSheetAt(i);
                List<Student> students = new ArrayList<>();

                for(int rowIndex = 1; rowIndex <= 10; rowIndex++) {

                    Row row = sheet.getRow(rowIndex);
                    int studentId = Integer.parseInt(row.getCell(0).toString());
                    String studentName = row.getCell(1).toString();
                    List<String> reasons = new ArrayList<>();
                    reasons.add("Đã có tại lớp");

                    for (int week = 1; week <= 15; week++) {

                        reasons.add(row.getCell(week + 1).toString());

                    }

                    Student st = new Student(reasons, studentName, studentId);
                    students.add(st);
                }
                Group group = new Group(i+1,students);
                badClass.addGroup(group);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
//        request.setAttribute("BadmintonClass", badClass);
//        request.getRequestDispatcher("process.jsp").forward(request, response);
        List<Report>reportList = badClass.getGroupsReport(weekNeed);
//        Cookie[] cookies = request.getCookies();
        request.setAttribute("reportList", reportList);
        request.setAttribute("weekNeed", weekNeed);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}