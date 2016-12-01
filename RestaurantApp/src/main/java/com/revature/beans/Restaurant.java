package com.revature.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	@OneToMany(mappedBy="restaurant")
	private List<FoodItem> menu = new ArrayList<FoodItem>();
	@OneToOne
	@JoinColumn(name="CI_ID")
	private ContactInfo address;
	
	
	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}
}
