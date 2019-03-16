package com.esocial.chat;

import java.util.List;



import com.esocial.reminders.Reminder;
import com.esocial.reminders.ReminderList;
import com.esocial.reminders.TodaysReminders;
import com.esocial.utils.dates.Dates;


public class CommandService {

	static ReminderList remlist = new ReminderList("Global Reminders");
	
	public static Boolean InitList() {
		remlist = new ReminderList("Global Reminders");
		return true;
	}
	
	public static String Process(String message) {
		System.out.println("Checking cmd");
		if(message.contains("/task"))
		{
			System.out.println("doing cmd task");
			String task = message.substring(5, message.length());
			return "/CT " + CreateTask(task);
		}else if(message.contains("/rem"))	{
			System.out.println("doing cmd reminder");
			String reminder = message.substring(4, message.length());
			return "/CR " + CreateReminder(reminder);
		}
		return message;
	}
	
	public static String CreateTask(String task) {
		System.out.println("Building Task");
		String start = "<label class=\"task\" >"
				+ "<input type=\"checkbox\" >"
				+ "<i class=\"fas fa-check\"></i>"
				+ "<span class=\"text\">";
		
		String end = "</span></label>";		
		return start + "Task : " + task + end;		
	}
	
	public static String CreateReminder(String reminder) {
		System.out.println("Building Reminder");
		
		Reminder newrem = new Reminder(reminder, Dates.getToday());
		remlist.add(newrem);
		
		String start = "<label class=\"task\" >"
				+ "<input type=\"checkbox\" >"
				+ "<i class=\"fas fa-check\"></i>"
				+ "<span class=\"text\">";
		
		String end = "</span></label>";		
		return start + "Reminder : " + newrem.getData() + end;	
	}
	
	public static List<String> getAllReminders(){
		return TodaysReminders.getTodays(remlist);
	}
	
	public static int getReminderSize() {
		return remlist.getSize();
	}
	
	public static void ClearReminders() {
		remlist.ClearList();
	}
	
}
