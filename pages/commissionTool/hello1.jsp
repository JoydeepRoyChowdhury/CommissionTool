<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page session="false" %>
<head>
    <title>Employee Added</title>
</head>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
<body>
<h2>The Role has successfully added..</h2>

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


<table style="width:100%">
  <tr>
  	<th>Id</th>
    <th>RoleName</th>
    <th>Description</th>		
    <th>ReportTo</th>
  </tr>
  <c:forEach items="${listRole}" var="role">
  <tr>
    <td>${role.id}</td>
    <td>${role.RoleName}</td>		
    <td>${role.Description}</td>
    <td>${role.ReportTo}</td>
  </tr>
 </c:forEach>
</table>


 </tiles:putAttribute>
</tiles:insertDefinition>