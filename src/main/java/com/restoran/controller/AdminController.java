package com.restoran.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.restoran.models.Booking;
import com.restoran.service.AdminService;

@Controller
//@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	
    @RequestMapping("/dashboard")
    public String goToAdmin() {
        return "admin/dashboard";
    }
    
    @RequestMapping("/requestlist")
    public String bookingReq(Model model) {
    	fetchReq(model);
    	return "admin/bookingTable";
    }
    
    public void fetchReq(Model model) {
    	List<Booking> items = adminService.AllRequests();
		model.addAttribute("items", items);
    }
}
