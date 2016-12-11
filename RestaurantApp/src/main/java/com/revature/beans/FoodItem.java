package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="MENU_ITEM")
public class FoodItem implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6437357436131993928L;
	@Id
	@Column(name="MI_ID")
	@SequenceGenerator(sequenceName="FOOD_ID_SEQ", name="FOOD_ID_SEQ")
	@GeneratedValue(generator="FOOD_ID_SEQ", strategy=GenerationType.SEQUENCE)
	private int id;
	@Column(name="MI_NAME")
	private String name;
	@Column(name="MI_DESCRIPTION")
	private String description;
	@Column(name="PRICE")
	private float price;
	@ManyToOne
	@JoinColumn(name="R_ID")
	@JsonIgnore
	private Restaurant restaurant;
	@Column(name="MI_SPECIAL")
	private boolean isSpecial;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public boolean isSpecial() {
		return isSpecial;
	}
	public void setSpecial(boolean isSpecial) {
		this.isSpecial = isSpecial;
	}

	public FoodItem() {
		super();
	}
	public FoodItem(int id, String name, String description, float price, Restaurant restaurant, boolean isSpecial,
			boolean soldOut) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.restaurant = restaurant;
		this.isSpecial = isSpecial;
	}
	@Override
	public String toString() {
		return "FoodItem [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", isSpecial=" + isSpecial;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + (isSpecial ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + ((restaurant == null) ? 0 : restaurant.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FoodItem other = (FoodItem) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (isSpecial != other.isSpecial)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (restaurant == null) {
			if (other.restaurant != null)
				return false;
		} else if (!restaurant.equals(other.restaurant))
			return false;

		return true;
	}
}
