<%--
  Created by IntelliJ IDEA.
  User: quang
  Date: 10/19/2024
  Time: 9:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="BadMa.Model.Report" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Kết quả điểm danh</title>

</head>
<body>

<div>Điểm danh tuần <%= request.getAttribute("weekNeed") %> lớp cầu lông sáng thứ 5 tiết 1-2</div>
<%--<% List<Report>reportList = (List<Report>) request.getAttribute("reportList");%>--%>
<c:forEach var="report" items="${reportList}">
    <h3>Nhóm: ${report.groupId}</h3>
    <c:forEach var="record" items="${report.records}">
        <div>${record.studentId} | ${record.studentName} | ${record.reason} </div>
    </c:forEach>
</c:forEach>
<a href="${pageContext.request.contextPath}/"> quay trở lại</a>
</body>
</html>
