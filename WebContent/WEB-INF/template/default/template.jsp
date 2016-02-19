<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">


<spring:url value="/resources/css/bootstrap.min.css" var="mainCss" />
<spring:url value="/resources/css/sb-admin.css" var="mainCss1" />
<spring:url value="/resources/font-awesome/css/font-awesome.min.css"
	var="mainCss2" />
<spring:url value="/resources/js/jquery.js" var="jqueryJs" />
<spring:url value="/resources/js/bootstrap.min.js" var="mainJs" />

<link href="${mainCss}" rel="stylesheet" />
<link href="${mainCss1}" rel="stylesheet" />
<link href="${mainCss2}" rel="stylesheet" type="text/css" />
<script src="${jqueryJs}"></script>
<script src="${mainJs}"></script>
<style type="text/css">
body {
	margin: 0px;
	padding: 0px;
	height: 100%;
	overflow: hidden;
}

.page {
	min-height: 100%;
	position: relative;
}

.header {
	padding: 10px;
	width: 100%;
	text-align: center;
}

.content {
	padding: 10px;
	padding-bottom: 20px; /* Height of the footer element */
	overflow: hidden;
}

.menu {
	padding: 50px 10px 0px 10px;
	width: 20px;
	float: left;
}

.body {
	margin: 50px 10px 0px 250px;
}

.footer {
	clear: both;
	position: absolute;
	bottom: 0;
	left: 0;
	text-align: center;
	width: 100%;
	height: 20px;
}
</style>
</head>
<body>
	<div id="wrapper">
		<div class="page">
			<tiles:insertAttribute name="header" />
			<div class="content">
			<div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
				<tiles:insertAttribute name="menu" />
				</ul>
				</div>
				<div id="page-wrapper">

            <div class="container-fluid">
				
				<tiles:insertAttribute name="body" />
			</div>
			</div>
			</div>
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
</body>
</html>