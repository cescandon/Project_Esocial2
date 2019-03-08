package com.esocial.login;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class LoginController {
	
	//set login service with dependency injection
	//with autowiring
	@Autowired
	LoginService service;
	
	LoginService database;
	
	//Mapping everything with /login to here
	//letting the servlet here know is not the name of a view/url, but be sent as response
	//by using @ResponseBody to make it a string not a view

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showHome() {
		
		database.validateUser(user, password)
		
		return "/WEB-INF/views/signin.jsp";
	}
	
	@RequestMapping(value = "/mlogin", method = RequestMethod.POST)
	public String handleSignIn(@RequestParam String name,
			  @RequestParam String password,
			  ModelMap model)
	{		
		
		
		System.out.println("Your username is : "+ name + " and pass: "+ password);
		if(service.validateUser(name, password))
		{
			System.out.println("Correct credentials");
		}
		else
		{
			model.put("errorLocation", "Error Username");
			return "/WEB-INF/views/signin.jsp";
		}
		return "/WEB-INF/views/chat.jsp";
	}
	
	
	@RequestMapping(value = "/signin_css")
	public String sendSignStyles() {
		
		return "/WEB-INF/views/css/signin_css.jsp";
	}
	
	//use same name in variable as form parameter, now you dont need getParam("param")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLogin(@RequestParam String name,
							  @RequestParam String password,
							  ModelMap model) {
				
		if(!service.validateUser(name, password))
		{
			model.put("errorMessage", "Invalid user entered!");
			return "login";
		}
		
		model.put("name", name);
		//model.put("password", password);
		return "welcome";	

	}

}

//with the configuration we dont need prefix anymore "/WEB-INF/views/login.jsp"