<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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



		<script>
 
var count = "1";

  function addRow(in_tbl_name)
  {
    var tbody = document.getElementById(in_tbl_name);
    
    var row = document.createElement("TR");

    var td1 = document.createElement("TD")
  
    var RuleArray= "${listRule}";
    var len=RuleArray.length;
   
    
  
   var strHtml1= "<select Name=\"Rule\"><OPTION VALUE=\"Demo\">Demo<OPTION VALUE=\"Demo\">Demo<OPTION VALUE=\"Demo\">Demo</SELECT>"
   
   
    td1.innerHTML = strHtml1.replace(/!count!/g,count);
   
    var td2 = document.createElement("TD")
    var strHtml2 = "<INPUT TYPE=\"Button\" CLASS=\"Button\" onClick=\"delRow()\" VALUE=\"Delete Row\">";
    td2.innerHTML = strHtml2.replace(/!count!/g,count);
    
    row.appendChild(td1);
    row.appendChild(td2);

    count = parseInt(count) + 1;
  
    tbody.appendChild(row);
  }
  function delRow()
  {
    var current = window.event.srcElement;
    //here we will delete the line
    while ( (current = current.parentElement)  && current.tagName !="TR");
         current.parentElement.removeChild(current);
  }
</script>

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
					<td>Composite</td>

				</tr>
				<tr>
					<td><b>Rules connected as: </b></td>
					<td><input type="checkbox" name="all" value="All">All
						<input type="checkbox" name="all" value="Any" checked>Any</td>
				</tr>


				<tr>
					<td><b>List of Rules: </b></td>

					<td>
						<table ID="in_tbl_name">
							<tr>

								<td><select><c:forEach items="${listRule}"
											var="rule">
											<option value="${rule}">
												<c:out value="${rule}" />
											</option>
										</c:forEach>
								</select></td>
								<td><input type="Button" onClick="addRow('in_tbl_name')"
									VALUE="Add Row"></td>
							</tr>
						</table>
					</td>
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
					<td><input type="submit" value="Update"> <input
						type="submit" value="Submit" /> <a
						href="/CommissionTool/CompRule"> <input type="button"
							value="Cancel" /></a></td>
				</tr>
			</table>

		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>