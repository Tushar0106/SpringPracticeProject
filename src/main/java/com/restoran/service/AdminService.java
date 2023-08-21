package com.restoran.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restoran.models.Booking;
import com.restoran.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	AdminRepository adminRepository;
	
	public List<Booking> AllRequests() {
		List<Booking> reqList = new ArrayList<Booking>();
		adminRepository.findAll().forEach(reqList::add);
		return reqList;
	}
}
