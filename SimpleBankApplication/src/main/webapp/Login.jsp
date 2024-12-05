<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="login.css">
<script src="SignUp.js"></script> 
</head>
<body>
	<div id="message">
		<h1 align="center">Sign in</h1>
		<form action="loginservlet" method="post" onsubmit="return validate()">
			<table>
				<tr>
					<td colspan="2"><input type="text" id="mail" name="mail" placeholder="Username"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="password" id="password" name="password"
						placeholder="Password"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" name="submit" value="SIGN IN"></td>
				</tr>
				<tr>
					<td align="left"><a href="ResetPassword.jsp">Forgot
							Password?</a></td>
					<td align="right"><a href="SignUp.jsp">SignUp</a></td>
				</tr>
			</table>
		</form>
	</div>
	<%
	String message = (String) request.getAttribute("message");
	if (message != null) {
	%>
	<script>
            alert("<%=message%>");
	</script>
	<%
	}
	%>
</body>
</html>