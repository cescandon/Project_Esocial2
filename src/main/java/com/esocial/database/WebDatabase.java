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
<<<<<<< HEAD
	  String command = "CREATE TABLE users (id SERIAL primary key, name varchar(30), email varchar(30), password varchar(20))";
=======
	  String command = "Create table users (id int primary key, name varchar(30), email varchar(30), password varchar(20))";
>>>>>>> 2b93dc6c3dd53606f3dd4157abda904e4d24a890
	  try {
		  conn = connectionToDerby();
		  stmt.executeUpdate(command);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("Error at createTable: " + e.getMessage() );
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
	  catch(Exception e)
	  {
		  System.out.println("Error at ShowTable: " + e.getMessage() );
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
	  catch(Exception e)
	  {
		  System.out.println("Error at deleteTable: " + e.getMessage() );
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
	  System.out.println("Checking user");
	    // create a query for username 
	  try {
		  Connection conn = connectionToDerby();
		  Statement stmt = conn.createStatement();
		  ResultSet results = stmt.executeQuery("SELECT * FROM users WHERE name = '" + userName +"'");
		  
		  if(results != null)
		  {
			  try {
				  while(results.next())
				  {
					  String data = results.getString("name");
					  if(data.equalsIgnoreCase(userName))
						  doesExist = true;					 					  
				  }
			  }
			  catch (Exception e)
			  {
				  System.out.println("Error at checkUsersBOolean: " + e.getMessage() );
			  }
		  }
	  }
	  catch(Exception e)
	  {
		  System.out.println("Error at checkUSer: " + e.getMessage() );
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

//checkifuserexists Boolean
 public String getUserPassword(String userName)
 {
	  // boolean variable
	  boolean doesExist= false;
	  System.out.println("Checking user");
	    // create a query for username 
	  try {
		  Connection conn = connectionToDerby();
		  Statement stmt = conn.createStatement();
		  ResultSet results = stmt.executeQuery("SELECT * FROM users WHERE name = '" + userName +"'");
		  
		  if(results != null)
		  {
			  try {
				  while(results.next())
				  {
					  String data = results.getString("name");
					  if(data.equalsIgnoreCase(userName))
					  {
						 String password = results.getString("password");
						 return password;
					  }
				  }
			  }
			  catch (Exception e)
			  {
				  System.out.println("Error at checkUsersBOolean: " + e.getMessage() );
			  }
		  }
	  }
	  catch(Exception e)
	  {
		  System.out.println("Error at checkUSer: " + e.getMessage() );
	  }
	  finally // closing connection in reverse order to avoid potential exceptions
	  {
		  try {
			  
			  if(stmt != null)
			  {
				  stmt.close();
			  }
			  if(conn != null)
			  {
				  conn.close();
			  }
		  }catch(Exception e) {
			  System.out.println("Error closing in check password");
		  }

	  }
	  return null;
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
				  catch (Exception e)
				  {
					  System.out.println("Error at CheckPassBoolean: " + e.getMessage() );
				  }
		  }
	  }
		  catch(Exception e)
		  {
			  System.out.println("Error at checkPassBoolean: " + e.getMessage() );
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
  public Boolean CheckIfUserExists(String user)
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
		  return confirm;
	  }
	   catch(Exception e) {
		   System.out.println("Error at checkIFExists: " + e.getMessage() );
	   }
	   return false;
  }
  

  
  // delete user and print result 
  public void deleteUser(String _username, String _userPassword) throws SQLException
  {
	  // delete sql statement with name and password acting as filter
	  // in case multiple users with same name
	  String stmtDelete = "DELETE FROM users WHERE name = '" + _username + "'" +" and password = '" + _userPassword + "'";  
	 
	  //check if it exists
		try
		{
			Connection conn = connectionToDerby();
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(stmtDelete);
			System.out.println("User: " + _username + " is deleted.");
		}catch(Exception deleteExc)
		{
			System.out.println("Error at delete: " + deleteExc.getMessage() );
		}
		finally
		{
			conn.close();
		}
  }
  
  
  static int usersAdded = 0;
  
  // create user 
  public void createUser(String nameEntry, String userEmail, String userPass) throws SQLException
  {
	  // create sql insert statement, id is configured by create table method
	  // by using a serialized id primary key
	  
	  String insertTableSQL = "INSERT INTO users" + "(id, name, email, password) " + 
	  "VALUES("+  usersAdded +", '" + nameEntry + "', '" + userEmail + "', '" + userPass + "')"; 	  
	  usersAdded++;
	  
	  try
	  {
		  conn = connectionToDerby(); // connect to DB
		  stmt = conn.createStatement(); // connection result
		  stmt.executeUpdate(insertTableSQL); // execute insert and update DB
		  
		  // print out success
		  System.out.println("User " + nameEntry + " is created");
	  }catch(Exception e)
	  {
		  System.out.println("Error at createUser: " + e.getMessage() ); 
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