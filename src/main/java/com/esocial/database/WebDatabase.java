package com.esocial.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

 
public class WebDatabase {

  Connection conn = null;
  Statement stmt = null;
  
  String directory ;
  String dbName ;
  
public WebDatabase() {
	dbName = "WebDatabase";
	directory= "./MyDatabases/";
	
}
 
  private Connection connectionToDerby() throws SQLException {
    // -------------------------------------------
    // URL format is
    // jdbc:derby:<local directory to save data>
    // -------------------------------------------
	  
    //String dbUrl = "jdbc:derby:/Users/myuser/Desktop/DataTest/MyDB/demo;create=true";
	String dbUrl = "jdbc:derby:" + directory + dbName + ";create=true";
    conn = DriverManager.getConnection(dbUrl);
    stmt = conn.createStatement();
    return conn;
	  
  }
  
  public void createTable() throws SQLException
  {
	  String command = "CREATE TABLE users (id SERIAL primary key, name varchar(30), email varchar(30), password varchar(20))";
	  try {
		  conn = connectionToDerby();
		  stmt.executeUpdate(command);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  finally
	  {
		  if(stmt != null)
		  {
			  stmt.close();
		  }
		  if(conn != null)
		  {
			  conn.close();
		  }
	  }
  }
  
  public void ShowTable() throws SQLException {
	  String command = "Select * users";
	  
	  try
	  {
		  conn = connectionToDerby();
		  ResultSet result = stmt.executeQuery(command);
		  while(result.next()) {
			  System.out.println("ID: " + result.getInt("id") + "Name: " + result.getString("name") + " email: " + result.getString("email"));
		  }
		  
		  
	  }
	  catch(Exception delExc)
	  {
		  delExc.printStackTrace();
	  }
	  finally
	  {
		  if(stmt != null)
		  {
			  stmt.close();
		  }
		  if(conn != null)
		  {
			  conn.close();
		  }
	  }
  }
  
  public void deleteTable() throws SQLException
  {
	  String command = "DROP TABLE users";
	  
	  try
	  {
		  conn = connectionToDerby();
		  stmt.executeUpdate(command);
	  }
	  catch(Exception delExc)
	  {
		  delExc.printStackTrace();
	  }
	  finally
	  {
		  if(stmt != null)
		  {
			  stmt.close();
		  }
		  if(conn != null)
		  {
			  conn.close();
		  }
	  }
  }
 
  
  // checkifuserexists Boolean
  public Boolean checkUser(String userName) throws SQLException
  {
	  // boolean variable
	  boolean doesExist= false;
	  
	    // create a query for username 
	  try {
		  Connection conn = connectionToDerby();
		  Statement stmt = conn.createStatement();
		  ResultSet results = stmt.executeQuery("SELECT * FROM users WHERE name = '" + userName +"'");
		  
		  if(results != null)
		  {
			  try {
				  if(results.next())
				  {
					  String data = results.getString("name");
					  if(data == userName)
					  {
						  //was a match
						  doesExist = true;
					  }
					  
				  }
			  }
				  catch (Exception resultsException)
				  {
					  resultsException.printStackTrace();
				  }
		  }
	  }
		  catch(Exception stmtException)
		  {
			  stmtException.printStackTrace();
		  }
	  finally // closing connection in reverse order to avoid potential exceptions
	  {
		  if(stmt != null)
		  {
			  stmt.close();
		  }
		  if(conn != null)
		  {
			  conn.close();
		  }
	  }
	  return doesExist;
  }

 
  
  // check if password is correct return Boolean
  public Boolean checkPass(String userPass) throws SQLException
  {
	  // boolean variable
	  boolean samePass= false;
	  
	    // create a query for password
	  try {
		  
		  Connection conn = connectionToDerby();
		  Statement stmt = conn.createStatement();
		  ResultSet results = stmt.executeQuery("SELECT * FROM users WHERE password = '" + userPass + "'");
		  
		  if(results != null)
		  {
			  try
			  {
				  if(results.next())
				  {
					 String data = results.getString("userPass");
					 if(data == userPass)
					 {
					  // a hit
					  samePass = true;
					 }
				  }
			  }
				  catch (Exception resultsException)
				  {
					  resultsException.printStackTrace();
				  }
		  }
	  }
		  catch(Exception stmtException)
		  {
			  stmtException.printStackTrace();
		  }
	  finally
	  {
		  if(stmt != null)
		  {
			  stmt.close();
		  }
		  if(conn != null)
		  {
			  conn.close();
		  }
	  }
	  
	  return samePass;
  }
  
  // Check if user exist and print result. 
  public void CheckIfUserExists(String user)
  {
	  
	  try 
	  {
		  boolean confirm = checkUser(user); // call checkUser as a helper function
		  
		  if(confirm == true)
		  {
			  System.out.println("User: " + user + " does exist.");
		  }
		  if(confirm == false)
		  {
			  System.out.println("User: " + user + " not found");
		  }
	  }
	   catch(Exception e) {
		   System.out.println("Error :" + e.getMessage());
	   }
	   
  }
  
  // delete user and print result 
  public void deleteUser(String _username, String _userPassword) throws SQLException
  {
	  // delete sql statement with name and password acting as filter
	  // in case multiple users with same name
	  String stmtDelete = "DELETE FROM users WHERE name, password = '" + _username + "'" + "'" + _userPassword + "'";  
	  
	  //check if it exists
		try
		{
			Connection conn = connectionToDerby();
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(stmtDelete);
			System.out.println("User: " + _username + " is deleted.");
		}catch(Exception deleteExc)
		{
			deleteExc.printStackTrace();
		}
		finally
		{
			conn.close();
		}
  }
  
  
  
  // create user 
  public void createUser(String nameEntry, String userEmail, String userPass) throws SQLException
  {
	  // create sql insert statement, id is configured by create table method
	  // by using a serialized id primary key
	  
	  String insertTableSQL = "INSERT INTO users" + "(name, email, password) " + 
	  "VALUES( '" + nameEntry + "' " + userEmail + "'" + userPass + "')"; 
	  
	  try
	  {
		  conn = connectionToDerby(); // connect to DB
		  stmt = conn.createStatement(); // connection result
		  stmt.executeUpdate(insertTableSQL); // execute insert and update DB
		  
		  // print out success
		  System.out.println("User " + nameEntry + " is created");
	  }catch(Exception insertException)
	  {
		  insertException.printStackTrace();  
	  }finally 
	  {
		  if(conn != null)
		  {
			  stmt.close();
		  }
		  if(stmt != null)
		  {
			  conn.close();
		  }
	  }
  }
}