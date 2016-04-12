<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div align="center">
			<h2>Order Management</h2>
			<h4>List Of Imports</h4>
		</div>

		<head>

<title>OrderManagement</title>

<link rel="stylesheet" href="resources/css/kendo.common.min.css" />
<link rel="stylesheet" href="resources/css/kendo.default.min.css" />

<script src="resources/js/jquery-1.12.1.min.js"></script>
<script src="resources/js/kendo.all.min.js"></script>

<script>

	function HandleBrowseClick() {
		var fileinput = document.getElementById("browse");
		fileinput.click();
	}
	function Handlechange() {
		var fileinput = document.getElementById("browse");
		var textinput = document.getElementById("filename");
		textinput.value = fileinput.value;
	}

	$(document).ready(function() {
		$("#grid").kendoGrid({
			pageSize : 10,
			height : 400,
			//scrollable: {
			//virtual: true
			//},                                                
			//scrollable: true,
			sortable : true,
			resizable : true,
			reorderable : true,
			groupable : false,
			selectable : "multiple",
			filterable : {
				extra : false,
				operators : {
					string : {
						contains : "Contains",
						startswith : "Starts With",
						endswith : "Ends With",
					//eq: "Is Equal To"
					}
				}
			},

			columnMenu : true,
			pageable : {
				pageSize : 10,
				buttonCount : 10,
				//numeric: true,
				pageSizes : true,
				refresh : true
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
					<col style="width: 110px" />
					<col style="width: 120px" />
					<col style="width: 130px" />
				</colgroup>
				<thead>
					<tr>
						<th data-field="ImportId">Import Id</th>
						<th data-field="ImportDate">Import Date</th>
						<th data-field="CountOfOrders">Count Of Orders</th>
						<th data-field="ImportedBy">Imported By</th>
						<th data-field="Status">Status</th>

					</tr>
				</thead>
				
					<c:forEach items="${listOrder}" var="order">
						<tr>


							<td><a href="/CommissionTool/orderDetails">${order.id}</a></td>
							<td>${order.importDate}</td>
							<td>${order.countOfOrders}</td>
							<td>${order.importedBy.employeeName}</td>
							<td>${order.status}</td>

						</tr>
					
				</c:forEach>


			</table>
		</div>
		<br/><table align="center">
		   <tr>
    
		      <center><td> Import new: </td>
		      <td><input type="file" id="browse" name="fileupload" style="display: none" onChange="Handlechange();"/>
				<input type="text" id="filename" readonly="true"/>
				<input type="button" value="Select File" id="fakeBrowse" onclick="HandleBrowseClick();"/></td>
			<td>&nbsp;<input type="button" value="Import" onclick="HandleClick();" /></td>
		  </tr>
	  </table>

	</tiles:putAttribute>
</tiles:insertDefinition>