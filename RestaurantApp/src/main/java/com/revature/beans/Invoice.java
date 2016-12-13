package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
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
	@JoinTable(name="I_STATUS",
			joinColumns=@JoinColumn(name="I_STATUS"),
			inverseJoinColumns=@JoinColumn(name="IS_ID"))
	private String Status;
	@Column(name="TOTAL")
	private double total;
	@ManyToOne
	@JoinColumn(name="CI_ID")
	private ContactInfo contact;
	@ManyToOne
	@JoinColumn(name="C_ID")
	private Customer customer;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
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

	public Invoice(int id, String status, double total, ContactInfo contact, Customer customer) {
		super();
		this.id = id;
		Status = status;
		this.total = total;
		this.contact = contact;
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Invoice [id=" + id + ", Status=" + Status + ", total=" + total + ", contact=" + contact + ", customer="
				+ customer + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Status == null) ? 0 : Status.hashCode());
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + id;
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
		if (Status == null) {
			if (other.Status != null)
				return false;
		} else if (!Status.equals(other.Status))
			return false;
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
		if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
			return false;
		return true;
	}
}
