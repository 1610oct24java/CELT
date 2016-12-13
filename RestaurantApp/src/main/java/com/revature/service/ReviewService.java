package com.revature.service;

import java.util.List;

import com.revature.beans.Restaurant;
import com.revature.beans.Review;

public class ReviewService {
	public float getRating(List<Review> reviews){
		if(reviews.size() == 0)
			return 0;
		
		float sum = 0;
		
		for(Review review : reviews){
			sum += review.getStars();
		}
		
		return sum/reviews.size();
	}
	
	public float getRaiting(Restaurant restaurant){
		return getRating(restaurant.getReviews());
	}
}