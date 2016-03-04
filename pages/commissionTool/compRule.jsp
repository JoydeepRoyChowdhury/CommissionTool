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

				<tr>
					<td><a href="/CommissionTool/submitCompRuleEdit">HighPerformance</a></td>
					<td>null</td>
					<td>null</td>
					<td>null</td>
				</tr>
				<tr>
					<td><a href="/CommissionTool/submitSimpRule">SalesPerformance</a></td>
					<td>null</td>
					<td>null</td>
					<td>null</td>
				</tr>

			</table>
			<div align="center">
				<br />
				<input type="submit" value="Add composite Rule"> <input
					type="submit" value="Add simple rule">
			</div>

	</tiles:putAttribute>
</tiles:insertDefinition>