package com.mycompany.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.mycompany.services.TestService;

@Named
@RequestScoped
public class TestController {
	
	@Inject
	private TestService testService;
	
}
