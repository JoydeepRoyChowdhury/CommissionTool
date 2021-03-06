<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div align="center">
			<h3>Import Orders</h3>
		</div>

		<head>

<title>OrderDetails</title>

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
			<table id="grid">
				<colgroup>
					<col />
					<col style="width: 130px" />
					<col />
					<col />
					<col style="width: 110px" />
					<col style="width: 120px" />
					<col style="width: 130px" />
				</colgroup>
				<thead>
					<tr>
						<th data-field="id">Order Id</th>
						<th data-field="orderDate">Order Date</th>
						<th data-field="salesRepresentative">Sales Representative</th>
						<th data-field="supportEngineer">Support Engineer</th>
						<th data-field="administrator">Administrator</th>
						<th data-field="customerName">Customer</th>
						<th data-field="orderTotal">Order Total</th>
					</tr>
				</thead>

				<c:forEach items="${ordetails}" var="ord">
					<tr>
					
						<td>${ord.id}</td>
						<td>${ord.orderDate}</td>
						<td>${ord.salesRepresentative.employeeName}</td>
						<td>${ord.supportEngineer.employeeName}</td>
						<td>${ord.administrator.employeeName}</td>
						<td>${ord.customer.customerName}</td>
						<td>${ord.orderTotal}</td>
					</tr>

				</c:forEach>


			</table>
		
	</tiles:putAttribute>
</tiles:insertDefinition>