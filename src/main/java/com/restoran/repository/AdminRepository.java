package com.restoran.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restoran.models.Booking;
import com.restoran.models.Food;

public interface AdminRepository extends JpaRepository<Booking, Integer>{
	
}
