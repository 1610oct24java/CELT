package com.revature.beans;

import java.io.Serializable;

public abstract class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5141943028394764957L;
	private int userId;
	private int password;
	private String salt;
	
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
		if(this.salt == null){
			generateSalt();
			setSalt(this.salt + (int) (Math.random() * pw.length()));
		}
		int i = Integer.parseInt("" + this.salt.charAt(this.salt.length() - 1));
		pw = pw.substring(0, i) + this.salt + pw.substring(i);
		
		return pw.hashCode();
	}
	
	private void generateSalt(){
		String salt = "";
		
		for(int i = 0; i < 100; i++){
			Character c;
			do{
				c = (char) (Math.random()*'z'+1);
			} while(!(Character.isLetter(c) ||Character.isDigit(c)));
			salt+= c;
		}
		
		setSalt(salt);
	}
	
	public boolean checkPassword(String pw){
		return salt(pw) == this.password;
	}
}
