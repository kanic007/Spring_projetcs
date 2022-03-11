<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form:form modelAttribute="command" method="post">
<div>
<label>MobileNumber</label>
<form:input path="mobileNumber"/>
</div>

<div>
<label>First Name</label>
<form:input path="FirstName"/>
	<form:errors path="firstName" style="color:#FF0000"></form:errors>
</div>

<div>
<label>Blood Group</label>
<form:select items="${groups}" path="BloodGroup"/>
</div>

<div>
<label>Date Last Donated</label>
<form:input type="date" path="DateLastDonated"/>

<form:errors path="DateLastDonated" style="color:#FF0000"></form:errors>
</div>

<input type="Submit">
</form:form>
</body>
</html>