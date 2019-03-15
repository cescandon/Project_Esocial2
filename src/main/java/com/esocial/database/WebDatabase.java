package com.esocial.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class WebDatabase {

  Connection conn;
  
  String directory;
  String dbName;
  

public WebDatabase() {
	dbName = "WebDatabase";
	directory= "./MyDatabases/";
}
  
  public void connectionToDerby() throws SQLException {
    // -------------------------------------------
    // URL format is
    // jdbc:derby:<local directory to save data>
    // -------------------------------------------
	  
    //String dbUrl = "jdbc:derby:/Users/myuser/Desktop/DataTest/MyDB/demo;create=true";
	 String dbUrl = "jdbc:derby:" + directory + dbName + ";create=true";
    conn = DriverManager.getConnection(dbUrl);
  }
 
  public void normalDbUsage() throws SQLException {
    Statement stmt = conn.createStatement();
 
    // drop table
    // stmt.executeUpdate("Drop Table users");
 
//    // create table
    stmt.executeUpdate("Create table users (id serial primary key, name varchar(30))");
 
//    // insert 2 rows
    stmt.executeUpdate("insert into users(name) values('tom')");
    stmt.executeUpdate("insert into users values (2,'peter')");

 
    // query
    ResultSet rs = stmt.executeQuery("SELECT * FROM users");
 
    // print out query result
    while (rs.next()) { 
      System.out.printf("%d\t%s\n", rs.getInt("id"), rs.getString("name"));
      if ("tom" == rs.getString("name"))
    	
    }
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
  
  
 //NEED MORE FUNCTIONS vvvvvvv
  
}