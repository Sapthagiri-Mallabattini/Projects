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
		<h1 align="center">Withdraw</h1>
		<form action="withdraw" method="post" onsubmit="return validate()">
			<table>
				<tr>
					<td colspan="2"><input type="text" id="bankAccNo" name="bankAccNo"
						placeholder="Enter your A/c No"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="text" id="amount" name="amount"
						placeholder="Enter a Amount"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="password" id="password"
						name="password" placeholder="Enter a Password"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" name="submit"
						value="Withdraw"></td>
				</tr>
				<tr>
					<td align="left"><a href="ResetPassword.jsp">ResetPassword?</a></td>
					<td align="right"><a href="HomePage2.jsp">HomePage?</a></td>
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