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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

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
	@NotEmpty(message="Please enter a username")
	@Column(name="U_NAME")
	private String username;
	@NotNull
	@Column(name="P_WORD")
	private int password;
	@Column(name="MY_SALT")
	private String salt;
	
	public User(int userId, String username, int password, String salt) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.salt = salt;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", salt=" + salt + "]";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

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
	}
	public User(int userId, String password, String salt) {
		super();
		this.userId = userId;
		this.salt = salt;
		this.setPassword(password);
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

