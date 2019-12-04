package com.mycompany.model;

import java.io.Serializable;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;

@Named
@ConversationScoped
public class LoginModell implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6736169021287117887L;
	private String firstname;
	private String lastname;
	private String password;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String forename) {
		this.firstname = forename;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getGreeting() {
		return "Hallo "+firstname +" " +lastname+", ich wünsche Dir einen schönen Tag :)";
	}
}	
