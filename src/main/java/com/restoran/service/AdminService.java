package com.restoran.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restoran.models.Booking;
import com.restoran.models.Food;
import com.restoran.repository.AdminRepository;
import com.restoran.repository.FoodRepository;

@Service
public class AdminService {

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	FoodRepository foodRepository;
	
	//All requests list
	public List<Booking> AllRequests() {
		List<Booking> reqList = new ArrayList<Booking>();
		adminRepository.findAll().forEach(reqList::add);
		return reqList;
	}
	
	//Insert food data
	public void addFood(Food food) {
		foodRepository.save(food);
	}
	
	//All food list
	public List<Food> foodList() {
		List<Food> foodList = new ArrayList<Food>();
		foodRepository.findAll().forEach(foodList::add);
		return foodList;
	}
	
	//New update food 
	public Food updateFood(int foodId, String foodName, String desc, String price, String imageName) {
		Food existFood = foodRepository.findById(foodId).orElse(null);
		
		if(existFood != null) {
			existFood.setFoodName(foodName);
			existFood.setDesc(desc);
			existFood.setPrice(price);
			existFood.setImageName(imageName);
			return foodRepository.save(existFood);
		} else {
			return null;
		}
	}
	//Old update food
//	public void updateFood(Food food) {
//		if(foodRepository.existsById(food.getFoodId())) {
//			System.out.println(food);
//			foodRepository.save(food);
//		} else {
//			System.out.println("Food Id Not Found!!");
//		}
//	}
	
	//Find one row food by ID
	public Optional<Food> getFoodById(Integer foodId) {
		return foodRepository.findById(foodId); 
	}
	
	
}
