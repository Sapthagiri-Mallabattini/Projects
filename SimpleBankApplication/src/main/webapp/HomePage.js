var modal = document.getElementById("loginModal");
var loginBtn = document.getElementById("loginBtn");
var closeBtn = document.getElementsByClassName("close")[0];

loginBtn.onclick = function() {
	modal.style.display = "flex";
}

closeBtn.onclick = function() {
	modal.style.display = "none";
}

window.onclick = function(event) {
	if (event.target == modal) {
		modal.style.display = "none";
	}
}

