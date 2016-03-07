<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CompensationRule</title>
</head>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 5px;
}
</style>

<div style="height:540px;overflow:auto;">
			<div align="center">
				<h1>Compensation Rules</h1>
			</div>
			<table style="width: 75%">
				<tr>
					<td>Rule Name</td>
					<td>Type</td>
					<td>Description</td>
					<td>Rule Details</td>

				</tr>

				
					<c:forEach items="${listRule}" var="rule">
								<tr>

									<td><a href="/CommissionTool/submitSimpRule">${rule}</a></td>
									<td>null</td>
									<td>null</td>
									<td>null</td>
									
								</tr>

							</c:forEach>

			</table>
			<div align="center">
				<br />
				<input type="submit" value="Add composite Rule"> <input
					type="submit" value="Add simple rule">
			</div>
			</div>

	</tiles:putAttribute>
</tiles:insertDefinition>