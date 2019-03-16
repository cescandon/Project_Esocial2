package com.esocial.reminders;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.esocial.chat.CommandService;
import com.esocial.utils.dates.Dates;

public class ReminderTests {
	
	// create object 
	Reminder newrem;
	ReminderList remlist;

	
	@Before // setup constructor for database connection
	public void Setup()
	{
		// initialize object	
		newrem = new Reminder("Reminder test", Dates.getToday());
		CommandService.InitList();
	}
	


	@Test
	public final void checkValidCMD_Reminder(){
		
		System.out.println("\nTest Adding reminder through command\n");
		int remcount = CommandService.getReminderSize();
		assertEquals(remcount, 0);
		String command = "/rem Buy Milk";
		String response = CommandService.Process(command);
		
		assertTrue((remcount != CommandService.getReminderSize()));	
		assertNotEquals(response.length(), command.length());
		assertEquals(CommandService.getReminderSize(), 1);
		System.out.println("\nTest Check Valid Command Reminder: OK\n");	
	}
	
	@Test
	public final void checkInValidCMD_Reminder(){
		
		System.out.println("\nTest Adding reminder through command\n");
		int remcount = CommandService.getReminderSize();
		assertEquals(remcount, 0);
		String command = "/r Buy Milk";
		String response = CommandService.Process(command);
		
		assertTrue((remcount == CommandService.getReminderSize()));	
		assertEquals(response.length(), command.length());
		assertEquals(CommandService.getReminderSize(), 0);
		System.out.println("\nTest Check InValid Command Reminder: OK\n");	
	}
	
	@Test
	public final void checkValidCMD_Task(){
		
		System.out.println("\nTest Adding task through command\n");
		int remcount = CommandService.getReminderSize();
		assertEquals(remcount, 0);
		String command = "/task Do paperwork";
		String response = CommandService.Process(command);
		
	
		assertNotEquals(response.length(), command.length());
		assertEquals(CommandService.getReminderSize(), 0);
		System.out.println("\nTest Check Valid Command Task: OK\n");	
	}
	
	@Test
	public final void checkInValidCMD_Task(){
		
		System.out.println("\nTest Adding task through command\n");
		int remcount = CommandService.getReminderSize();
		assertEquals(remcount, 0);
		String command = "/t Do paperwork";
		String response = CommandService.Process(command);
		
		assertTrue((remcount == CommandService.getReminderSize()));	
		assertEquals(response.length(), command.length());
		assertEquals(CommandService.getReminderSize(), 0);
		System.out.println("\nTest Check InValid Command Task: OK\n");	
	}
	
	
	@After
	public final void cleanUp(){
		System.out.println("\n______________\n");
		CommandService.ClearReminders();
	}
	
}