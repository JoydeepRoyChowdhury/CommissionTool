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



		<script type="text/javascript">


				   function rowAdded(rowElement) {
				            //clear the imput fields for the row
				            $(rowElement).find("input").val('');
				            //may want to reset <select> options etc

				            //in fact you may want to submit the form
				            saveNeeded();
				        }
				        function rowRemoved(rowElement) {
				            saveNeeded();
				        }

				        function saveNeeded() {
				            $('#submit').css('color','red');
				            $('#submit').css('font-weight','bold');
				            if( $('#submit').val().indexOf('!') != 0 ) {
				                $('#submit').val( '!' + $('#submit').val() );
				            }
				        }

				        function beforeSubmit() {
				            alert('submitting....');
				            return true;
				        }

				        $(document).ready( function() {
				            var config = {
				                rowClass : 'person',
				                addRowId : 'addPerson1',
				                removeRowClass : 'removePerson1',
				                formId : 'personListForm1',
				                rowContainerId : 'personListContainer2',
				                indexedPropertyName : 'personList',
				                indexedPropertyMemberNames : 'simpRule',
				                rowAddedListener : rowAdded,
				                rowRemovedListener : rowRemoved,
				                beforeSubmit : beforeSubmit
				            };
				            new DynamicListHelper(config);
				        });

						 function rowAdded(rowElement) {
						     //clear the imput fields for the row
						     $(rowElement).find("input").val('');
						     //may want to reset <select> options etc

						     //in fact you may want to submit the form
						     saveNeeded();
						 }
						 function rowRemoved(rowElement) {
						     saveNeeded();
						 }

						 function saveNeeded() {
						     $('#submit').css('color','red');
						     $('#submit').css('font-weight','bold');
						     if( $('#submit').val().indexOf('!') != 0 ) {
						         $('#submit').val( '!' + $('#submit').val() );
						     }
						 }

						 function beforeSubmit() {
						     alert('submitting....');
						     return true;
						 }

						 $(document).ready( function() {
						     var config = {
						         rowClass : 'ruleParameter',
						         addRowId : 'addPerson',
						         removeRowClass : 'removePerson',
						         formId : 'personListForm1',
						         rowContainerId : 'personListContainer3',
						         indexedPropertyName : 'personList',
						         indexedPropertyMemberNames : 'parameterName,parameterValue',
						         rowAddedListener : rowAdded,
						         rowRemovedListener : rowRemoved,
						         beforeSubmit : beforeSubmit
						     };
						     new DynamicListHelper(config);
						 });

		     
		
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

<form:form action="/CommissionTool/submitCompRule"
			modelAttribute="personListContainer3"  method="post"
			id="personListForm1">
			<div style="height: 580px; overflow: auto;">

		<div align="center">
			<h1>Compensation Rule Details</h1>


			<table border="1">
				<tr>
					<td><b>Rule name:</b></td>
					<td><input type="text" name="ruleName" value="${listRule1.ruleName}"><br /></td>
				</tr>
				<tr>
					<td><b>Description:</b></td>
					<td><input type="text" name="description" value="${listRule1.description}"></td>
				</tr>
				<tr>
					<td><b>Rule type:</b></td>
					<td>Composite<input type="hidden" name="ruleType" value="c">
					

				</tr>
				<tr>
					<td><b>Rules connected as: </b></td>
					<td><input type="checkbox" name="connectionType" value="All">&nbsp;All&nbsp;
						<input type="checkbox" name="connectionType" value="Any" checked>&nbsp;Any&nbsp;</td>
				</tr>


				
				<tr>
					<td><b>List of Rules</b></td>
					<td>
					
						<table>
							<tbody id="personListContainer2">
								<c:forEach items="${personListContainer2.personList}"
									var="Person" varStatus="i" begin="0">
									<tr class="person">
										<td><form:select path="personList[${i.index}].simpRule"
												id="simpRule${i.index}">
												<c:forEach items="${listSimpRule}" var="rule">
													<option value="${rule.ruleName}">
														<c:out value="${rule.ruleName}" />
													</option>
												</c:forEach>
											</form:select></td>

										<td><a href="#" class="removePerson1">&nbsp;Remove</a></td>
									</tr>
								</c:forEach>

								<c:if test="${personListContainer2.personList.size() == 0}">
									<tr class="person defaultRow">
										<td><select name="personList[].simpRule"><c:forEach
													items="${listSimpRule}" var="rule">
													<option value="${rule.ruleName}">
														<c:out value="${rule.ruleName}" />
													</option>
												</c:forEach>
										</select></td>

										<td><a href="#" class="removePerson1">&nbsp;Remove</a></td>

									</tr>
								</c:if>


							</tbody>
						</table>
						 <a href="#" id="addPerson1">Add&nbsp;</a>&nbsp;&nbsp; <a
						href="?f=">&nbsp;Reset List</a>
					</td>
				</tr>
				
				<tr>
					<td><b>Rule Parameter</b></td>
					<td>
						<table>
							<tbody id="personListContainer3">
								<c:forEach items="${parList}" var="par">
									
									<tr class="ruleParameter">
										<td>Parameter Name&nbsp;<input type="text" 
												 value="${par.parameterName}"/></td>
										<td>&nbsp;&nbsp;&nbsp;&nbsp;Parameter Value&nbsp;<input type="text"
												value="${par.parameterValue}"/></td>

										<td><a href="#" class="removePerson">&nbsp;Remove</a></td>
									</tr>
								</c:forEach>

								<c:if test="${personListContainer3.personList.size() == 0}">
									<tr class="person defaultRow">
										<td>Parameter Name&nbsp;<input type="text"
											name="personList[].parameterName" value="" /></td>
										<td>&nbsp;&nbsp;Parameter Value&nbsp;<input type="text"
											name="personList[].parameterValue" value="" /></td>

										<td><a href="#" class="removePerson">Remove</a></td>
									</tr>
								</c:if>

							</tbody>
						</table> <a href="#" id="addPerson">Add Parameters</a>&nbsp;&nbsp; <a
						href="?f=">Reset List</a>


					</td>

				</tr>
				
			<!-- 	
				<tr>
					<c:forEach items="${parList}"
										var="par">
											<td>Parameter Name&nbsp;<input type="text" value="${par.parameterName}"/></td>
											<td>&nbsp;Parameter Value&nbsp;<input type="text" value="${par.parameterValue}" /></td>
									
									</c:forEach>
					</tr>
			 -->
				<tr>
					<td><b>Compensation</b></td>
					<td><input type="checkbox" name="fixed" value="compensationType" value="Fixed">&nbsp;Fixed&nbsp;
						<input type="text" name="fixedCompValue" value="${listRule1.fixedCompValue}"><br /> <input
						type="checkbox" name="compensationType" value="Variable">&nbsp;Variable&nbsp;<br />
						&nbsp;Apply formula&nbsp;<input type="text" name="compensationFormula" value="${listRule1.compensationFormula}" ><br />
						<br />&nbsp; parameters&nbsp;<input type="text" name="compensationParameter" value="${listRule1.compensationParameter}"><br />
					</td>

				</tr>
				
			</table>
			<br/><input type="submit" value="Update"> <input
						type="submit" value="Submit" /> <a
						href="/CommissionTool/CompRule"> <input type="button"
							value="Cancel" /></a>
		</div>
		</div>
		</form:form>
	</tiles:putAttribute>
</tiles:insertDefinition>