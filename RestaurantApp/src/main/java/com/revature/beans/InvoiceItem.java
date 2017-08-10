package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="INVOICE_ITEM")
@IdClass(InvoiceFoodItemCompositKey.class)
public class InvoiceItem implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3535240967029267963L;
	@Id
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="I_ID")
	private Invoice order;
	
	@Id
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MI_ID")
	private FoodItem item;
	
	@Column(name="QUANTITY")
	private int quantity;
	
	public Invoice getOrder() {
		return order;
	}

	public FoodItem getItem() {
		return item;
	}

	public void setItem(FoodItem item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setOrder(Invoice order) {
		this.order = order;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + quantity;
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
		InvoiceItem other = (InvoiceItem) obj;
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
		if (quantity != other.quantity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "InvoiceItem [order=" + order + ", item=" + item + ", quantity=" + quantity + "]";
	}

	public InvoiceItem(Invoice order, FoodItem item, int quantity) {
		super();
		this.order = order;
		this.item = item;
		this.quantity = quantity;
	}

	public InvoiceItem() {
		super();
	}

	
}
