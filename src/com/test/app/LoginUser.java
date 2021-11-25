package com.test.app;

import java.util.List;

public class LoginUser {

	public static boolean login(User user) {
		List<User> userlist = ReadUsers.getUsers();
		int match = 0;
		for (User userInfo : userlist) {
			if (user.getName().equals(userInfo.getName()) && user.getPassword().equals(userInfo.getPassword())) {
				System.out.println("Login Successfull !");
				match++;
				return true;
			}
		}
		if (match == 0) {
			System.out.println("Login Failed ! ");
		}
		return false;
	}
}
