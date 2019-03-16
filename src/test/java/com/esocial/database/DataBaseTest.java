package com.esocial.database;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataBaseTest {
	
	// create oject 
	WebDatabase tester;
	// variables to use for passing to each respected test case
	String username = "Tom";
	String passW = "fml";
	String email = "undetermined";
	
	@Before // setup constructor for database connection
	public void Setup()
	{
		// initialize object
		tester = new WebDatabase();
		
		// call to create a table
		// createtable calls private function to create connection
		// to database.  table created assumed connection works
		try {
			tester.createTable();
			tester.createUser(username, email, passW);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


	@Test
	public final void testCheckUser() {
		
		System.out.println("\nTest CheckUSER\n");
		
		tester.CheckIfUserExists(username);
		
	}

	@Test
	public final void testCheckPass() {
		System.out.println("\nTest CheckPass\n");
		
		try {
			tester.checkPass(passW);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public final void testCheckIfUserExists() {
		
		System.out.println("\nTest Check IF User Exists\n");
		
		assertTrue(tester.CheckIfUserExists(username));
		
		assertEquals(username, "Tom");
		
	}
	
	@Test
	public final void testGetPassword() {
		
		System.out.println("\nTest Check forgotten Password\n");
		
		assertTrue(tester.CheckIfUserExists(username));
		String pass = tester.getUserPassword(username);
		assertEquals(passW, pass);
		System.out.println("\nTest Check forgotten Password: OK\n");
	}

	@Test
	public final void testDeleteUser() {
		
		System.out.println("\nTest Delete User\n");
		try {
			tester.deleteUser(username, passW);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public final void testCreateUser() {
		
		System.out.println("\nTest Check CreateUser\n");
		
		try {
			tester.createUser("Sally", "myemail@gmail.com", passW);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@After
	public void CleanUp()
	{
		System.out.println("\n-------------\n");
		// delete created table 
		try {
			tester.ShowTable();
			tester.deleteTable();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
