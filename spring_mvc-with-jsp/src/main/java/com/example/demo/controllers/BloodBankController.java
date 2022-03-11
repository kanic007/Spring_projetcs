package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.BloodDonor;
import com.example.demo.services.BloodDonorService;

@Controller
public class BloodBankController {

	@Autowired
	private BloodDonorService service;
	@Autowired
	private BloodDonor donor;
	
	
	@RequestMapping(value ="/")
	public String init(Model model) {
		model.addAttribute("heading","jeevan Blood Bank");
		return "index";
	}
	
	
	@RequestMapping(value ="/srchByGroup")
	public String initSearchForm(){
	
		return "srchByGroup";
	}
	

	
	@ModelAttribute(name="groups")
	public String[] getGroups() {
		
		return new String[] {"opos","bpos","apos","Aneg","Apos"};
	}
	
	@RequestMapping(value ="/add", method = RequestMethod.GET)
	public String addDonor(Model model) {
		model.addAttribute("command",donor);
		return "addDonor";
	}
	
	@RequestMapping(value ="/add", method = RequestMethod.POST)
	public String onSubmit(@Valid @ModelAttribute("command") BloodDonor donor,BindingResult result){
		
		if(result.hasErrors()) {
			return "addDonor";
		}else {
			this.service.add(donor);
			return "success";
		}
		
	}
	
	@RequestMapping(value ="/findAll")
	public String getAllDonors (Model model) {
		
		List<BloodDonor> list = this.service.findAll();
		
		model.addAttribute("list",list);
		
		return "showAll";
	}
	
	@RequestMapping(value = "/findByGroup")
	public String getAllDonorByBloodGroup(@RequestParam("group") String bloodGroup,Model model) {
		
		List<BloodDonor> list=this.service.findByBloodGroup(bloodGroup);
		model.addAttribute("list",list);
		return "showAll";
	}
	
	
	@RequestMapping(value = "/findByFirstName")
	public String getAllDonorName(@RequestParam("findByName") String firstName,Model model) {
		
		List<BloodDonor> list1=this.service.findbyFirstName(firstName);
		model.addAttribute("list",list1);
		return "showAll";
	}
	
	@RequestMapping(value ="/findByName")
	public String initSearchFormName(){
	
		return "findByName";
	}
}
