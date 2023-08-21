package com.restoran.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restoran.models.Booking;
import com.restoran.repository.RestoranRepository;

@Service
public class RestoranService {
	
	@Autowired
	RestoranRepository restoranRepository;
	
	public void bookTable(Booking booking) {
		restoranRepository.save(booking);
	}
}
