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
                formId : 'personListForm',
                rowContainerId : 'personListContainer',
                indexedPropertyName : 'personList',
                indexedPropertyMemberNames : 'parameterName,parameterValue',
                rowAddedListener : rowAdded,
                rowRemovedListener : rowRemoved,
                beforeSubmit : beforeSubmit
            };
            new DynamicListHelper(config);
        });
		
		
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


		 <form:form action="/CommissionTool/submitSimpRule" modelAttribute="personListContainer" method="post" id="personListForm">
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
							<td><b>Parameters</b></td>
							<td>
								<table>
                <tbody id="personListContainer">
                    <c:forEach items="${personListContainer.personList}" var="RuleParameter" varStatus="i" begin="0" >
                        <tr class="ruleParameter">    
                            <td>Parameter Name&nbsp;<form:input path="personList[${i.index}].parameterName" id="parameterName${i.index}" /></td>
                            <td>&nbsp;&nbsp;&nbsp;&nbsp;Parameter Value&nbsp;<form:input path="personList[${i.index}].parameterValue" id="parameterValue${i.index}" /></td>
                            
                            <td><a href="#" class="removePerson">&nbsp;Remove</a></td>
                        </tr>
                    </c:forEach>
                   
                    <c:if test="${personListContainer.personList.size() == 0}">
                        <tr class="person defaultRow">    
                            <td>Parameter Name&nbsp;<input type="text" name="personList[].parameterName" value="" /></td>
                            <td>&nbsp;&nbsp;Parameter Value&nbsp;<input type="text" name="personList[].parameterValue" value="" /></td>
 
                            <td><a href="#" class="removePerson">Remove</a></td>
                        </tr>
                    </c:if>
                    
                </tbody>
          </table>
		
            <a href="#" id="addPerson">Add Parameters</a>&nbsp;&nbsp;
             <a href="?f=">Reset List</a>
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
		
		</form:form>


	</tiles:putAttribute>
</tiles:insertDefinition>