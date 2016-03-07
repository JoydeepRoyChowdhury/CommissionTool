<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>


<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">

<title>SimpleRuleDetails</title>


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
					<td><b>Parameters: </b></td>
					<td>Parameter Name<br/><input type="text" name="parametername">
						Default value<br/><input type="text" name="parametername">
						<a href="#">Delete</a>
						<a href="#">Add row</a></td>
				</tr>
				
				<tr>
					<td><b>Calculation model:</b></td>
					<td><input type="checkbox" name="individual" value="Individual">individual
						<input type="checkbox" name="composite" value="Composite" checked>Composite</td>
				</tr>

				<tr>
					<td><b>Based on: </b></td>
					<td>Aggregate function<br/><select><option value="#">sum</option>
							<option value="#">max</option>
							<option value="#">min</option>
							<option value="#">count</option>
					</select> Field<select><option value="#">order total</option>
							<option value="#">service total</option>
							</select></td>
						
				</tr>
				
				<tr>
					<td><b>Qualifying clause: </b></td>
					<td>Field<br/><select><option value="#">Customer Name</option>
							<option value="#">order Total</option>
							<option value="#">Discount%</option>
							
					</select>Not<input type="checkbox" name="not" value="Not">
					Condition<select><option value="#">Equal</option>
							<option value="#">Greater than</option>
							<option value="#">Less than</option>
							</select>Parameter Name<input type="text" name="parametername">
							<a href="#">Delete</a>
						<a href="#">/Add row</a></td>
						
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
					<a href="/CommissionTool/ruledetails"> <input type="button"
							value="Cancel" /></a></td>
				</tr>



			</table>
		</div>	
		
	</tiles:putAttribute>
</tiles:insertDefinition>