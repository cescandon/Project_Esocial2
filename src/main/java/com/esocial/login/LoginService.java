package com.esocial.login;


import java.sql.SQLException;


import org.springframework.stereotype.Service;
import com.esocial.database.*;
import com.esocial.general_util.*;

//new login service()
@Service
public class LoginService {
	

	
	public boolean validateUser(String user, String password) {
		


		WebDatabase db = new WebDatabase();


		//FileReader.TryTestFile();
		
//		try {
//			db.connectionToDerby();
//			db.normalDbUsage();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		if(user == "admin")
			return true;
	
		return false;
	}

}