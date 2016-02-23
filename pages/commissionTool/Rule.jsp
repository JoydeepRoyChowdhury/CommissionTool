<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>insert records</title>
</head>
<body>
	<form action="/CommissionTool/sub" method="post">

		<b>Ruleid:</b><input type="number" name="Ruleid"/><br/><br/><br/>
		<b>Rulename:</b><input type="text" name="Rulename"/><br/><br/><br/>
	    <b>Ruledescription:</b><input type="text" name="Ruledescription" /><br/><br/><br/>
	    <b>RuleType:</b><input type="text" name="Ruletype" /><br><br><br>
		<input type="submit" value="Submit"/>

	</form>
</body>
</html>