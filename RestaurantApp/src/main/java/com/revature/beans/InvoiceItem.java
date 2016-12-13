package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="INVOICE_ITEM")
public class InvoiceItem implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3535240967029267963L;
	@Id
	@Column(name="I_ID")
	@SequenceGenerator(sequenceName="INVOICE_ITEM_SEQ", name="INVOICE_ITEM_SEQ")
	@GeneratedValue(generator="INVOICE_ITEM_SEQ", strategy=GenerationType.SEQUENCE)
	private int id;
	@ManyToOne(fetch=FetchType.LAZY)
	private FoodItem item;
	@Column(name="QUANTITY")
	private int quantity;
    @ManyToOne
    private Invoice order;
	
	public Invoice getOrder() {
		return order;
	}

	public void setOrder(Invoice order) {
		this.order = order;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public InvoiceItem(int id, FoodItem item, int quantity) {
		super();
		this.id = id;
		this.item = item;
		this.quantity = quantity;
	}

	public InvoiceItem() {
	}

	@Override
	public String toString() {
		return "InvoiceItem [id=" + id + ", item=" + item + ", quantity=" + quantity + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
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
		if (id != other.id)
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}
}
