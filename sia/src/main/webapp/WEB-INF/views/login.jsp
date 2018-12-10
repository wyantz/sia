<%
	request.setAttribute("contextName", request.getServletContext().getContextPath());
%>
<html>
<head>
<title>Login</title>
</head>
<body>
<form method="post" action="${contextName}/j_spring_security_check">
	<table>
		<tr>
			<td>User ID</td>
			<td><input type="text" name="username"></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td colspan="2"><button type="submit" value="Sign-in">Sign-In</button></td>
		</tr>
	</table>
</form>
</body>
</html>