function validate() {
	let username = document.getElementById("username");
	let mail = document.getElementById("mail");
	let bankAccNo = document.getElementById("bankAccNo");
	let transactionid = document.getElementById("transactionid");
	let toAccNo = document.getElementById("toAccNo");
	let password = document.getElementById("password");
	let confirmpassword = document.getElementById("confirmpassword");
	let amount = document.getElementById("amount");

	username.style.borderColor = "black";
	mail.style.borderColor = "black";
	bankAccNo.style.borderColor = "black";
	transactionid.style.borderColor = "black";
	toAccNo.style.borderColor = "black";
	password.style.borderColor = "black";
	confirmpassword.style.borderColor = "black";
	amount.style.borderColor = "black";

	if (username.value.trim() === "") {
		username.style.borderColor = "red";
		alert("Username cannot be empty");
		return false;
	} else if (username.value.length <= 5) {
		username.style.borderColor = "red";
		alert("Username must be more than five characters");
		return false;
	}

	if (bankAccNo.value.trim() === "") {
		bankAccNo.style.borderColor = "red";
		alert("Bank A/c No cannot be empty");
		return false;
	} else if (bankAccNo.value.length !== 11 || !/^\d+$/.test(bankAccNo.value)) {
		bankAccNo.style.borderColor = "red";
		alert("Invalid A/c No. A/c No must be 11 digits only");
		return false;
	}

	if (transactionid.value.trim() === "") {
		transactionid.style.borderColor = "red";
		alert("Transaction Id cannot be empty.");
		return false;
	} else if (transactionid.value.length !== 6 || !/^\d+$/.test(transactionid.value)) {
		transactionid.style.borderColor = "red";
		alert("Transaction Id must be 6 digits only");
		return false;
	}
	if (toAccNo.value.trim() === "") {
		toAccNo.style.borderColor = "red";
		alert("Bank A/c No cannot be empty");
		return false;
	} else if (toAccNo.value.length !== 11 || !/^\d+$/.test(toAccNo.value)) {
		toAccNo.style.borderColor = "red";
		alert("Invalid A/c No. A/c No must be 11 digits only");
		return false;
	}

	if (mail.value.trim() === "") {
		mail.style.borderColor = "red";
		alert("Email cannot be empty");
		return false;
	} else if (!validateEmail(mail.value.trim())) {
		mail.style.borderColor = "red";
		alert("Email is not valid");
		return false;
	}
	if (password.value.trim() === "") {
		password.style.borderColor = "red";
		alert("Password cannot be empty");
		return false;
	} else if (password.value.length <= 5) {
		password.style.borderColor = "red";
		alert("Password must be more than five characters");
		return false;
	} else if (password.value !== confirmpassword.value) {
		confirmpassword.style.borderColor = "red";
		alert("Passwords do not match");
		return false;
	}
	if (amount.value.trim() === "") {
		amount.style.borderColor = "red";
		alert("Amount cannot be empty");
		return false;
	} else if (amount.value < 0 || !/^\d+$/.test(amount.value)) {
		amount.style.borderColor = "red";
		alert("Invalid Amount");
		return false;
	}

	return true;
}

function validateEmail(email) {
	const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
	return re.test(String(email).toLowerCase());
}
