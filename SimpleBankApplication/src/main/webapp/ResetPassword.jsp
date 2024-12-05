<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="ResetPassword.css">
<script src="ResetPassword.js"></script>
</head>
<body>
	<div>
		<form action="resetpassword" method="post"
			onsubmit="return validate()">
			<h1 align="center">Welcome Back</h1>
			<p align="center">Enter your new password</p>
			<table>
				<tr>
					<td colspan="2"><input type="text" id="name" name="name"
						placeholder="Enter your mail Id"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="password" id="newpassword"
						name="newpassword" placeholder="New Password"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="password" id="confirmpassword"
						name="confirmpassword" placeholder="Confirm Password"></td>
				</tr>
				<tr>
					<td><input type="submit" name="submit" value="Continue"></td>
					<td><a href="Login.jsp">Cancel</a></td>
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