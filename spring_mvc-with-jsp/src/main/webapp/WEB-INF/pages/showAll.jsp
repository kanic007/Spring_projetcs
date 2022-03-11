<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    
 <%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table,tr,th,td{

       margin: auto;
       border: 1px solid black;
       background-color: #E6E6FA;
  
}


</style>
</head>
<body>



<table>
     <tr>
	      <th>Donor Name</th>
	      <th>Blood Group</th>
	      <th>Date Last Donated</th>
	      <th>Mobile Number</th>
      </tr>
      <c:forEach items="${list}" var="eachItem">
      <tr>
           <td>${eachItem.firstName}</td>
           <td>${eachItem.bloodGroup}</td>
           <td>${eachItem.dateLastDonated}</td>
           <td>${eachItem.mobileNumber}</td>
           
        </tr>
       </c:forEach> 
</table>
</body>
</html>