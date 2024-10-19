package BadMa.Model;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private int groupId;
    private List<Student> studentList;
    public Group() {}
    public Group(int groupId, List<Student> studentList) {
        this.groupId = groupId;
        this.studentList = studentList;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
    public void addStudent(Student student) {
        this.studentList.add(student);
    }
    public Report getGroupReport(int week) {
        List<Record>records = new ArrayList<Record>();
        for(Student student : studentList) {

            if (!student.isPresent(week)) {
                Record record = new Record(student.getName(),student.getAbsentReason(week),student.getId());
                records.add(record);
            }

        }
        Report report = new Report(groupId,records);
        return report;
    }
}
