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
  static int usersAdded = 0; // increment for id

  
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
	  // String command = "CREATE TABLE users (id SERIAL primary key, name varchar(30), email varchar(30), password varchar(20))";
	  String command = "CREATE TABLE users (id int primary key, name varchar(30), email varchar(30), password varchar(20))";
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
	  String command = "Select * FROM users";
	  
	  try
	  {
		  conn = connectionToDerby();
		  ResultSet result = stmt.executeQuery(command);
		  while(result.next()) {
			  System.out.println("ID: " + result.getInt("id") + " Name: " + result.getString("name") + " email: " + result.getString("email"));
		  }
		  
		  
	  }
	  catch(Exception e)
	  {
		  System.out.println("Error at ShowTable: " + e.getMessage());
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
				 System.out.println("Error at checkUSer: " + e.getMessage() );
			  }
		  }
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

// string print of password
 public String getUserPassword(String userName)
 {
	 
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
				  System.out.println("Error at getUserPass: " + e.getMessage() );
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
 
  // get user name
 public String getUserName(String userPass)
 {
	  System.out.println("Checking username by password");
	    // create a query for username 
	  try {
		  Connection conn = connectionToDerby();
		  Statement stmt = conn.createStatement();
		  ResultSet results = stmt.executeQuery("SELECT * FROM users WHERE password = '" + userPass +"'");
		  
		  if(results != null)
		  {
			  try {
				  while(results.next())
				  {
					  String data = results.getString("password");
					  if(data.equalsIgnoreCase(userPass))
					  {
						String nameUser = results.getString("name");
						return nameUser;
					  }
				  }
			  }
			  catch (Exception e)
			  {
				  System.out.println("Error at getUserName: " + e.getMessage() );
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
			  System.out.println("Error closing in check user name");
		  }

	  }
	  return null;
 }
 
  // check if password is correct return Boolean
  public Boolean checkPass(String userPass) throws SQLException
  {
	  // boolean variable
	  boolean samePass= false;
	  // boolean variable
	  System.out.println("Checking password");
	    // create a query for password 
	  try {
		  Connection conn = connectionToDerby();
		  Statement stmt = conn.createStatement();
		  ResultSet results = stmt.executeQuery("SELECT * FROM users WHERE password = '" + userPass +"'");
		  
		  if(results != null)
		  {
			  try {
				  while(results.next())
				  {
					  String data = results.getString("password");
					  if(data.equalsIgnoreCase(userPass))
						  samePass = true;	
					  }
			  }
			  catch (Exception e)
			  {
				 System.out.println("Error at checkUSer: " + e.getMessage() );
			  }
		  }
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
	  return samePass;
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


