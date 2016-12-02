package com.revature.beans;

import java.io.Serializable;
import java.security.SecureRandom;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ACCOUNTS")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5141943028394764957L;
	@Id
	@SequenceGenerator(name="ACCOUNT_SEQ", sequenceName="ACCOUNT_SEQ")
	@GeneratedValue(generator="ACCOUNT_SEQ",strategy=GenerationType.SEQUENCE)
	@Column(name="A_ID")
	private int userId;
	@Column(name="P_WORD")
	private int password;
	@Column(name="MY_SALT")
	private String salt;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getSalt() {
		return salt;
	}
	public int getId(){
		return this.userId;
	};
	public void setPassword(String password){
		this.password = salt(password);
	}
	public void setSalt(String salt){
		this.salt = salt;
 	}
	
	private int salt(String pw){
		SecureRandom sr = new SecureRandom();
		if(this.salt == null){
			generateSalt();
			setSalt(this.salt + (int) (sr.nextDouble() * pw.length()));
		}
		int i = Integer.parseInt("" + this.salt.charAt(this.salt.length() - 1));
		pw = pw.substring(0, i) + this.salt + pw.substring(i);
		
		return pw.hashCode();
	}
	
	private void generateSalt(){
		String salt = "";
		SecureRandom sr = new SecureRandom();
		for(int i = 0; i < 100; i++){
			Character c;
			do{
				c = (char) (sr.nextDouble() *'z'+1);
			} while(!(Character.isLetter(c) ||Character.isDigit(c)));
			salt+= c;
		}
		
		setSalt(salt);
	}

	public boolean checkPassword(String pw){
		return salt(pw) == this.password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userId, String password, String salt) {
		super();
		this.userId = userId;
		this.salt = salt;
		this.setPassword(password);
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", salt=" + salt + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + password;
		result = prime * result + ((salt == null) ? 0 : salt.hashCode());
		result = prime * result + userId;
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
		User other = (User) obj;
		if (password != other.password)
			return false;
		if (salt == null) {
			if (other.salt != null)
				return false;
		} else if (!salt.equals(other.salt))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	
	
}

