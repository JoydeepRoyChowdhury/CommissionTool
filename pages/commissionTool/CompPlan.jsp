<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
	<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
<head>
	<title>CompPlan</title>
	<link rel="stylesheet" href="resources/css/jquery-ui.css" />
	<link rel="stylesheet" href="resources/css/style.css" />

	<script src="resources/js/jquery.1.12.1.min.js"></script>
	<script src="resources/js/jquery-ui.js"></script>
</head>
<script>	

    function openWindow(){
    	window.open('/CommissionTool/search' , '' , 'width=1400,height=700,scrollbars=yes');
    	}
        
        $(document).ready(function(){
            $('input[type=radio][name=test1]').click(function(){
                var related_class=$(this).val();
                $('.'+related_class).prop('disabled',false);
                
                $('input[type=radio][name=test1]').not(':checked').each(function(){
                    var other_class=$(this).val();
                    $('.'+other_class).prop('disabled',true);
                });
            });
        });
        
        
        
       /* $(document).ready(function(){
            $('input[type=radio][name=test2]').click(function(){
                var related_class=$(this).val();
                $('.'+related_class).prop('disabled',false);
                
                $('input[type=radio][name=test2]').not(':checked').each(function(){
                    var other_class=$(this).val();
                    $('.'+other_class).prop('disabled',true);
                });
            });
        });*/
       
        $(document).ready(function() {
         	$(document).on('click', 'input[type=radio][name=test]', function() 
        		{ var related_class = $(this).val(); 
        	$('.' + related_class).prop('disabled', false); 
        	
        	$('input[type=radio][name=test]').not(':checked').each(function()
        		 { var other_class = $(this).val(); 
        	$('.' + other_class).prop('disabled', true); 
        	}); 
        });
     });   
        
   var count = "1";    
   var GLOBAL_INIT = {
       changeMonth: true,
       changeYear: true,
       depth: "year",
       showOn: 'both',
       buttonImageOnly: true,
       };
  
 /* function addRow(in_tbl_name)
  {
	 
    var tbody = document.getElementById(in_tbl_name);
    var row = document.createElement("TR");
    
    var td1 = document.createElement("TD")
    var strHtml1 = "<Rule Id> 1";
    td1.innerHTML = strHtml1.replace(/!count!/g,count);
	//var RuleArray=new Array();
    
    //RuleArray= "${listRule}";
   // var len=RuleArray.length;
    
    var td2 = document.createElement("TD")
    var strHtml2 = "<Rule Details> Simple";
    td2.innerHTML = strHtml2.replace(/!count!/g,count);
	
	var td3 = document.createElement("TD")
    var strHtml3 = "<Fixed><input type=\"radio\" NAME=\"test\" VALUE=\"radio10\">  &nbsp &nbsp";
    td3.innerHTML = strHtml3.replace(/!count!/g,count);
	
	var td4 = document.createElement("TD")
    var strHtml4 = "<Repeats > <input type=\"radio\" NAME=\"test\" VALUE=\"radio20\"> &nbsp &nbsp &nbsp &nbsp<select NAME=\"for_radio20[]\" class=\"radio20\" disabled=\"true\"><OPTION VALUE=\"1\">Weekly<OPTION VALUE=\"2\">Fortnightly<OPTION VALUE=\"3\">Monthly<OPTION VALUE=\"4\">Quarterly<OPTION VALUE=\"5\">Annually</SELECT>&nbsp &nbsp ";
    td4.innerHTML = strHtml4.replace(/!count!/g,count);
	
    
    var td5 = document.createElement("TD")
    var strHtml5 = "<From><INPUT CLASS=\"datepicker\" type=\"Text\">";
    td5.innerHTML = strHtml5.replace(/!count!/g, count);

    var td6 = document.createElement("TD")
    var strHtml6 = "<To><INPUT CLASS=\"datepicker\" type=\"Text\">";
    td6.innerHTML = strHtml6.replace(/!count!/g, count);
    
    var td7 = document.createElement("TD")
    var strHtml7 = "<Parameter> MIN_SALES &nbsp &nbsp ";
    td7.innerHTML = strHtml7.replace(/!count!/g,count);
    
    var td8 = document.createElement("TD")
    var strHtml8 = "<Default value> 10000  &nbsp &nbsp &nbsp";
    td8.innerHTML = strHtml8.replace(/!count!/g,count);
    
    var td9 = document.createElement("TD")
    var strHtml9 = "<Overwrite><INPUT TYPE=\"text\"Name =\"text1\">&nbsp &nbsp or &nbsp &nbsp <select><option value=\"1\">Null1<option value=\"2\">Null2<option value=\"3\">Null3";
    td9.innerHTML = strHtml9.replace(/!count!/g,count);
    
    var td10 = document.createElement("TD")
    var strHtml10 = "<Action>&nbsp &nbsp &nbsp<INPUT TYPE=\"Button\" CLASS=\"Button\" onClick=\"delRow()\" VALUE=\"Delete\">";
    td10.innerHTML = strHtml10.replace(/!count!/g,count);
    
    row.appendChild(td1);
    row.appendChild(td2);
	row.appendChild(td3);
	row.appendChild(td4);
	row.appendChild(td5);
	row.appendChild(td6);
	row.appendChild(td7);
	row.appendChild(td8);
	row.appendChild(td9);
	row.appendChild(td10);
	
	
    count = parseInt(count) + 1;
    tbody.appendChild(row);
    
    $('.datepicker').datepicker(GLOBAL_INIT);
    }*/
  
  function delRow()
  {
    var current = window.event.srcElement;
    //here we will delete the line
    while ( (current = current.parentElement)  && current.tagName !="TR");
         current.parentElement.removeChild(current);
  }
    
    $(function() {
    	   $('input').filter('.datepicker').datepicker({
    	      changeMonth: true,     
    	     changeYear: true,
    	      depth: "year",
    	      showOn: 'button',      
    	      buttonImage: '../Image/Calendar_Icon_32.png',
    	      buttonImageOnly: true
    	     });
 });
    
    function refreshPage(){
        window.location.reload();
    } 
    
  /*  $(document).ready(function(){
        document.getElementById("text1").value = localStorage.getItem("value");	
    });

    $(window).on('beforeunload', function() {
        localStorage.setItem("value",document.getElementById("text1").value);	
    }); */     
       
</script>



		<h1 align="center">Compensation Plan Assignment</h1></br>
		<table>
		
			<tr>
				<td>
				  
					<table>
						<tr>
						  <td>
							<label for="radio1">
									<input type="radio" name="test1" value="radio1" /><b>Employee</b>
							</label><br>	
							   Select Employee :&nbsp;&nbsp;
							<input type="image" img src="resources/image/search.png" style="height:30px;width:30px; name="for_radio1[]" class="radio1" disabled="true" onclick="openWindow()"/> &nbsp;&nbsp;&nbsp;&nbsp;
						   </td>	
						<td>
							<form action="/CommissionTool/searchemp" method="post" >
							Selected Employee <input type="text"  name="EmployeeName" id="text1" name="for_radio1[]" class="radio1" disabled="true" size="11" />
											  <input type ="submit" value="check">
							
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Or</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							</form>
						</td>
							
							
							<td>
							<form action="/CommissionTool/Submitrole" method="post" model="command">
							<label for="radio2"><input type="radio" name="test1" value="radio2"  />Role </label><br>
							Select Role : <select  name="roleName"  class="radio2" disabled="true" style="width: 80px;">
												<c:forEach items="${listRole}"
													var="role">
													<option value="${role.roleName}">
														
														<c:out value="${role.roleName}" />
													</option>
												</c:forEach>
										</select>
										<input type="submit" value ="Check" style="height:25px;width:50px"onClick="refreshPage()" >
										</form></td>
							
						</tr>
						
					</table>
					
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>

			<tr>
				<td>
					<table>
						<!--  <tr>
							<td>Plan validity :</td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td><label for="radio10"> <input type="radio" name="test2" value="radio10" /> Fixed Date
							</label> &nbsp;&nbsp;&nbsp;&nbsp;
													 From <input id="one" class="datepicker radio10" type="text" readonly="false" name="for_radio10[]" disabled="true">&nbsp;&nbsp;&nbsp;&nbsp;
													   To <input id="two" class="datepicker radio10" type="text" readonly="true" name="for_radio10[]" disabled="true"></td>
						</tr>
						<tr>
							<td></td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td>Or</td>
						</tr>
						<tr>
							<td></td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td><label for="radio20"> <input type="radio" name="test2" value="radio20" />
							 Repeats
							</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
							
							From <input id="three" class="datepicker radio20" type="text" readonly="true" name="for_radio20[]" class="radio20" disabled="true"> &nbsp;&nbsp;

								Frequency <select name="for_radio20[]" class="radio20" disabled="true">
									<option value="volvo">Weekly</option>
									<option value="saab">Fortnightly</option>
									<option value="mercedes" selected="selected">Monthly</option>
									<option value="saab">Quarterly</option>
									<option value="saab">Annualy</option>
							</select> &nbsp;&nbsp;
							
							Ending On <input id="four" class="datepicker radio20" type="text" readonly="true" name="for_radio20[]" class="radio20" disabled="true"></td>
						</tr>-->
					</table>
				</td>
			</tr>
			<tr>
				<td>Selected Rule <br>
					<!--  <table ID="in_tbl_name" border="2">
					<c:if test="${not empty List2}">-->
					<!-- <table border="1">
				<thead>
				 <tr rowspan="4">
							<th data-field="id" >Id &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></th>
							<th data-field="details">RuleDetails &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
							<th data-field="fixed" >Fixed &nbsp;&nbsp;&nbsp;</b></th>
							<th data-field="repeats" >Repeats  &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></th>
							<th data-field="from" >From &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></th>
							<th data-field="to" >To &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></th>
							<th data-field="parameter">Parameter&nbsp;&nbsp;|&nbsp;&nbsp; Value &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
							<th data-field="overwrite" >Overwrite &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></th>
							 <td><b>Action  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
						</tr>
				</thead>		
							<tr>
						  	<c:forEach items="${List2}" var="as">
								<td>${as.id}</td>
								<td>${as.ruleName}</td>
								
								<td > &nbsp;&nbsp;<input type="radio" NAME="test" VALUE="radio10" style="vertical-align: middle"></td>
								<td ><input type="radio" NAME="test" VALUE="radio20"> <select NAME="for_radio20[]" class="radio20" disabled= "true" style="width: 70px;"><c:forEach items="${listRule2}" var="obj2"><option>
                                 <c:out value="${obj2}" />
                                </option></c:forEach></select></td>
								<td>&nbsp;<input id="one" class="datepicker" type="text" size="11"height="0.10"></td>
								<td>&nbsp;<input id="two" class="datepicker" type="text"size="11"height="0.10"></td>
								<table border="1">
								
							    <c:forEach items="${as.ruleParameter}" var="asss">	
								<tr>
									<td >${asss.parameterName}</td>									
									<td >${asss.parameterValue}</td>	
								</tr>
								</c:forEach>
								</table>
								<td height="50">&nbsp;<INPUT TYPE="text" Name ="text1" size="5" height="0.10">&nbsp;or&nbsp;<select style="width: 110px;"><c:forEach items="${listRule3}" var="obj3"><option>
                                    <c:out value="${obj3}" />
                                </option></c:forEach></select></td>
							<!--  -<td><input type="button" class="button" onClick="delRow()" value="delete"></td>-->	
							<!--	</c:forEach>
							</tr>-->							
						
					<!--</table>-->
					
			<table border="1">
				<thead>
					<tr>
						<th data-field="id" width="30">ID&nbsp;&nbsp;&nbsp;</th>
						<th data-field="details" width="20">RuleName&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
						<th data-field="fixed" width="40">Fixed&nbsp;&nbsp;&nbsp;</th>
						<th data-field="repeats" width="80">Repeats&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
						<th data-field="from" width="130">From&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
						<th data-field="to" width="130">To&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
						<th data-field="parameter" width="180">Parameter&nbsp;|&nbsp; Value &nbsp;</th>
						<th data-field="overwrite" width="200">Overwrite&nbsp;|&nbsp; Value &nbsp;</th>
						<!--  <th data-field="value">Value&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>--> 
					</tr>
				</thead>
				<c:forEach items="${List2}" var="as">
				<tr >
					<td>${as.id}</td>	
					<td>${as.ruleName}</td>
					<td>&nbsp;&nbsp;<input type="radio" NAME="test" VALUE="radio10" style="vertical-align: middle"></td>
					<td>&nbsp;&nbsp; <input type="radio" NAME="test" VALUE="radio20"> <select NAME="for_radio20[]" class="radio20" disabled= "true" style="width: 70px;"><c:forEach items="${listRule2}" var="obj2"><option>
                                 <c:out value="${obj2}" />
                                </option></c:forEach></select></td>
                     <td>&nbsp;<input id="one" class="datepicker" type="text" size="11"height="0.10"></td>
                     <td>&nbsp;<input id="two" class="datepicker" type="text" size="11"height="0.10"></td>           
                                
					<td>
						<div>
						
							<table>
							<c:forEach items="${as.ruleParameter}" var="asss">	
								<tr>
									<td >${asss.parameterName} &nbsp;&nbsp;|&nbsp;&nbsp;</td> 									
									<td >${asss.parameterValue}</td>	
								</tr>
							</c:forEach>
						 </table>
					</div>
					</td>
					<td>&nbsp;&nbsp; <input type="text" NAME="text1" size="6"height="0.10">&nbsp;or&nbsp; <select><c:forEach items="${listRule2}" var="obj2"><option>
                                 <c:out value="${obj2}" />
                                </option></c:forEach></select></td>				
				</tr>							
				</c:forEach>	
  		</table>
			</c:if>
					<!--  <form action="/CommissionTool/SubmitRule" method="post" model="command">
					<table>-->
			</td></tr>
					<tr>
						<td colspan="7" align="right"><select name="id"><c:forEach items="${listRules}" var="rule">
                                <option>
                                    <c:out value="${rule.id}" />
                                </option>
                </c:forEach>
            </select>
								</td>	
					<!--<td colspan="8" align="right"><input type="submit" onClick="addRow('in_tbl_name')"
						VALUE="AddRow"></td>-->
						<td><input type="Button" onClick="addRow('in_tbl_name')"
									VALUE="Add New"></td>
									
									
						</tr>	
						
						
				</table>
				<!--</form>-->
		</table>
		<c:forEach items="${List1}" var="ass">
								<input type="text" value="${ass.id}">
								</c:forEach>
		<br>
		<br>
		<input type="button" value="Update"></input>
		<!--  <button type="button" onClick="refreshPage()">Refresh</button>-->
		<script>
		showCancel();
	</script>

		<script>
		footer();
		$("#planParameter1").load("components/planParameters.html");
		$("#planParameter2").load("components/planParameters.html");
	</script>
	</tiles:putAttribute>
</tiles:insertDefinition>