<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="SignUp.css">
<script src="SignUp.js"></script>
</head>
<body>
	<div>
		<h1 align="center">Sign Up</h1>
		<p align="center">Create your account</p>
		<form action="signup" method="post" onsubmit="return validate()">
			<table>
				<tr>
					<td colspan="2"><input type="text" id="username"
						name="username" placeholder="Username"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="text" id="mail" name="mail"
						placeholder="Email"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="text" id="bankAccNo"
						name="bankAccNo" placeholder="Bank AccNo"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="text" id="transactionid"
						name="transactionid" placeholder="Transaction Id"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="password" id="password"
						name="password" placeholder="Password"></td>
				</tr>

				<tr>
					<td colspan="2"><input type="password" id="confirmpassword"
						name="confirmpassword" placeholder="Confirm Password"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" name="submit"
						value="SIGN UP"></td>
				</tr>
				<tr>
					<td align="left">Already have an account?</td>
					<td align="right"><a href="Login.jsp">Login</a></td>
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