package com.revature.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="RESTAURANT")
public class Restaurant implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4524158945507038283L;
	@Id
	@Column(name="R_ID")
	@SequenceGenerator(sequenceName="RESTAURANT_ID_SEQ", name="RESTAURANT_ID_SEQ")
	@GeneratedValue(generator="RESTAURANT_ID_SEQ", strategy=GenerationType.SEQUENCE)
	private int id;
	@Column(name="R_NAME")
	private String name;
	@OneToMany(mappedBy="restaurant", fetch=FetchType.EAGER)
	private List<FoodItem> menu = new ArrayList<FoodItem>();
	@OneToMany(mappedBy="restaurant", fetch=FetchType.EAGER)
	private List<Review> reviews = new ArrayList<Review>();
	@OneToOne
	@JoinColumn(name="CI_ID")
	private ContactInfo address;
	@Column(name="R_STATUS")
	private String status;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + id;
		result = prime * result + ((menu == null) ? 0 : menu.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((reviews == null) ? 0 : reviews.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Restaurant other = (Restaurant) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (id != other.id)
			return false;
		if (menu == null) {
			if (other.menu != null)
				return false;
		} else if (!menu.equals(other.menu))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (reviews == null) {
			if (other.reviews != null)
				return false;
		} else if (!reviews.equals(other.reviews))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", menu=" + menu + ", reviews=" + reviews + ", address="
				+ address + ", status=" + status + "]";
	}


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


	public List<FoodItem> getMenu() {
		return menu;
	}


	public void setMenu(List<FoodItem> menu) {
		this.menu = menu;
	}


	public List<Review> getReviews() {
		return reviews;
	}


	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}


	public ContactInfo getAddress() {
		return address;
	}


	public void setAddress(ContactInfo address) {
		this.address = address;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Restaurant(int id, String name, List<FoodItem> menu, List<Review> reviews, ContactInfo address,
			String status) {
		super();
		this.id = id;
		this.name = name;
		this.menu = menu;
		this.reviews = reviews;
		this.address = address;
		this.status = status;
	}


	public Restaurant() {
		super();
	}
}
