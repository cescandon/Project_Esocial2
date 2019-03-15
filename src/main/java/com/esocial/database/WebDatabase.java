package com.esocial.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class WebDatabase {

  Connection conn = null;
  Statement stmt = null;
  
  String directory;
  String dbName;
  
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
    return conn;
	  
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
		  ResultSet results = stmt.executeQuery("SELECT * FROM users WHERE name = " + userName);
		  
		  if(results != null)
		  {
			  try {
				  if(results.next())
				  {
					  doesExist = true;
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

 
  
  // check if password is correct Boolean
  public Boolean checkPass(String userPass) throws SQLException
  {
	  // boolean variable
	  boolean samePass= false;
	  
	    // create a query for password
	  try {
		  
		  Connection conn = connectionToDerby();
		  Statement stmt = conn.createStatement();
		  ResultSet results = stmt.executeQuery("SELECT * FROM users WHERE password = " + userPass);
		  
		  if(results != null)
		  {
			  try
			  {
				  if(results.next())
				  {
					  samePass = true;
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
  
  public void CheckIfUserExists(String user) {
	  
	  try {
		  Statement stmt = conn.createStatement();
		  ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE name = '" + user + "'");
		  

		  
	  }
	   catch(Exception e) {
		   System.out.println("Error :" + e.getMessage());
	   }
	   
  }
  
  public void deleteUser(String username) {
	  //check if it exists
	  
	  
	  //find it and delete it
	   
  }
  
  
  
  // create user void
  public void createUser(String nameEntry, String userEmail, String userPass) throws SQLException
  {
	 
	  
	  // create sql insert statement, id is configured by keygenerate method to 
	  // determine id placement
	  String insertTableSQL = "INSERT INTO users" + "(id, name, email, password) " + "VALUES"
	  + "(" + stmt.getGeneratedKeys() + ", 'nameEntry', 'userEmail', 'userPass')";
	  
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
  
  // delete user 
  public void deleteUser() throws SQLException
  {
	  String deleteEntry = "DELETE FROM user WHERE id = ?";
	  int maxRows;
	  
	  try
	  {
		  conn = connectionToDerby();
		  stmt = conn.createStatement();
		  maxRows = stmt.getFetchSize();
		  stmt.setMaxRows(maxRows);
		  
		  // execute delete and update DB table
		  stmt.executeUpdate(deleteEntry);
		  
		  // print out result
		  System.out.println("Record is deleted");
	  }catch(Exception deleteException)
	  {
		  deleteException.printStackTrace();
	  }
	  finally
	  {
		  if(conn != null)
		  {
			  conn.close();
		  }
	  }
  }
   
}