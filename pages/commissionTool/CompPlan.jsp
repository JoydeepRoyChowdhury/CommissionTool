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
    
    function openWindow() { 
    	  window.open("/CommissionTool/selectemp","_blank","height=200,width=400, status=yes,toolbar=no,menubar=no,location=no"); 
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
        
        $(document).ready(function(){
            $('input[type=radio][name=test2]').click(function(){
                var related_class=$(this).val();
                $('.'+related_class).prop('disabled',false);
                
                $('input[type=radio][name=test2]').not(':checked').each(function(){
                    var other_class=$(this).val();
                    $('.'+other_class).prop('disabled',true);
                });
            });
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
    
    
    var td2 = document.createElement("TD")
    var strHtml2 = "<Plan Name>High Performance &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp ";
    td2.innerHTML = strHtml2.replace(/!count!/g,count);
	
	var td3 = document.createElement("TD")
    var strHtml3 = "<Plan Description>Compensation rule for high performers &nbsp &nbsp&nbsp &nbsp&nbsp &nbsp &nbsp &nbsp&nbsp &nbsp&nbsp &nbsp ";
    td3.innerHTML = strHtml3.replace(/!count!/g,count);
	
	var td4 = document.createElement("TD")
    var strHtml4 = "<Detail>Parameter &nbsp &nbsp &nbsp Default value  &nbsp &nbsp Overwrite &nbsp &nbsp &nbsp ";
    td4.innerHTML = strHtml4.replace(/!count!/g,count);
	
	var td5 = document.createElement("TD")
    var strHtml5 = "<Action>&nbsp &nbsp &nbsp<INPUT TYPE=\"Button\" CLASS=\"Button\" onClick=\"delRow()\" VALUE=\"Delete\">";
    td5.innerHTML = strHtml5.replace(/!count!/g,count);
    
    row.appendChild(td1);
    row.appendChild(td2);
	row.appendChild(td3);
	row.appendChild(td4);
	row.appendChild(td5);

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


		<h1 align="center">Compensation Plan Assignment</h1>
		<table>
			<tr>
				<td>
					<table>
						<tr>
							<label for="radio1">
								<td><input type="radio" name="test1" value="radio1" />
									<b>Employee</b>
								</label>
							<br> Select Employee :&nbsp;&nbsp;
							<input type=image src="../../../image/search.png"
								name="for_radio1[]" class="radio1" disabled="true"
								onclick="openWindow()"/>&nbsp;&nbsp;&nbsp;&nbsp;

							<!--<input type="button" value="Select Name" onclick="SelectName()" />-->

							
							Selected Employee <input type="text" name="for_radio1[]"
								class="radio1" disabled="true" />

							

							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Or</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							</td>
							<td><label for="radio2"><input type="radio"
									name="test1" value="radio2" />Role </label> <br>Select Role : <select
									name="for_radio2[]" class="radio2" disabled="true">
									<option value="volvo">Systems Engineer</option>
									<option value="saab">Analyst</option>
									<option value="mercedes" selected="selected">Management
										support</option>
							</select></td>
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
						<tr>
							<td>Plan validity :</td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td><label for="radio10"> <input type="radio"
									name="test2" value="radio10" /> Fixed Date
							</label> &nbsp;&nbsp;&nbsp;&nbsp; From <input id="one" class="datepicker"
								type="text" readonly="false" name="for_radio10[]" class="radio10"
								disabled="false"> To <input id="two" class="datepicker"
								type="text" readonly="true" name="for_radio10[]" class="radio10"
								disabled="true"></td>
						</tr>
						<tr>
							<td></td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td>Or</td>
						</tr>
						<tr>
							<td></td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td><label for="radio20"> <input type="radio"
									name="test2" value="radio20" /> Repeats
							</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; From <input id="three"
								class="datepicker" type="text" readonly="true"
								name="for_radio20[]" class="radio20" disabled="true">

								Frequency <select name="for_radio20[]" class="radio20"
								disabled="true">
									<option value="volvo">Weekly</option>
									<option value="saab">Fortnightly</option>
									<option value="mercedes" selected="selected">Monthly</option>
									<option value="saab">Quarterly</option>
									<option value="saab">Annualy</option>
							</select> Ending On <input id="four" class="datepicker" type="text"
								readonly="true" name="for_radio20[]" class="radio20"
								disabled="true"></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>Selected Rule <br>
					<table ID="in_tbl_name" border="1">
						<tr>
							<td><b>Rule Id &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
							<td><b>Rule Name &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
							<td><b>Rule Description &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
							<td><b>Details &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
							<td><b>Action &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
							
						</tr>
						
							
					
					</table>
					<tr>
						<td colspan="3" align="right"><select><c:forEach items="${listRule}"
											var="rule">
											<option value="${rule}">
												<c:out value="${rule}" />
											</option>
										</c:forEach>
								</select></td>
					
						
					<td colspan="4" align="right"><input type="Button" onClick="addRow('in_tbl_name')"
						VALUE="Add New"></td>
						</tr>
									
					
					
									
				</td>
			</tr>
		</table>
		<br>
		<br>
		<input type="button" value="Update"></input>
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