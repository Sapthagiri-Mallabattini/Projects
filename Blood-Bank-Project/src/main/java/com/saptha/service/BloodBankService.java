package com.saptha.service;

import java.util.List;
import java.util.Optional;

import com.saptha.model.BloodGroupDetails;
import com.saptha.model.RequestForBlood;

public interface BloodBankService {
	public List<BloodGroupDetails> fetchAllBloodBankDetails();

	public List<BloodGroupDetails> findDonors(String bloodgroup, String state, String district, String tehsil);

	public List<BloodGroupDetails> findBloodgroupType(String bloodgroup);
	
	public List<BloodGroupDetails> searchDonor(String searchType, String searchValue);
	
	public String registerBloodGroupDetails(BloodGroupDetails details);
	
	public Optional<BloodGroupDetails> findById(int id);
	
	public List<String> findMailId(BloodGroupDetails details);
	
	public String saveRequestForBlood(RequestForBlood details);
}
