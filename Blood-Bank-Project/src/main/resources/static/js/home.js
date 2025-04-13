document.addEventListener("DOMContentLoaded", function () {
    loadStates();

    document.getElementById("state").addEventListener("change", function () {
        loadDistricts(this.value);
    });

    document.getElementById("district").addEventListener("change", function () {
        loadTehsils(document.getElementById("state").value, this.value);
    });

    document.getElementById("find-blood").addEventListener("click", function () {
		let bloodgroup = document.getElementById("bloodgroup").value;
		    let state = document.getElementById("state").value;
		    let district = document.getElementById("district").value;
		    let tehsil = document.getElementById("tehsil").value;

		    if (!bloodgroup || !state || !district || !tehsil) {
		        alert("Please select all fields!");
				event.preventDefault(); 
		        return;
		    }
    });
	
	document.getElementById("search").addEventListener("click", function () {
			    let state = document.getElementById("state").value;
			    let district = document.getElementById("district").value;

			    if (!state || !district) {
			        alert("Please select all fields!");
					event.preventDefault();
			        return;
			    }
	    });
		function donorDetails () {
			alert("Donor Details Submited!");
			window.location.href="/blood/registerBloodDonor";
		};
});

const data = {
	"Andhra Pradesh": {
	        "Anantapur": ["Anantapur", "Hindupur", "Tadipatri", "Gooty"],
	        "Chittoor": ["Chittoor", "Tirupati", "Madanapalle", "Punganur"],
	        "East Godavari": ["Kakinada", "Rajahmundry", "Amalapuram", "Peddapuram"]
	    },
	    "Arunachal Pradesh": {
	        "Tawang": ["Tawang", "Jang", "Lumla"],
	        "Itanagar": ["Naharlagun", "Banderdewa", "Doimukh"]
	    },
	    "Assam": {
	        "Guwahati": ["Guwahati", "Dispur", "Azara"],
	        "Jorhat": ["Jorhat", "Teok", "Titabor"]
	    },
	    "Bihar": {
	        "Patna": ["Patna Sadar", "Danapur", "Barh", "Masaurhi"],
	        "Muzaffarpur": ["Muzaffarpur", "Kanti", "Motipur", "Sahebganj"]
	    },
	    "Chhattisgarh": {
	        "Raipur": ["Raipur", "Abhanpur", "Arang"],
	        "Bilaspur": ["Bilaspur", "Takhatpur", "Mungeli"]
	    },
	    "Goa": {
	        "North Goa": ["Panaji", "Mapusa", "Bicholim"],
	        "South Goa": ["Margao", "Vasco da Gama", "Quepem"]
	    },
	    "Gujarat": {
	        "Ahmedabad": ["Ahmedabad City", "Dholka", "Dhandhuka"],
	        "Surat": ["Surat City", "Bardoli", "Olpad"]
	    },
	    "Haryana": {
	        "Gurgaon": ["Gurgaon", "Sohna", "Pataudi"],
	        "Faridabad": ["Faridabad", "Ballabgarh", "Tigaon"]
	    },
	    "Himachal Pradesh": {
	        "Shimla": ["Shimla", "Rohru", "Rampur"],
	        "Kangra": ["Dharamshala", "Palampur", "Nurpur"]
	    },
	    "Jharkhand": {
	        "Ranchi": ["Ranchi", "Kanke", "Ormanjhi"],
	        "Dhanbad": ["Dhanbad", "Jharia", "Sindri"]
	    },
	    "Karnataka": {
	        "Bangalore Urban": ["Bangalore South", "Bangalore North", "Anekal"],
	        "Mysore": ["Mysore", "Nanjangud", "Tirumakudal Narsipur"]
	    },
	    "Kerala": {
	        "Thiruvananthapuram": ["Thiruvananthapuram", "Neyyattinkara", "Attingal"],
	        "Ernakulam": ["Ernakulam", "Aluva", "Muvattupuzha"]
	    },
	    "Madhya Pradesh": {
	        "Bhopal": ["Bhopal", "Huzur", "Berasia"],
	        "Indore": ["Indore", "Mhow", "Sanwer"]
	    },
	    "Maharashtra": {
	        "Mumbai": ["Mumbai City", "Mumbai Suburban", "Kurla"],
	        "Pune": ["Pune City", "Shirur", "Baramati"]
	    },
	    "Manipur": {
	        "Imphal": ["Imphal East", "Imphal West", "Moirang"],
	        "Churachandpur": ["Churachandpur", "Singngat", "Thanlon"]
	    },
	    "Meghalaya": {
	        "Shillong": ["Shillong", "Nongpoh", "Mawsynram"],
	        "Tura": ["Tura", "Ampati", "Baghmara"]
	    },
	    "Mizoram": {
	        "Aizawl": ["Aizawl", "Lunglei", "Champhai"],
	        "Saiha": ["Saiha", "Lawngtlai", "Kolasib"]
	    },
	    "Nagaland": {
	        "Kohima": ["Kohima", "Chümoukedima", "Tseminyu"],
	        "Dimapur": ["Dimapur", "Medziphema", "Niuland"]
	    },
	    "Odisha": {
	        "Bhubaneswar": ["Bhubaneswar", "Jatni", "Khurda"],
	        "Cuttack": ["Cuttack", "Salipur", "Banki"]
	    },
	    "Punjab": {
	        "Amritsar": ["Amritsar", "Tarn Taran", "Ajnala"],
	        "Ludhiana": ["Ludhiana", "Jagraon", "Khanna"]
	    },
	    "Rajasthan": {
	        "Jaipur": ["Jaipur", "Sanganer", "Chomu"],
	        "Jodhpur": ["Jodhpur", "Osian", "Luni"]
	    },
	    "Sikkim": {
	        "Gangtok": ["Gangtok", "Rongli", "Pakyoung"],
	        "Mangan": ["Mangan", "Chungthang", "Lachen"]
	    },
	    "Tamil Nadu": {
	        "Chennai": ["Chennai North", "Chennai South", "Chennai Central"],
	        "Madurai": ["Madurai North", "Madurai South", "Vadipatti"]
	    },
	    "Telangana": {
	        "Hyderabad": ["Hyderabad", "Secunderabad", "LB Nagar"],
	        "Warangal": ["Warangal", "Kazipet", "Jangaon"]
	    },
	    "Tripura": {
	        "Agartala": ["Agartala", "Khowai", "Sonamura"],
	        "Udaipur": ["Udaipur", "Bishalgarh", "Belonia"]
	    },
	    "Uttar Pradesh": {
	        "Lucknow": ["Lucknow Sadar", "Malihabad", "Bakshi Ka Talab"],
	        "Kanpur": ["Kanpur City", "Ghatampur", "Bilhaur"]
	    },
	    "Uttarakhand": {
	        "Dehradun": ["Dehradun", "Rishikesh", "Mussoorie"],
	        "Haridwar": ["Haridwar", "Roorkee", "Laksar"]
	    },
	    "West Bengal": {
	        "Kolkata": ["Kolkata North", "Kolkata South", "Alipore"],
	        "Darjeeling": ["Darjeeling", "Siliguri", "Kurseong"]
	    }
	};

function loadStates() {
    let stateSelect = document.getElementById("state");
    stateSelect.innerHTML = '<option value="">Select State</option>'; 

    Object.keys(data).forEach(state => {
        let option = document.createElement("option");
        option.value = state;
        option.textContent = state;
        stateSelect.appendChild(option);
    });
}

function loadDistricts(state) {
    let districtSelect = document.getElementById("district");
    let tehsilSelect = document.getElementById("tehsil");

    districtSelect.innerHTML = '<option value="">Select District</option>';
    tehsilSelect.innerHTML = '<option value="">All Tehsil</option>'; 

    if (state && data[state]) {
        Object.keys(data[state]).forEach(district => {
            let option = document.createElement("option");
            option.value = district;
            option.textContent = district;
            districtSelect.appendChild(option);
        });
    }
}

function loadTehsils(state, district) {
    let tehsilSelect = document.getElementById("tehsil");
    tehsilSelect.innerHTML = '<option value="">All Tehsil</option>'; 

    if (state && district && data[state][district]) {
        data[state][district].forEach(tehsil => {
            let option = document.createElement("option");
            option.value = tehsil;
            option.textContent = tehsil;
            tehsilSelect.appendChild(option);
        });
    }
}
function validation(frm) {
    document.getElementById("nameErr").innerHTML = "";
    document.getElementById("mobilenoErr").innerHTML = "";
    document.getElementById("bloodGroupErr").innerHTML = "";
    document.getElementById("genderErr").innerHTML = "";
    document.getElementById("pincodeErr").innerHTML = "";
    document.getElementById("stateErr").innerHTML = "";
    document.getElementById("districtErr").innerHTML = "";
    document.getElementById("tehsilErr").innerHTML = "";

    let name = frm.name.value.trim();
    let mobileno = frm.mobileno.value.trim();
    let bloodgroup = frm.bloodgroup.value;
    let gender = frm.gender.value;
    let pincode = frm.pincode.value.trim();
    let state = frm.state.value;
    let district = frm.district.value;
    let tehsil = frm.tehsil.value;

    let vflag = true;

    if (name === "") {
        document.getElementById("nameErr").innerHTML = "Donor name is mandatory.";
        vflag = false;
    } else if (name.length < 5 || name.length > 15) {
        document.getElementById("nameErr").innerHTML = "Donor name must be 5-15 characters.";
        vflag = false;
    }

    if (mobileno === "") {
        document.getElementById("mobilenoErr").innerHTML = "Mobile number is mandatory.";
        vflag = false;
    } else if (!/^\d{10}$/.test(mobileno)) {
        document.getElementById("mobilenoErr").innerHTML = "Enter a valid 10-digit mobile number.";
        vflag = false;
    }

    if (bloodgroup === "") {
        document.getElementById("bloodGroupErr").innerHTML = "Please select a blood group.";
        vflag = false;
    }

    if (gender === "") {
        document.getElementById("genderErr").innerHTML = "Please select gender.";
        vflag = false;
    }

    if (pincode === "" || !/^\d{6}$/.test(pincode)) {
        document.getElementById("pincodeErr").innerHTML = "Enter a valid 6-digit pincode.";
        vflag = false;
    }

    if (state === "") {
        document.getElementById("stateErr").innerHTML = "Please select a state.";
        vflag = false;
    }

    if (district === "") {
        document.getElementById("districtErr").innerHTML = "Please select a district.";
        vflag = false;
    }

    if (tehsil === "") {
        document.getElementById("tehsilErr").innerHTML = "Please select tehsil.";
        vflag = false;
    }
	frm.vflag1.value="yes";

    return vflag;
}
