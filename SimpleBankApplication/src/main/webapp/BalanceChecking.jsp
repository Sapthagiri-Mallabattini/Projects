<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="BalanceChecking.css">
<script src="SignUp.js"></script>
</head>
<body>
	<div>
		<h1 align="center">Balance Checking</h1>
		<form action="balancechecking" method="post"
			onsubmit="return validate()">
			<table>
				<tr>
					<td colspan="2"><input type="text" id="bankAccNo" name="bankAccNo"
						placeholder="Enter a A/c No"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="password" id="password" name="password"
						placeholder="Enter a Password"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" name="submit"
						value="Submit"></td>
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