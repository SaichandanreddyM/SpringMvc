<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="emp" action="updateemployee">
Id:<form:input path="employeeid"/>
Name:<form:input path="employeename"/>
Mail:<form:input path="employeeemail"/>
Password:<form:input path="employeepwd"/>
Contact:<form:input path="employeecontact"/>
<input type="submit">
</form:form>
</body>
</html>