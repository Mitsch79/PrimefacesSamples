package com.mycompany;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginController {
	
	@Inject
	private LoginModell loginModell;
	
	public String login() {
		return "/jsf/test.xhtml";
	}
}
