package com.esocial.login;

import org.springframework.stereotype.Service;

//new login service()
@Service
public class LoginService {
	public boolean validateUser(String user, String password) {
		return user.equalsIgnoreCase("admin") && password.equals("random");
	}

}