<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> blood bank</title>

<style type="text/css">

img{
width: 20%;
margin-left: auto;
margin-right: auto;
display: block;

}
ul>li{
   display:inline;
   margin:10px;
   border:1px solid #0000FF;
   border-radius: 5px;
   font-size: 1.2em;
}
</style>
<link rel="icon" type="img/png" href="/images/index.jpg">


</head>
<body>


<div>
<img class="image" src="/images/index.jpg">
</div>

<h1 style="text-align:center;">${heading}</h1>
<ul>
  <li><a href="add">Add Donor</a></li>
  <li><a href="findAll">Find All Donors</a></li>
  <li><a href="srchByGroup">Search By Blooad Group</a></li>
  <li><a href="findByName">Find By First Name</a></li>

</ul>

</body>
</html>