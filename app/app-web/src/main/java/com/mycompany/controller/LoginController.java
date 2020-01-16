package com.mycompany.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginController {

	@Inject
	private TestController testController;

	public String login() {
		testController.init();
		return "home";
	}
}
