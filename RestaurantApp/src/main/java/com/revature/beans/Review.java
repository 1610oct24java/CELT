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

@Entity
@Table(name="REVIEW")
public class Review implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4940360422921148493L;
	@Id
	@Column(name="RATE_ID")
	@SequenceGenerator(sequenceName="RATING_SEQ", name="RATING_SEQ")
	@GeneratedValue(generator="RATING_SEQ", strategy=GenerationType.SEQUENCE)
	private int id;
	@Column(name="STARS")
	private float stars;
	@Column(name="COMMENTS")
	private String comment;
	@ManyToOne
	@JoinColumn(name="R_ID")
	private Restaurant restaurant;
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + id;
		result = prime * result + ((restaurant == null) ? 0 : restaurant.hashCode());
		result = prime * result + Float.floatToIntBits(stars);
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
		Review other = (Review) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (id != other.id)
			return false;
		if (restaurant == null) {
			if (other.restaurant != null)
				return false;
		} else if (!restaurant.equals(other.restaurant))
			return false;
		if (Float.floatToIntBits(stars) != Float.floatToIntBits(other.stars))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Review [id=" + id + ", stars=" + stars + ", comment=" + comment + ", restaurant=" + restaurant + "]";
	}



	public Review(int id, float stars, String comment, Restaurant restaurant) {
		super();
		this.id = id;
		this.stars = stars;
		this.comment = comment;
		this.restaurant = restaurant;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public float getStars() {
		return stars;
	}



	public void setStars(float stars) {
		this.stars = stars;
	}



	public String getComment() {
		return comment;
	}



	public void setComment(String comment) {
		this.comment = comment;
	}



	public Restaurant getRestaurant() {
		return restaurant;
	}



	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}



	public Review() {
		// TODO Auto-generated constructor stub
	}

}
