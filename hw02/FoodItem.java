package edu.csula.cs3220.hw02;

public class FoodItem {

	public final int id;
	public final String name;
	public final String description;
	public final String imageUrl;
	public final double price;
	
	public FoodItem(int id, String name, String description, String imageUrl, double price){
		this.id = id;
		this.name = name;
		this.description = description;
		this.imageUrl = imageUrl;
		this.price = price;
		
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getId() {
		return id;
	}

	public String getImageUrl() {
		return imageUrl;
	}
	
	public double getPrice() {
		return price;
	}

	
}
