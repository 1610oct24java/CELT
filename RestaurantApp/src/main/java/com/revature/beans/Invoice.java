package com.revature.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="INVOICE")
public class Invoice implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5606066870734426992L;
	@Id
	@SequenceGenerator(name="INVOICE_SEQ", sequenceName="INVOICE_SEQ")
	@GeneratedValue(generator="INVOICE_SEQ", strategy=GenerationType.SEQUENCE)
	@Column(name="I_ID")
	private int id;
	@Column(name="I_STATUS")
	private int status;
	@Column(name="TOTAL")
	private double total;
	@ManyToOne
	@JoinTable(name="CONTACT_INFO")
	private ContactInfo contact;
	@ManyToOne
	@JoinColumn(name="C_ID")
	private Customer customer;
    @OneToMany(mappedBy="order",fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private List<InvoiceItem> items;
	
	public void setInvoiceItems(List<InvoiceItem> invoiceItems){
		this.items = invoiceItems;
	}
	
	public List<InvoiceItem> getItems() {
		return items;
	}

	public void setItems(List<InvoiceItem> items) {
		this.items = items;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}
	
	
	public void setStatus(int status) {
		this.status = status;
	}


	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public ContactInfo getContact() {
		return contact;
	}

	public void setContact(ContactInfo contact) {
		this.contact = contact;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Invoice() {
	}

	public Invoice(int id, int status, double total, ContactInfo contact, Customer customer, List<InvoiceItem> items) {
		super();
		this.id = id;
		this.status = status;
		this.total = total;
		this.contact = contact;
		this.customer = customer;
		this.items = items;
	}

	@Override
	public String toString() {
		return "Invoice [id=" + id + ", status=" + status + ", total=" + total + ", contact=" + contact + ", customer="
				+ customer + ", items=" + items + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + id;
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + status;
		long temp;
		temp = Double.doubleToLongBits(total);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Invoice other = (Invoice) obj;
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.equals(other.contact))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (id != other.id)
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (status != other.status)
			return false;
		if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
			return false;
		return true;
	}
	
	
}
