package com.restoran.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restoran.models.Booking;

public interface AdminRepository extends JpaRepository<Booking, Integer>{
	
}
