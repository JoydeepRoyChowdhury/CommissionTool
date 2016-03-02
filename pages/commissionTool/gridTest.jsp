<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>View</title>
    
    <link rel="stylesheet" href="resources/css/kendo.common.min.css" />
    <link rel="stylesheet" href="resources/css/kendo.default.min.css" />

    <script src="resources/js/jquery-1.12.1.min.js"></script>
    <script src="resources/js/kendo.all.min.js"></script>
    
     
      <script>
                $(document).ready(function() {
                    $("#grid").kendoGrid({
                    	 pageSize: 20,
                    	  height: 550,
                          scrollable: true,
                          sortable: true,
                          filterable: false,
                          pageable: {
                        	  refresh: true,
                              pageSizes: true,
                              buttonCount: 5
                          },
                        
                    });
                });
            </script>
</head>
<body>

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
                        <th data-field="id">Id</th>
                        <th data-field="roleName">Role Name</th>
                        <th data-field="description">Description</th>
                        <th data-field="reportTo">Report To</th>
                         <th data-field="editdelete">Edit/Delete</th>
                       
                    </tr>
                </thead>
                <tbody>
                   <c:forEach items="${listRole}" var="role">
							<tr>
							
								<td>${role.id}</td>
								<td>${role.roleName}</td>
								<td>${role.description}</td>
								<td>${role.reportTo}</td>
								<td><a
									href="<c:url value='/editRole/${role.id}' />">Edit</a>
									| <a href="<c:url value='/deleterole/${role.id}' />">Delete</a></td>
							
								
							</tr>
							
						</c:forEach>
						
						
					</table>
                </tbody>
       <div class="well">
					<a href="<c:url value='/role' />">Add Role</a>
				</div>
           
        </div>
</body>
</html>