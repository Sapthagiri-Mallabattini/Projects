<%@page import="com.bean.TransactionBean"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Transaction History</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 20px;
	background-color: #f4f4f9;
}

h1 {
	text-align: center;
	color: #333;
}

table {
	margin: 20px auto;
	border-collapse: collapse;
	width: 90%;
}

table, th, td {
	border: 1px solid #ddd;
}

th, td {
	padding: 10px;
	text-align: center;
}

th {
	background-color: #4CAF50;
	color: white;
}

tr:nth-child(even) {
	background-color: #f9f9f9;
}

tr:hover {
	background-color: #f1f1f1;
}
</style>
</head>
<body>
	<h1>Transaction History</h1>
	<table>
		<thead>
			<tr>
				<th>Date</th>
				<th>Time</th>
				<th>Transaction ID</th>
				<th>Type</th>
				<th>Amount</th>
			</tr>
		</thead>
		<tbody>
			<%
			List<TransactionBean> transactions = (List<TransactionBean>) request.getAttribute("transactions");
			if (transactions != null && !transactions.isEmpty()) {
				for (TransactionBean tb : transactions) {
			%>
			<tr>
				<td><%=tb.getDate()%></td>
				<td><%=tb.getTime()%></td>
				<td><%=tb.getTransactionId()%></td>
				<td><%=tb.getType()%></td>
				<td><%=tb.getAmount()%></td>
			</tr>
			<%
			}
			} else {
			%>
			<tr>
				<td colspan="5">No transactions to display.</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>
