package com.revature.beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="MANAGERS")
@PrimaryKeyJoinColumn(name="M_ID")
public class Manager extends User {
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="R_ID")
	private Restaurant restaurant;

	@Override
	public String toString() {
		return "Manager [restaurant=" + restaurant + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((restaurant == null) ? 0 : restaurant.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manager other = (Manager) obj;
		if (restaurant == null) {
			if (other.restaurant != null)
				return false;
		} else if (!restaurant.equals(other.restaurant))
			return false;
		return true;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(int userId, String password, String salt, Restaurant restaurant) {
		super(userId, password, salt);
		this.restaurant = restaurant;
	}
	
}
