package com.esocial.reminders;

import java.util.*;



public class TodaysReminders{
	
	ReminderList _reminders;
	
	TodaysReminders(ReminderList rems){
		_reminders = rems;
	}
	
	public List<String> doGet() {		
		
		 List<String> todayRems = new ArrayList<>();
		_reminders.getTodaysReminders().forEach(rem -> {
			String todays = "";
            todays += rem.getDesc();
            Calendar alert = rem.getAlertTime();
            if (alert != null)
                todayRems.add(String.format(" %1$tH:%1$tM", alert));
            else 
            	todays += "\n";
            System.out.print(todays);
		});
		
		return todayRems;
	}
	
    @Override
    public String toString() {
    	return "List today's reminders";
    }	
}
