<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
 <head>
    <title>Add Employee</title>
</head>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
<div id="page-wrapper">
   
            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h3 class="page-header">
                            Employees Details
                        </h3>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="index.html">Master Data</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-edit"></i> Employee
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-6">

                        <form role="form">
							
							<div class="form-group">
                                <label>Employee Id</label>
                                <input class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Employee Name</label>
                                <input class="form-control">
                            </div>
                             <div class="form-group">
                                <label>Salary</label>
                                <input class="form-control">
                            </div>
							<!--   <div class="form-group">
                                <label>Start Date</label>
                                <input class="form-control">
                            </div>
                           <div class="form-group">
                                <label>Termination Date</label>
                                <input class="form-control">
                            </div>
							<div class="form-group">
                                <label>Role</label>
                                <input class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Job Title</label>
                                <input class="form-control">
                            </div>
                           
                            <div class="form-group">
                                <label>Manager Id</label>
                                <input class="form-control">
                            </div>  -->
                            <button type="submit" value="Submit" class="btn btn-default">Submit</button>
                            <button type="reset" class="btn btn-default">Cancel</button>
</form>
  </div></div></div></div>
 
    </tiles:putAttribute>
</tiles:insertDefinition>