<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="2px">
<tr>
<th>ID</th>
<th>NAME</th>
<th>EMAIL</th>
<th>CONTACT</th>
<th>DELETE</th>
<th>EDIT</th>
</tr>
<c:forEach var="emp" items="${emps}">
<tr>
<td>${emp.employeeid}</td>
<td>${emp.employeename}</td>
<td>${emp.employeeemail}</td>
<td>${emp.employeecontact}</td>
<td><a href="delete?id=${emp.employeeid}">delete</a></td>
<td><a href="edit?id=${emp.employeeid}">edit</a></td>
</tr>






</c:forEach>




</table>
<a href="add">Add Employee</a>





</body>
</html>