package com.esocial.login;


import org.springframework.stereotype.Service;
import com.esocial.database.*;

//new login service()
@Service
public class LoginService {
	
//    EntityManagerFactory emf = Persistence.createEntityManagerFactory("LabJPAPU");
//    EntityManager em = emf.createEntityManager();
	
	public boolean validateUser(String user, String password) {
		

		//WebDatabase db = new WebDatabase();
		// db.checkIfValid(username, password);
		  
		
		return user.equalsIgnoreCase("admin") && password.equals("happy");
	}

}