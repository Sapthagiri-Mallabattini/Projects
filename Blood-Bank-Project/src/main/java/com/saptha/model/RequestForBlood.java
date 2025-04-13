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
import lombok.Data;

@Data
@Table(name="request_for_blood")
@Entity
public class RequestForBlood {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "blood_request_seq", sequenceName = "BLOOD_REQUEST_ID_SEQ", allocationSize = 1)
	private int id;
	@NotEmpty
	private String patientname;
	@NotEmpty
	private String doctorname;
	@NotEmpty
	private String hospitaladdress;
	@NotEmpty
	private String contactname;
	@NotEmpty
	@Pattern(regexp = "[0-9]{10}", message = "Enter a 10 digits numbers")
	private String mobileno;
	@NotEmpty
	private String dateneeded;
	@NotEmpty
	private String priority;
	@NotEmpty
	@Email(message = "Enter a valid email")
	private String email;
	@NotEmpty
	private String message;
}
