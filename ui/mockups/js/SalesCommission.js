function showMenu() {
	var menuTxt = '';
	menuTxt += '<ul class="menu">';
	menuTxt += '<li class="menu"><a href="#">Master Data</a>';
	menuTxt += '<ul class="menu"> ';
	menuTxt += '<li class="menu"><a href="../employee/EmployeeList.html">Employee</a></li>';
	menuTxt += '<li class="menu"><a href="#">Role</a></li>';
	menuTxt += '<li class="menu"><a href="../orgStructure/OrgStructure.html">Org Structure</a></li>';
	menuTxt += '<li class="menu"><a href="../compRule/CompRule.html">Comp Rule</a></li>';
	menuTxt += '<li class="menu"><a href="../rollup/RollupRule.html">Credit Rollup Rule</a></li>';
	menuTxt += '</ul> ';
	menuTxt += '</li>';
	menuTxt += '<li class="menu"><a href="#">Booking</a>';
	menuTxt += '<ul class="menu"> ';
	menuTxt += '<li class="menu"><a href="#">Orders / Booking</a></li>';
	menuTxt += '</ul> ';
	menuTxt += '</li>';
	menuTxt += '<li class="menu"><a href="#">Comp Plan</a>';
	menuTxt += '<ul class="menu"> ';
	menuTxt += '<li class="menu"><a href="../compPlan/CompPlan.html">Assign Comp Plan</a></li>';
	menuTxt += '</ul> ';
	menuTxt += '</li>';
	menuTxt += '<li class="menu"><a href="#">Compensation</a>';
	menuTxt += '<ul class="menu"> ';
	menuTxt += '<li class="menu"><a href="#">Employee Comp Report</a></li>';
	menuTxt += '</ul> ';
	menuTxt += '</li>';
	menuTxt += '</ul>';
	$("#menu").html(menuTxt);
	$("#buffer").html('&nbsp;<br>&nbsp;<br>&nbsp;<br>&nbsp;<br>&nbsp;<br>&nbsp;<br>&nbsp;<br>');
}

function showCancel() {
	var cancelTxt = '';
	cancelTxt += '<input type="button" value="Cancel" onclick="javascript:window.history.back();"></input>';
	document.write(cancelTxt);
}
function footer() {
	document.write("About Copyright");
}
function printChooseEmployee() {
	var empTxt = '';
	empTxt += '<img onclick="window.open(\'../employee/EmployeeSelection.html\', \'empSearch\', \'toolbar=no, location=no, status=no, menubar=no, scrollbars=no, resizable=no, height=400, width=600\')" src="../../image/search.png" style="width:30px;height:20px;"/>';
	document.write(empTxt);
}
