<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action ="findByGroup">


  <label>Blood Group</label>
   <select name="group">
			<option value="opos">O Positive</option>
			<option value="A1pos">A1 Positive</option>
			<option value="ABpos">AB Positive</option>
			<option value="Oneg">O Negative</option>
			<option value="ABneg">AB Negative</option>
</Select>


<input type="submit" value="search">

</form>
<a href="/">Home</a>


</body>
</html>