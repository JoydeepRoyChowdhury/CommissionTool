<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Role</title>
</head>
<head>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
}
</style>
</head>
<body>
<table style="width:100%">
  <tr>
  	<th>Id</th>
    <th>RoleName</th>
    <th>Description</th>		
    <th>ReportTo</th>
  </tr>
   
  <tr>
    <td>${role.id}</td>
    <td>${role.RoleName}</td>		
    <td>${role.Description}</td>
    <td>${role.ReportTo}</td>
  </tr>
</table>
</body>

</html>