<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Bank Home Page</title>
<link rel="stylesheet" href="HomePage.css">
<script type="text/javascript">
function handleSignOut() {
    if (confirm("Are you sure you want to sign out?")) {
        window.location.href = "SignOut.jsp"; 
    }
}
</script>
</head>
<body>
	<header>
		<div class="logo">
			<h1>OurBank</h1>
		</div>
		<nav>
			<ul>
				<li><a href="#" class="active">Home</a>
					<ul>
						<li><a href="#">About Us</a></li>
						<li><a href="#">OurBank History</a></li>
					</ul></li>
				<li><a href="#">Deposits</a>
					<ul>
						<li><a href="Deposit.jsp">Fixed Deposit</a></li>
						<li><a href="#">Recurring Deposit</a></li>
					</ul></li>
				<li><a href="#">Accounts</a>
					<ul>
						<li><a href="#">Savings</a></li>
						<li><a href="BalanceChecking.jsp">Checking</a></li>
						<li><a href="Withdraw.jsp">Withdraw</a></li>
						<li><a href="#">Business Accounts</a></li>
						<li><a href="#">Transaction History</a></li>
					</ul></li>
				<li><a href="#">Payments</a>
					<ul>
						<li><a href="MoneyTransfer.jsp">Money Transfer</a></li>
						<li><a href="#">Credit Card Bill Payment</a></li>
						<li><a href="#">Bill Payments & Recharges</a></li>
					</ul></li>
				<li><a href="#" onclick="handleSignOut()">Sign Out</a>
					<ul>
					</ul></li>
			</ul>
		</nav>
	</header>

	<section class="hero">
		<div class="hero-text">
			<h2>Welcome to OurBank</h2>
			<p>Your trusted financial partner</p>
			<button>Learn More</button>
		</div>
	</section>

	<footer>
		<p>© 2024 OurBank. All rights reserved.</p>
	</footer>
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
