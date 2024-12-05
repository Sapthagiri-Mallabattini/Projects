function validate() {
	let newpassword = document.getElementById("newpassword");
	let confirmpassword = document
		.getElementById("confirmpassword");

	newpassword.style.borderColor = "black";
	confirmpassword.style.borderColor = "black";

	if (newpassword.value.trim() == "") {
		newpassword.style.borderColor = "red";
		alert("New Password cannot be empty");
		return false;
	} else if (newpassword.value.length <= 5) {
		newpassword.style.borderColor = "red";
		alert("New Password must be more than five characters");
		return false;
	} else if (confirmpassword.value.trim() == "") {
		confirmpassword.style.borderColor = "red";
		alert("Confirm Password cannot be empty");
		return false;
	} else if (newpassword.value !== confirmpassword.value) {
		confirmpassword.style.borderColor = "red";
		alert("Passwords do not match");
		return false;
	} else {
		return true;
	}
}
