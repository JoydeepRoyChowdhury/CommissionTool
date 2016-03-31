<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
       
 <tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">

		

      <!--    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
        <script src="js/dynamic_list_helper.js" type="text/javascript"></script> -->
        <title>JSP Page</title>
    
    
        <h3>Parameter List</h3>
        <div style="border:1px solid #eaeaea;padding:20px;width:400px">
            ${message}
        </div>
        <form:form action="/CommissionTool/editpersonlistcontainer"  method="post" id="personListForm1">
            <table>
                <thead>
                    <tr>
                        <th>Parameter Name</th>
                        <th>Parameter Val</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody id="personListContainer2">
                    <c:forEach items="${personListContainer1.personList}" var="Person" varStatus="i" begin="0" >
                        <tr class="person">    
                            <td><form:select path="personList[${i.index}].value" id="value${i.index}"><c:forEach items="${listCompRule1}"
											var="rule"><option value="${rule.ruleName}">
												<c:out value="${rule.ruleName}" />
											</option>
										</c:forEach></form:select></td>
                           <!--  
                            <td><form:input path="personList[${i.index}].age" id="age${i.index}"/></td>
                           -->
                            <td><form:select path="personList[${i.index}].conditionValue" id="conditionValue${i.index}"><option value="Equal">Equal</option><option value="Greater than">Greater than</option><option value="Less than">Less than</option></form:select></td>
                             <td><form:input path="personList[${i.index}].fieldList" id="fieldName${i.index}" /></td>
                            <td><a href="#" class="removePerson1">Remove Person</a></td>
                        </tr>
                    </c:forEach>
                   
                    <c:if test="${personListContainer1.personList.size() == 0}">
                        <tr class="person defaultRow">    
                            <td><select name="personList[].value"><c:forEach items="${listCompRule1}"
											var="rule">
											<option value="${rule.ruleName}">
												<c:out value="${rule.ruleName}" />
											</option>
										</c:forEach>
								</select></td>
                           <!--  
                            <td>&nbsp;Not&nbsp;<input type="text" name="personList[].age" value="not" ></td>
 							-->
 							<td>Condition&nbsp;<select name="personList[].conditionValue"><option value="Equal">Equal</option><option value="Greater than">Greater than</option><option value="Less than">Less than</option></select></td>
                            <td>&nbsp;Parameter Name&nbsp;<input type="text" name="personList[].fieldName"></td>
                            <td><a href="#" class="removePerson1">Remove Person</a></td>
                        
                        </tr>
                    </c:if>
                
                    
                </tbody>
            </table>
            <input type="submit" value="Save" id="submit" />&nbsp;&nbsp;
            <a href="#" id="addPerson1">Add Person</a>&nbsp;&nbsp;
            <a href="?f=">Reset List</a>
        </form:form>
 
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
                    indexedPropertyMemberNames : 'value,conditionValue,fieldName',
                    rowAddedListener : rowAdded,
                    rowRemovedListener : rowRemoved,
                    beforeSubmit : beforeSubmit
                };
                new DynamicListHelper(config);
            });
        </script>
 
    </tiles:putAttribute>
</tiles:insertDefinition>