package com.restoran.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restoran.models.Food;

public interface FoodRepository extends JpaRepository<Food, Integer>{
	
}
