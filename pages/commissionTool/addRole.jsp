<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page session="false"%>
<head>
<title>Insert Role</title>
</head>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
<body>
	<div align="center">
		<h1>Role Details</h1>
		<form action="/CommissionTool/submitRole" method="post">

			<b>Role Name:</b><input type="text" name="RoleName" /><br /> 
			<b>Description:</b><input type="text" name="Description" /><br /> 
			<b>Report To:</b><input type="text" name="ReportTo" /><br /> 
			<input type="submit" value="Submit" />

		</form>



	</div>

</body>
</tiles:putAttribute>
</tiles:insertDefinition>