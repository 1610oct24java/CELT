package com.revature.beans;

import java.io.Serializable;

public class InvoiceFoodItemCompositKey implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6888933915391945061L;

	public InvoiceFoodItemCompositKey(Invoice order, FoodItem item) {
		super();
		this.order = order;
		this.item = item;
	}

	public InvoiceFoodItemCompositKey() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Invoice order;
	
	private FoodItem item;

	public Invoice getOrder() {
		return order;
	}

	public void setOrder(Invoice order) {
		this.order = order;
	}

	public FoodItem getItem() {
		return item;
	}

	public void setItem(FoodItem item) {
		this.item = item;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
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
		InvoiceFoodItemCompositKey other = (InvoiceFoodItemCompositKey) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		return true;
	}
}
