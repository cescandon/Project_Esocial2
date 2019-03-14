package com.esocial.chat;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



import com.esocial.login.LoginService;



@Controller
public class ChatController {
	
	//set login service with dependency injection
	//with autowiring
	@Autowired
	LoginService service;
		
	@RequestMapping(value = "/chat_js", method = RequestMethod.GET)
	public String handleChat(
			  ModelMap model)
	{
		
		System.out.println("Sending to home area.");
		String localhost = "";
	      try {
	           InetAddress inetAddress;
	           inetAddress = InetAddress.getLocalHost();
	           System.out.println("IP Address:- " + inetAddress.getHostAddress());
	           System.out.println("Host Name:- " + inetAddress.getHostName());
	           localhost = inetAddress.getHostAddress();
	      } catch (UnknownHostException ex) {
	          System.out.println("Error: " + ex.getMessage());
	      }
		model.put("localh", localhost);
		return "/WEB-INF/views/javascript/chat_script.jsp";
	}

}

//with the configuration we dont need prefix anymore "/WEB-INF/views/login.jsp"