package com.restoran.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.restoran.models.Booking;
import com.restoran.models.Food;
import com.restoran.repository.FoodRepository;
import com.restoran.service.AdminService;


@Controller
//@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	@Autowired
	FoodRepository foodRepository;

	@RequestMapping("/dashboard")
	public String goToAdmin() {
		return "admin/dashboard";
	}

	@RequestMapping("/404")
	public String notFound() {
		return "admin/notfound404";
	}

	//Fine all rowa
	@RequestMapping("/requestlist")
	public String bookingReq(Model model) {
		fetchReq(model);
		return "admin/bookingTable";
	}

	public void fetchReq(Model model) {
		List<Booking> items = adminService.AllRequests();
		model.addAttribute("items", items);
	}
	
	//Find one row food by ID
		public Optional<Food> getFoodById(@NonNull Integer foodId) {
			return foodRepository.findById(foodId); 
		}

	@RequestMapping("/addFood")
	public String add() {
		return "admin/addFood";
	}

	@PostMapping("/addFood")
	public String handleFileUpload(
			@RequestParam("foodName") String foodName, 
			@RequestParam("desc") String desc,			
			@RequestParam("price") String price, 
			@RequestParam("imageData") MultipartFile imageData, 
			Model model)
			throws IOException {

		String originalFileName = imageData.getOriginalFilename();
		String uploadDirectory = "C:/Users/tushar.khobragade/eclipse-workspace/restoran/src/main/resources/static/uploads/";
		// Save food data to the database
		Food food = new Food();
		food.setFoodName(foodName);
		food.setDesc(desc);
		food.setPrice(price);
		food.setImageName(originalFileName);
		
//		if (!isValidImage(imageData)) {
//            model.addAttribute("errorMessage", "Only JPG, and JPEG images are allowed.");
//            return "admin/addFood";
//        }
		
        // Set the path for saving the file
        Path uploadPath = Paths.get(uploadDirectory);

        // Create the directory if it doesn't exist
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Concatenate the file name to the upload directory
        Path filePath = uploadPath.resolve(originalFileName);

        // Save the file to the specified location
        Files.copy(imageData.getInputStream(), filePath);
        adminService.addFood(food);
        
        
		model.addAttribute("successMessage", "Food item uploaded successfully");
		return "admin/addFood";
	}
	
//	private boolean isValidImage(MultipartFile file) {
//        // Get the original file name
//        String originalFileName = file.getOriginalFilename();
//
//        // Check if the file extension is one of the allowed types
//        return originalFileName != null && (originalFileName.endsWith(".png")
//        		|| originalFileName.endsWith(".jpg")
//                || originalFileName.endsWith(".jpeg"));
//    }
	
	@RequestMapping("/foodlistAPI")
	public List<Food> foodListAPI() {
		List<Food> items = adminService.foodList();
		return items;
	}

	@RequestMapping("/foodlist")
	public String foodList(Model model) {
		fetchFoodList(model);
		return "admin/foodlist";
	}

	public void fetchFoodList(Model model) {
		List<Food> foodItems = adminService.foodList();
		model.addAttribute("foodItems", foodItems);
	}

	@RequestMapping("/showedit/{foodId}")
	public String showEdit(@PathVariable("foodId") Integer foodId, Model model) {
		String page = null;
		Optional<Food> food = adminService.getFoodById(foodId);
		if (food.isPresent()) {
			model.addAttribute("food", food.get());
			page = "admin/editfood";
		} else {
			model.addAttribute("message", "Food '" + foodId + "' is Not Available!!");
			page = "admin/foodlist";
		}
		return page;
	}


	@PostMapping("/update")
	public String uploadFood(@RequestBody Food food, Model model) throws IOException {
	    String uploadDirectory = "C:/Users/tushar.khobragade/eclipse-workspace/restoran/src/main/resources/static/uploads/";

	    // Save the file
	    String imgName = food.getImageName();
	    String photoPath = uploadDirectory + imgName;

	    // Assuming 'imageName' is the file content, adjust accordingly if needed
	    try (FileOutputStream fos = new FileOutputStream(photoPath)) {
	        fos.write(food.getImageName().getBytes());
	    }

	    // Save food data to the database
	    Food result = adminService.updateFood(food.getFoodId(), food.getFoodName(), food.getDesc(), food.getPrice(), imgName);

	    if (result != null) {
	        model.addAttribute("message", "Food '" + food.getFoodId() + "' Updated!!");
	        // also load the latest data
	        fetchFoodList(model);
	        return "employeelist";
	    } else {
	        // Handle not found scenario
	        model.addAttribute("message", "Food '" + food.getFoodId() + "' is Not Available!!");
	        fetchFoodList(model);
	        return "employeelist";
	    }
	}


	// API
	@RequestMapping("/foodbyid/{foodId}")
	public Optional<Food> getById(@PathVariable("foodId") int foodId) {
		return adminService.getFoodById(foodId);
	}

	@RequestMapping("/showedit")
	public String showUploadForm() {
		return "admin/editfood";
	}
}
