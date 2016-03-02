<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<spring:url value="/resources/css/style.css" var="styleCss" />
<spring:url value="/resources/js/index.js" var="indexJs" />

<link href="${styleCss}" rel="stylesheet" />
<script src="${indexJs}"></script>

<title>Login</title>
</head>

<body>

	<div class="vid-container">
		<video id="Video1" class="bgvid back" autoplay="false" muted="muted"
			preload="auto" loop>
			<source
				src="http://shortcodelic1.manuelmasiacsasi.netdna-cdn.com/themes/geode/wp-content/uploads/2014/04/milky-way-river-1280hd.mp4.mp4"
				type="video/mp4">
		</video>
		<div class="inner-container">
			<video id="Video2" class="bgvid inner" autoplay="false" muted="muted"
				preload="auto" loop>
				<source
					src="http://shortcodelic1.manuelmasiacsasi.netdna-cdn.com/themes/geode/wp-content/uploads/2014/04/milky-way-river-1280hd.mp4.mp4"
					type="video/mp4">
			</video>
			<div class="box">
				<form:form method="POST" name="loginForm"
					action="/CommissionTool/submit">
					<h1 style="font-family: serif;">Welcome!</h1>
					<h1 style="font-family: serif;">Sales Commission Tool</h1>
					<input name="userName" type="text" placeholder="Username" />
					<input name="password" type="password" placeholder="Password" />
					<input type="submit" value="Login">

					<div style="color: red">${error}</div>
				</form:form>
			</div>
		</div>
	</div>
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>


</body>
</html>
