<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<head>
    <title>Submitted Result</title>
</head>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
 
<body>
<h2>Submitted Employee Information</h2>
   <table>
    <tr>
        <td>ID</td>
        <td>${message}</td>
    </tr>   
</table>  
</body>
 </tiles:putAttribute>
</tiles:insertDefinition>