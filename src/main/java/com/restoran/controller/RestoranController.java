package com.restoran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.restoran.models.Booking;
import com.restoran.service.RestoranService;

@Controller
//@RequestMapping("/restoran")
public class RestoranController {

	@Autowired
	RestoranService restoranService;
	
	@RequestMapping("/")
	public String goToIndex() {
		return "index";
	}
	
	@RequestMapping("booking")
	public String goToBooking() {
		return "booking";
	}
	
	@RequestMapping("about")
	public String goToAbout() {
		return "about";
	}
	
	@RequestMapping("menu")
	public String goToMenu() {
		return "menu";
	}
	
	@RequestMapping("contact")
	public String goToContact() {
		return "contact";
	}
	
	@RequestMapping("service")
	public String goToService() {
		return "service";
	}
	
	@RequestMapping("team")
	public String goToTeam() {
		return "team";
	}
	
	@RequestMapping("testimonial")
	public String goToTestimonial() {
		return "testimonial";
	}
	
//	@PostMapping("/tableBooking")
//	public String tableBooking(@ModelAttribute Booking booking) {
//		restoranService.bookTable(booking);
//		return "Data inserted";
//	}
	
	@PostMapping("/tableBooking")
	public String tableBooking(@ModelAttribute Booking booking) {
		restoranService.bookTable(booking);
		return "booking";
	}
}
