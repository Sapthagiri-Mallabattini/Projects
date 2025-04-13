package com.saptha.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "BLOOD_BANK")
public class BloodGroupDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "blood_donor_seq", sequenceName = "BLOOD_BANK_ID_SEQ", allocationSize = 1)
	private int id;
	@NotEmpty
	private String name;
	@NotEmpty
	@Pattern(regexp = "[0-9]{10}", message = "Enter a 10 digits numbers")
	private String mobileno;
	@NotEmpty
	@Size(max = 6, message = "Enter a 6 digits numbers")
	private String pincode;
	@NotEmpty
	private String state;
	@NotEmpty
	private String district;
	@NotEmpty
	private String tehsil;
	@NotEmpty
	private String bloodgroup;
	@NotEmpty
	private String gender;
	@NotEmpty
	private String joiningdate;
	@NotEmpty
	@Email(message = "Enter a valid email")
	private String email;
	
}
