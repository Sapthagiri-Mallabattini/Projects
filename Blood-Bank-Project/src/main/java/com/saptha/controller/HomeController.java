package com.saptha.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.saptha.model.BloodGroupDetails;
import com.saptha.model.RequestForBlood;
import com.saptha.service.BloodBankServiceImpl;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/blood")
public class HomeController {

	@Autowired
	private BloodBankServiceImpl bloodBankService;

	@Value("${spring.mail.username}")
	private String fromMail;

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/findDonor")
	public String findBloodDonor(Map<String, Object> map,
			@RequestParam(name = "bloodgroup", required = false) String bloodgroup,
			@RequestParam(name = "state", required = false) String state,
			@RequestParam(name = "district", required = false) String district,
			@RequestParam(name = "tehsil", required = false) String tehsil) {
		List<BloodGroupDetails> donors = bloodBankService.findDonors(bloodgroup, state, district, tehsil);
		map.put("bloodGroupInfo", donors);
		return "showDetails";
	}

	@GetMapping("/showAllBloodGroupDetails")
	public String showReport(Map<String, Object> map) {
		List<BloodGroupDetails> list = bloodBankService.fetchAllBloodBankDetails();
		map.put("bloodGroupInfo", list);
		return "showDetails";
	}

	@GetMapping("/searchType")
	public String state(Map<String, Object> map, @RequestParam(name = "searchType", required = false) String searchType,
			@RequestParam(name = "searchValue", required = false) String searchValue) {
		List<BloodGroupDetails> list = bloodBankService.searchDonor(searchType, searchValue);
		map.put("bloodGroupInfo", list);
		return "showDetails";
	}

	@GetMapping("/bloodgroup")
	public String bloodgroup(Map<String, Object> map, @RequestParam(name = "name", required = false) String name) {
		List<BloodGroupDetails> list = bloodBankService.findBloodgroupType(name);
		map.put("bloodGroupInfo", list);
		return "showDetails";
	}

	@GetMapping("/bloodBank")
	public String bloodbank() {
		return "bloodBank";
	}
	@GetMapping("/allBloodGroupList")
	public String allBloodGroupList() {
		return "all_blood_group_list";
	}

	@GetMapping("/findBloodGroups")
	public String findBloodGroup(Map<String, Object> map,
			@RequestParam(name = "bloodgroup", required = false) String bloodgroup) {
		List<BloodGroupDetails> list = bloodBankService.findBloodgroupType(bloodgroup);
		map.put("bloodGroupInfo", list);
		return "showDetails";
	}

	@GetMapping("/requestForBlood")
	public String requestForBlood() {
		return "requestforblood";
	}

	@PostMapping("/sendMail")
	public String sendMail(HttpSession ses, @Valid @ModelAttribute("req") RequestForBlood req,
			@ModelAttribute("details") BloodGroupDetails details, BindingResult error) throws Exception {
		if (error.hasErrors()) {
			return "requestforblood";
		}
		List<String> toMails = bloodBankService.findMailId(details);
		String status = bloodBankService.sendMails(req, details, fromMail, toMails.toArray(new String[0]));

		String msg = bloodBankService.saveRequestForBlood(req);
		System.out.println("patient details saved with ID: " + req.getId());
		System.out.println(status);
		ses.setAttribute("resultMsg", msg);
		return "index";
	}

	@GetMapping("/blogs")
	public String blogs() {
		return "blogs";
	}

	@GetMapping("/findBloodDonor")
	public String findBloodDonor() {
		return "findBloodDonor";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@PostMapping("/registerBloodDonor")
	public String processRegisterDonorDetails(HttpSession ses, @Valid @ModelAttribute("donor") BloodGroupDetails donor,
			BindingResult errors) {
		System.out.println(donor.toString());

		if (errors.hasErrors()) {
			return "register"; 
		}

		String msg = bloodBankService.registerBloodGroupDetails(donor);
		System.out.println("Donor saved with ID: " + donor.getId());
		ses.setAttribute("resultMsg", msg);

		return "index";
	}

	@GetMapping("/details/{id}")
	public String visit(@PathVariable int id, Model model) {

		Optional<BloodGroupDetails> optionalDonor = bloodBankService.findById(id);

		if (optionalDonor.isPresent()) {
			model.addAttribute("donor", optionalDonor.get());
		} else {
			return "redirect:/error";
		}
		return "visit";
	}
}