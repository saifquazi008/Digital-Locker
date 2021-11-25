package com.test.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import java.util.List;

import com.credential.lockme.Creds;

public class ReadUsers {

	public static List<User> getUsers() {
		// empty list
		List<User> userList = new LinkedList<User>();
		File f = new File("lockme-db-users.txt");
		if (f.exists()) {
			try {
				FileInputStream file = new FileInputStream("lockme-db-users.txt");
				ObjectInputStream input = new ObjectInputStream(file);
				userList = (List<User>) input.readObject();
				input.close();
				file.close();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}

		}
		return userList;
	}

	public static List<Creds> getUsersCreds(User user) {
		// empty list
		List<Creds> credsList = new LinkedList<Creds>();
		File f = new File(user.getName() + "lockme-db-Creds.txt");
		if (f.exists()) {
			try {
				FileInputStream file = new FileInputStream(user.getName() + "lockme-db-Creds.txt");
				ObjectInputStream input = new ObjectInputStream(file);
				credsList = (List<Creds>) input.readObject();
				input.close();
				file.close();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}

		}
		return credsList;

	}
}
