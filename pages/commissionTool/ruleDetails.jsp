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
  var RuleArray=new Array();
     RuleArray= "${listRule}";
    var len=RuleArray.length;

   var strHtml1= "<SELECT NAME=\"Rule\"><OPTION VALUE=\"Null\">Null<OPTION VALUE=\"Null\">Null<OPTION VALUE=\"Null\">Null</SELECT>";
   
   
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
  
  function dateGenerate() {
	   var date = new Date(), dateArray = new Array(), i;
	   curYear = date.getValue();
	    for(i = 0; i<5; i++) {
	        dateArray[i] = curYear+i;
	    }
	    return dateArray;
	}

	function addSelect(divname) {
	   var newDiv=document.createElement('div');
	   var html = '<select>', dates = dateGenerate(), i;
	   for(i = 0; i < dates.length; i++) {
	       html += "<option value='"+dates[i]+"'>"+dates[i]+"</option>";
	   }
	   html += '</select>';
	   newDiv.innerHTML= html;
	   document.getElementById(divname).appendChild(newDiv);
	}
</script>

<form action="/CommissionTool/submitCompRule" method="post">

		<div align="center">
			<h1>Compensation Rule Details</h1>


			<table>
				<tr>
					<td><b>Rule name:</b></td>
					<td><input type="text" name="ruleName"><br /></td>
				</tr>
				<tr>
					<td><b>Description:</b></td>
					<td><input type="text" name="description"></td>
				</tr>
				<tr>
					<td><b>Rule type:</b></td>
					<td>Composite<input type="hidden" name="ruleType" value="c">
					

				</tr>
				<tr>
					<td><b>Rules connected as: </b></td>
					<td><input type="checkbox" name="connectionType" value="All">All
						<input type="checkbox" name="connectionType" value="Any" checked>Any</td>
				</tr>


				<tr>
					<td><b>List of Rules: </b></td>

					<td>
						<table ID="in_tbl_name">
							<tr>

								<td><select><c:forEach items="${listCompRule1}"
											var="rule">
											<option value="${rule.ruleName}">
												<c:out value="${rule.ruleName}" />
											</option>
										</c:forEach>
								</select>
								</td>
								<td><input type="Button" onClick="addRow('in_tbl_name')"
									VALUE="Add Row"></td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
				<td>
<div id="select-container">
</div>
<button id="add" onclick="addSelect('select-container');">Add Dropdown</button></td>
				
				</tr>

				<tr>
					<td><b>Compensation</b></td>
					<td><input type="checkbox" name="fixed" value="compensationType">Fixed
						<input type="text" name="fixedCompValue" value="0"><br /> <input
						type="checkbox" name="compensationType" value="Variable">Variable<br />
						Apply formula<input type="text" name="compensationFormula"><br />
						<br /> parameters<input type="text" name="compensationParameter"><br />
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
		</form>
	</tiles:putAttribute>
</tiles:insertDefinition>