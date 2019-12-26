package com.beerhouse.endpoint.dto;

import java.math.BigDecimal;

public class BeerDTO {

	private String name;
	private String ingredients;
	private String alcoholContent;
	private BigDecimal price;
	private String category;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	public String getAlcoholContent() {
		return alcoholContent;
	}
	public void setAlcoholContent(String alcoholContent) {
		this.alcoholContent = alcoholContent;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
}
