<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Deposit.css">
<script src="Login.js"></script>
</head>
<body>
	<div>
		<h1 align="center">Deposit</h1>
		<form action="deposit" method="post" onsubmit="return validate()">
			<table>
				<tr>
					<td colspan="2"><input id="accno" type="text" name="accno"
						placeholder="Enter your A/c No"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="text" name="amount"
						placeholder="Enter a Amount"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" name="deposit"
						value="Deposit"></td>
				</tr>
				<tr>
					<td align="left">Home Page?</td>
					<td align="right"><a href="HomePage2.jsp">Click</a></td>
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