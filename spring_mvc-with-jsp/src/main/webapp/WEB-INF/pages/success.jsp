<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table,tr,th{

       margin: auto;
       border: 1px solid black;
       background-color: #E6E6FA;
  
}


</style>
</head>


<h2 style="text-align: center">List of Blood Donors</h2>

<body>
	<table>
   <tr>
     <th>First Name</th>
     <th>Blood Group</th>
     <th>Mobile Number</th>
     <th>Date Last Donated</th>

  </tr>
  <tr>
     <th>${command.firstName}</th>
     <th>${command.bloodGroup}</th>
     <th>${command.mobileNumber}</th>
     <th>${command.dateLastDonated}</th>

  </tr>

</table>

</body>
</html>