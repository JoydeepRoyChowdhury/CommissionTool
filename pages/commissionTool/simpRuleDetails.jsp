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

		<script>
			var count = "1";
			function addRow2(Quali_input) {
				var tbody = document.getElementById(Quali_input);
				var row = document.createElement("TR");
				var td1 = document.createElement("TD");
				var strHtml1 = "<select><option value=\"Customer Name\">Customer Name</option><option value=\"order Total\">order Total</option><option value=\"Discount%\">Discount%</option></select>&nbsp;Not&nbsp;<input type=\"checkbox\" name=\"not\" value=\"Not\">&nbsp;Condition&nbsp;<select><option value=\"Equal\">Equal</option><option value=\"Greater than\">Greater than</option><option value=\"Less than\">Less than</option></select>&nbsp;Parameter Name&nbsp;<input type=\"text\" name=\"parametername\">";
				td1.innerHTML = strHtml1.replace(/!count!/g, count);
				var td2 = document.createElement("TD")
				var strHtml2 = "&nbsp;<INPUT TYPE=\"Button\" CLASS=\"Button\" onClick=\"delRow()\" VALUE=\"Delete Row\">";
				td2.innerHTML = strHtml2.replace(/!count!/g, count);
				row.appendChild(td1);
				row.appendChild(td2);
				count = parseInt(count) + 1;
				tbody.appendChild(row);
			}
			var count = "1";
			function addRow1(Par_input) {
				var tbody = document.getElementById(Par_input);
				var row = document.createElement("TR");
				var td1 = document.createElement("TD");
				var strHtml1 = "Parameter Name&nbsp;<INPUT TYPE=\"text\" name=\"parameterName\">&nbsp;Default Value&nbsp;<INPUT TYPE=\"text\" name=\"defaultValue\">";
				td1.innerHTML = strHtml1.replace(/!count!/g, count);
				var td2 = document.createElement("TD")
				var strHtml2 = "&nbsp;<INPUT TYPE=\"Button\" CLASS=\"Button\" onClick=\"delRow()\" VALUE=\"Delete Row\">";
				td2.innerHTML = strHtml2.replace(/!count!/g, count);
				row.appendChild(td1);
				row.appendChild(td2);
				count = parseInt(count) + 1;
				tbody.appendChild(row);
			}
			function delRow() {
				var current = window.event.srcElement;
				while ((current = current.parentElement)
						&& current.tagName != "TR");
				current.parentElement.removeChild(current);
			}
		</script>


<form action="/CommissionTool/submitSimpRule" method="post">
			<div style="height: 580px; overflow: auto;">
				
					<h1 align="center">Compensation Rule Details</h1>

					<table border="1">
				 		
						<tr>
							<td><b>Rule Name:</b></td>
							<td><input type="text" name="ruleName"></td>
						</tr>
						<tr>
							<td><b>Description:</b></td>
							<td><input type="text" name="description"></td>
						</tr>
						<tr>
							<td><b>RuleDetails</b></td>
							<td><input type="text" name="ruleDetails"></td>
						</tr>
						<tr>
							<td><b>Rule Type:</b></td>
							<td><input type="text" name="ruleType"></td>
						</tr>
						
						<tr>
							<td><b>Parameter</b></td>
							<td>Parameter Name&nbsp;<INPUT TYPE="text" name="parameterName">&nbsp;Default Value&nbsp;<INPUT TYPE="text" name="defaultValue"></td>
						</tr>
				
						<tr>
							<td><b>Parameters</b></td>
							<td>
								<table ID="Par_input">
									<tr>
										<td><input type="Button" onClick="addRow1('Par_input')"
											VALUE="Add Row"></td>
									</tr>
									
								</table>
							</td>
						</tr>
	
						<tr>
							<td><b>Calculation mode:&nbsp;</b></td>
							<td><input type="checkbox" name="calculationMode"
								value="i">
								
								&nbsp;individual&nbsp;<input type="checkbox"
								name="calculationMode" value="r">&nbsp;Rank&nbsp;<br/>
								Within&nbsp;<input type="text" value="" size="4">&nbsp;ranks in&nbsp;<input type="checkbox" value="Number">&nbsp;number&nbsp;<input type="checkbox" value="percentage">&nbsp;percentage
							<br/><br/>Population&nbsp;<input type="checkbox" value="">&nbsp;Under same reporting manager<br/>
					<input type="checkbox" value="">&nbsp;Same role<br/>
					<input type="checkbox" value="">&nbsp;Global Upto &nbsp;<input type="text" size="4">&nbsp;level up</td>
									
					
						</tr>

						<tr>
							<td><b>Based on: </b></td>
							<td>Aggregate function<br /> <select><option
										value="#">sum</option>
									<option value="#">max</option>
									<option value="#">min</option>
									<option value="#">count</option>
							</select> &nbsp;Field&nbsp;<select><option value="#">&nbsp;order total&nbsp;</option>
									<option value="#">service total</option>
							</select></td>

						</tr>

						<tr>
							<td><b>Qualifying Clause</b></td>
							<td>
								<table ID="Quali_input">
									<tr>
										<td><input type="Button" onClick="addRow2('Quali_input')"
											VALUE="Add Row"></td>
									</tr>
									<tr>
										<td>&nbsp;&nbsp;&nbsp;Field&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Condition &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Value</td>
									</tr>
								</table>

							</td>
						</tr>
						
				
						<tr>
							<td><b>Compensation</b></td>
							<td><input type="checkbox" name="compensationType" value="Fixed">&nbsp;Fixed&nbsp;
								<input type="text" name="fixedCompValue" value="0"><br />						
								<input type="checkbox" name="compensationType" value="Variable">&nbsp;Variable&nbsp;<br />
							
								&nbsp;Apply formula&nbsp;<input type="text" name="compensationFormula"><br />
								<br />&nbsp; parameters&nbsp;<input type="text" name="compensationParameter"><br />
							</td>
						
						</tr>
	
					
					</table>
			
						<div align="center">	<input type="submit" value="Submit"> <a
								href="/CommissionTool/ruledetails"> <input type="button"
									value="Cancel" /></a></div>
						
				
				</div>
		
		</form>


	</tiles:putAttribute>
</tiles:insertDefinition>