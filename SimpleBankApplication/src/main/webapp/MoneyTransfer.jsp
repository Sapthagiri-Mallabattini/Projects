<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="MoneyTransfer.css">
<script src="SignUp.js"></script>
</head>
<body>
	<div>
		<form action="moneytransfer" method="post"
			onsubmit="return validate()">
			<h1 align="center">Money Transfer</h1>
			<table>
				<tr>
					<td colspan="2"><input type="text" id="bankAccNo" name="accno"
						placeholder="Enter your A/c No"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="text" id="transactionid"
						name="transactionid" placeholder="Enter a Transaction Id"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="text" id="toAccNo"
						name="toaccno" placeholder="To A/c No"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="text" id="amount"
						name="amount" placeholder="Enter a Amount"></td>
				</tr>
				<tr>
					<td><input type="submit" name="submit" value="Transfer"></td>
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