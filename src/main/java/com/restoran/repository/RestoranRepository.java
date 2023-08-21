package com.restoran.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restoran.models.Booking;

public interface RestoranRepository extends JpaRepository<Booking, Integer>{
	
}
