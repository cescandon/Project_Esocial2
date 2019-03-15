package com.esocial.chat;

import org.springframework.stereotype.Service;

@Service
public class CommandService {

	public static String Process(String message) {
		System.out.println("Checking cmd");
		if(message.contains("/add"))
		{
			System.out.println("doing cmd");
			String task = message.substring(5, message.length());
			return "/CT " + CreateTask(task);
		}
		
		return message;
	}
	
	public static String CreateTask(String task) {		
		String start = "<label class=\"task\" >"
				+ "<input type=\"checkbox\" >"
				+ "<i class=\"fas fa-check\"></i>"
				+ "<span class=\"text\">";
		
		String end = "</span></label>";		
		return start + task + end;		
	}
				
//  <label class="task" >
//    <input type="checkbox" >
//    <i class="fas fa-check"></i>
//    <span class="text">Read a book</span>
//  </label>
	
}
