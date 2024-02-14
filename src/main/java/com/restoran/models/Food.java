package com.restoran.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "food")
public class Food {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    private int foodId;

    @Column(name = "description")
    private String desc;

    @Column(name = "food_name")
    private String foodName;

    @Column(name = "image_name")
    private String imageName;

    @Column(name = "price")
    private String price;
    
	public Food() {
		super();
	}
	public Food(int foodId, String desc, String foodName, String imageName, String price) {
		super();
		this.foodId = foodId;
		this.desc = desc;
		this.foodName = foodName;
		this.imageName = imageName;
		this.price = price;
	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", desc=" + desc + ", foodName=" + foodName + ", imageName=" + imageName
				+ ", price=" + price + "]";
	}

}
