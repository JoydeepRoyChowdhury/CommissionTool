<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>



<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">

		<title>CompRuleDetails</title>

		<style>
td {
	padding-top: .5em;
	padding-bottom: .5em;
}
</style>

		<div align="center">
			<h1>Compensation Rule Details</h1>


			<table>
				<tr>
					<td><b>Rule name:</b></td>
					<td><input type="text" name="RuleName"><br /></td>
				</tr>
				<tr>
					<td><b>Description:</b></td>
					<td><input type="text" name="Description"></td>
				</tr>
				<tr>
					<td><b>Rule type:</b></td>
					<td><input type="checkbox" name="simple" value="Simple">Simple
						<input type="checkbox" name="composite" value="Composite" checked>Composite</td>
				</tr>
				<tr>
					<td><b>Rules connected as: </b></td>
					<td><input type="checkbox" name="all" value="All">All
						<input type="checkbox" name="all" value="Any" checked>Any</td>
				</tr>

				<tr>
					<td><b>List of Rules: </b></td>
					<td><select><option value="#">Rule1</option>
							<option value="#">Rule2</option>
							<option value="#">Rule3</option>
							<option value="#">Rule4</option>
					</select><a href="#">Delete</a><br /> <select><option value="#">Rule1</option>
							<option value="#">Rule2</option>
							<option value="#">Rule3</option>
							<option value="#">Rule4</option></select><a href="#">Delete</a><br /> <a
						href="#">Add row</a><br /></td>
				</tr>
				<tr>
					<td><b>Compensation</b></td>
					<td><input type="checkbox" name="fixed" value="Fixed">Fixed
						<input type="text" name="fixedValue"><br /> <input
						type="checkbox" name="variable" value="Variable">Variable<br />
						Apply formula<input type="text" name="variableValue"><br />
					<br /> parameters<input type="text" name="parameterValue"><br />
					</td>

				</tr>
				<tr>
					<td><input type="submit" value="Update">
					<input type="submit" value="Submit" /> 
					<a href="/CommissionTool/CompRule"> <input type="button"
							value="Cancel" /></a></td>
				</tr>



			</table>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>