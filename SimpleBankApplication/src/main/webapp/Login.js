 function validate() {
	let username = document.getElementById("username");
	username.style.borderColor = "black";
	let password = document.getElementById("password");
	password.style.borderColor = "black";
	if (username.value.trim() == "") {
		username.style.borderColor = "red";
		window.alert("Invalid Username");
		username.value = "";
		return false;
	} else if (username.value.length <= 5) {
		username.style.borderColor = "red";
		window.alert("Invalid Username");
		username.value = "";
		return false;
	} else if (password.value.trim() == "") {
		password.style.borderColor = "red";
		window.alert("Invalid Password");
		password.value = "";
		return false;
	} else if (password.value.length <= 5) {
		password.style.borderColor = "red";
		window.alert("Invalid Password");
		password.value = "";
		return false;
	} else {
		return true;
	}
}
function validateEmail(email) {
	const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
	return re.test(String(email).toLowerCase());
}

