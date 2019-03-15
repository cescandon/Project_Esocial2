package com.esocial.web_util;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ScriptsController {

	@RequestMapping(value = "/task_js", method = RequestMethod.GET)
	public String mainCSS() {
		return "/WEB-INF/views/javascript/task_script.jsp";
	}
	
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
