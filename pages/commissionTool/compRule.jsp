<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<tiles:insertDefinition name="defaultTemplate">
<tiles:putAttribute name="body">
<div align="center"><h3>Compensation Rules</h3></div>

<head>

<title>CompensationRule</title>

<link rel="stylesheet" href="resources/css/kendo.common.min.css" />
    <link rel="stylesheet" href="resources/css/kendo.default.min.css" />

    <script src="resources/js/jquery-1.12.1.min.js"></script>
    <script src="resources/js/kendo.all.min.js"></script>
    
    <script>
			

  
     			$(document).ready(function() {
                    $("#grid").kendoGrid({
                    	 pageSize: 10,
                    	 height: 400, 
                    	 //scrollable: {
                            //virtual: true
                         //},                                                
                          //scrollable: true,
                          sortable: true,
                          resizable: true,
                          reorderable: true,
                          groupable: false,
                          selectable: "multiple",
                          filterable: {
                        	  extra: false, 
                        	   operators: { 
                        	       string: {   
                        	            contains: "Contains",
                        	            startswith: "Starts With",
                        	            endswith: "Ends With",
                        	            //eq: "Is Equal To"
                        	        }
                        	    }
                        	}, 
                        	
                          columnMenu: true,                          
                          pageable: {
                             pageSize: 10,
       						 buttonCount: 10,
       						//numeric: true,
       						pageSizes: true,
       						refresh: true
                          },                                                                                                   
                    });                       
                });
     			
     			
   			</script>

</head>
<div id="example">

			<table id="grid">
                <colgroup>
                    <col />
                    <col />
                    <col style="width:110px" />
                    <col style="width:120px" />
                    <col style="width:130px" />
                </colgroup>
			 <thead>
				<tr>
					<th data-field="RuleName">Rule Name</th>
					<th data-field="type">Type</th>
					<th data-field="Description">Description</th>
					<th data-field="RuleDetails">Rule Details</th>
				</tr>
			</thead>
				
					<c:forEach items="${listRule}" var="rule">
								<tr>

									<td><a href="/CommissionTool/submitSimpRule">${rule.ruleName}</a></td>
									<td>${rule.ruleType}</td>
									<td>${rule.ruleDescription}</td>
									<td>${rule.ruleDescription}</td>
									
								</tr>

							</c:forEach>

			</table>
			<div align="center">
				<br />
				<input type="submit" value="Add composite Rule"> <input
					type="submit" value="Add simple rule">
			</div>
</div>

	</tiles:putAttribute>
</tiles:insertDefinition>