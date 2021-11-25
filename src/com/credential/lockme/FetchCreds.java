package com.credential.lockme;

import java.util.List;

import com.test.app.ReadUsers;
import com.test.app.User;

public class FetchCreds {

	public static boolean fetch(User user) {
		List<Creds> credList = ReadUsers.getUsersCreds(user);

		for (Creds credInfo : credList) {
			System.out.println(credInfo);
		}
		return false;
	}
}
