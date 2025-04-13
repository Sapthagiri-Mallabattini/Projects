package com.saptha.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.saptha.model.BloodGroupDetails;
import com.saptha.model.RequestForBlood;
import com.saptha.repository.IBloodBankRepository;
import com.saptha.repository.IBloodBankRepository1;

import jakarta.mail.internet.MimeMessage;

@Service("bloodBankService")
public class BloodBankServiceImpl implements BloodBankService {

	@Autowired
	private IBloodBankRepository bloodRepo;
	@Autowired
	private IBloodBankRepository1 bloodRepo1;
	@Autowired
	private JavaMailSender sender;

	@Override
	public List<BloodGroupDetails> fetchAllBloodBankDetails() {
		return bloodRepo.findAll();
	}

	@Override
	public List<BloodGroupDetails> findDonors(String bloodgroup, String state, String district, String tehsil) {
		return bloodRepo.findByBloodgroupAndStateAndDistrictAndTehsil(bloodgroup, state, district, tehsil);
	}

	@Override
	public List<BloodGroupDetails> findBloodgroupType(String bloodgroup) {
		return bloodRepo.findByBloodgroup(bloodgroup);
	}

	@Override
	public List<BloodGroupDetails> searchDonor(String searchType, String searchValue) {
		switch (searchType) {
		case "Bloodgroup":
			return bloodRepo.findByBloodgroup(searchValue);
		case "State":
			return bloodRepo.findByState(searchValue);
		case "District":
			return bloodRepo.findByDistrict(searchValue);
		default:
			return bloodRepo.findAll();
		}
	}

	@Override
	public String registerBloodGroupDetails(BloodGroupDetails donor) {
		BloodGroupDetails saveDonor = bloodRepo.save(donor);
		return "Details saved with id:" + saveDonor.getId();
	}

	@Override
	public Optional<BloodGroupDetails> findById(int id) {
		return bloodRepo.findById(id);
	}

	public String sendMails(@ModelAttribute("req") RequestForBlood req,
			@ModelAttribute("details") BloodGroupDetails details, String fromMail, String[] toMails) throws Exception {

		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setFrom(fromMail);
		helper.setTo(toMails);
		helper.setSubject("open it to know it");
		helper.setSentDate(new Date());
		helper.setText(req.getMessage() + "\nPatient Name: " + req.getPatientname() + "\nPriority: " + req.getPriority()
				+ "\nBlood Group: " + details.getBloodgroup() + "\nBlood Needed: " + req.getDateneeded() + "\nAddress: "
				+ details.getTehsil() + "," + details.getDistrict() + "," + details.getState() + "\nHospital Address: "
				+ req.getHospitaladdress() + "\nContact Details:" + "\nName: " + req.getContactname() + "\nPhone No: "
				+ req.getMobileno() + "\nEmail: " + req.getEmail());

		sender.send(message);

		return "Mail sent successfully...";
	}

	@Override
	public List<String> findMailId(BloodGroupDetails details) {
		return bloodRepo.findEmails(details.getBloodgroup(), details.getState(), details.getDistrict(),
				details.getTehsil());
	}

	@Override
	public String saveRequestForBlood(RequestForBlood details) {
		RequestForBlood saveDetails = bloodRepo1.save(details);
		return "Details saved with id:" + saveDetails.getId();
	}
}
