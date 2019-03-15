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
		
		
		tester.CheckIfUserExists(username);
		
	}

	@Test
	public final void testCheckPass() {
		
		try {
			tester.checkPass(passW);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public final void testCheckIfUserExists() {
		
		tester.CheckIfUserExists(username);
	}

	@Test
	public final void testDeleteUser() {
		
		try {
			tester.deleteUser(username, passW);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public final void testCreateUser() {
		
		try {
			tester.createUser(username, email, passW);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@After
	public void CleanUp()
	{
		
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
