package com.mycompany.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginController {

	public String login() {
		return "loggedin";
	}
}
