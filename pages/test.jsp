<%@page import="com.pursuit.salesCommission.app.api.TestClass"%>
<%@page language="java" import="java.util.*" %>
<html>
<body>
<%
String answer = TestClass.sendAnswer();
%>
This is the answer <%=answer %>
</body>
</html>