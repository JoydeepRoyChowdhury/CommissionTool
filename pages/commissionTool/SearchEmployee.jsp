
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page session="false"%>
<head>
<title>searchemployee</title>
</head>
<style>
#textboxid {
	background-color: #FFF;
	min-height: 80px;
	min-width: 120px;
}
</style>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<body>

			<form action="/CommissionTool/submitempSerch" method="post">

				<div id="menu"></div>
				<div id="buffer" class="body"></div>
				
					<h1 align="center">Search Employee</h1>
					<table border=0 align="center">
						<tr>
							<td><b>Employee Name:</b></td>
							<td><input type="text" name="EmployeeName"></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td><input type="submit" value="Submit"></td>
						</tr>
					</table>
				

			</form>




		</body>
	</tiles:putAttribute>
</tiles:insertDefinition>