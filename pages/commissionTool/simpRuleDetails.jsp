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
				var strHtml1 = "<select><option value=\"#\">Customer Name</option><option value=\"#\">order Total</option><option value=\"#\">Discount%</option></select>&nbsp;Not&nbsp;<input type=\"checkbox\" name=\"not\" value=\"Not\">&nbsp;Condition&nbsp;<select><option value=\"#\">Equal</option><option value=\"#\">Greater than</option><option value=\"#\">Less than</option></select>&nbsp;Parameter Name&nbsp;<input type=\"text\" name=\"parametername\">";
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
						&& current.tagName != "TR")
					;
				current.parentElement.removeChild(current);
			}
		</script>


		<form action="/CommissionTool/submitSimpRule" method="POST">
			<div style="height: 580px; overflow: auto;">
				
					<div align="center"><h1>Compensation Rule Details</h1></div>

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
							<td><input type="text" name="RuleType"></td>


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
							<td><b>Calculation model:</b></td>
							<td><input type="checkbox" name="individual"
								value="Individual">&nbsp;individual&nbsp;<input type="checkbox"
								name="composite" value="Composite" checked>&nbsp;Composite&nbsp;</td>
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
							<td><input type="checkbox" name="fixed" value="Fixed">&nbsp;Fixed&nbsp;
								<input type="text" name="fixedValue"><br /> <input
								type="checkbox" name="variable" value="Variable">&nbsp;Variable&nbsp;<br />
								&nbsp;Apply formula&nbsp;<input type="text" name="variableValue"><br />
								<br />&nbsp; parameters&nbsp;<input type="text" name="parameterValue"><br />
							</td>
						</tr>
				
						<tr>
							<td><input type="submit" value="Submit"> <a
								href="/CommissionTool/ruledetails"> <input type="button"
									value="Cancel" /></a></td>
						</tr>



					</table>
				</div>
		
		</form>


	</tiles:putAttribute>
</tiles:insertDefinition>