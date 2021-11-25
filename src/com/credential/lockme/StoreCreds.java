package com.credential.lockme;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

import com.test.app.ReadUsers;
import com.test.app.User;

public class StoreCreds {

	public static boolean store(User user, Creds cred) {
		List<Creds> credsList = ReadUsers.getUsersCreds(user);
		if (!credsList.isEmpty()) {
			credsList = ReadUsers.getUsersCreds(user);
		} else {
			credsList = new LinkedList<Creds>();
			System.out.println("Store Credential !");
		}
		credsList.add(cred);
		try {
			FileOutputStream file = new FileOutputStream(user.getName() + "lockme-db-Creds.txt");
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(credsList);
			out.close();
			file.close();
			System.out.println("Store Credential successfull !");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
}
