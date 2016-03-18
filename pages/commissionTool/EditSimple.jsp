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
							<td><input type="text" name="ruleName" value="${listRule3.ruleName}"></td>
						</tr>
						<tr>
							<td><b>Description:</b></td>
							<td><input type="text" name="description" value="${listRule3.description}"></td>
						</tr>
						<tr>
							<td><b>RuleDetails</b></td>
							<td><input type="text" name="ruleDetails" value="${listRule3.ruleDetails}"></td>
						</tr>
						<tr>
							<td><b>Rule Type:</b></td>
							<td>Simple<input type="hidden" name="ruleType" value="s"></td>
						</tr>
						
						<tr>
							<td><b>Parameter</b></td>
							<td>Parameter Name&nbsp;<input TYPE="text" name="parameterName">&nbsp;Default Value&nbsp;<INPUT TYPE="text" name=" "></td>
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
								Within&nbsp;<input type="text" Name="rankCount" value="0" size="4">&nbsp;ranks in&nbsp;<input type="checkbox" Name="rankType" value="Number">&nbsp;number&nbsp;<input type="checkbox" Name="rankType" value="percentage">&nbsp;percentage
							<br/><br/>Population&nbsp;<input type="checkbox" Name="populationType" value="SameManager">&nbsp;Under same reporting manager<br/>
					<input type="checkbox" Name="populationType" value="SameRole">&nbsp;Same role<br/>
					<input type="checkbox" Name="populationType" value="Global">&nbsp;Global Upto &nbsp;<input type="text" Name="populationUpto" size="4">&nbsp;level up</td>
									
					
						</tr>

						<tr>
							<td><b>Based on: </b></td>
							<td>Aggregate function<br /> 
							<select><c:forEach items="${listRule1}"
											var="rule">
											<option value="${rule.functionName}">
												<c:out value="${rule.functionName}" />
											</option>
										</c:forEach>
								</select>
							 &nbsp;Field&nbsp;
							<select><c:forEach items="${listRule2}"
											var="rule1">
											<option value="${rule1.displayName}">
												<c:out value="${rule1.displayName}" />
											</option>
										</c:forEach>
								</select>
							</td>

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
								<input type="text" name="fixedCompValue" value="${listRule3.fixedCompValue}"><br />						
								<input type="checkbox" name="compensationType" value="Variable">&nbsp;Variable&nbsp;<br />
							
								&nbsp;Apply formula&nbsp;<input type="text" name="compensationFormula" value="${listRule3.compensationFormula}"><br />
								<br />&nbsp; parameters&nbsp;<input type="text" name="compensationParameter" value="${listRule3.compensationParameter}"><br />
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