package com.esocial.database;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataBaseTest {
	
	// variables to use for passing to each respected test case
	String username = "Tom";
	String passW = "fml";
	String email = "undetermined";
	
	@Before // setup constructor for database connection
	public void Setup()
	{
		// create object and initialize with WebDatabase
		WebDatabase tester = new WebDatabase();
		
		// call to create a table
		// createtable calls private function to create connection
		// to database.  table created assumed connection works
		try {
			tester.createTable();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@After
	public void CleanUp()
	{
		WebDatabase tester = new WebDatabase();

		// delete created table 
		try {
			tester.deleteTable();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public final void testWebDatabase() {
		fail("Not yet implemented"); // TODO
		
	}

	@Test
	public final void testCheckUser() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testCheckPass() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testCheckIfUserExists() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testDeleteUser() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testCreateUser() {
		fail("Not yet implemented"); // TODO
	}

}
