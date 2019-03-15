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
	

	//use @ResponseBody to make it a string not a view	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showHome() {
		
		//database.validateUser(user, password);		
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
			model.put("errorLocation", "<a>Error Username</a>");
			return "/WEB-INF/views/signin.jsp";
		}
		return "/WEB-INF/views/chat.jsp";
	}
	
	
	@RequestMapping(value = "/signin_css")
	public String sendSignStyles() {
		
		return "/WEB-INF/views/css/signin_css.jsp";
	}
}

//with the configuration we dont need prefix anymore "/WEB-INF/views/login.jsp"