package com.credential.lockme;

import java.util.LinkedList;
import java.util.List;

public class FatchBySite {

	public static void fatchingByeSite(List<Creds> credList, String siteName) {

		try {
			int match = 0;
			for (Creds userCred : credList) {
				if (userCred.getSiteName().equals(siteName)) {
					System.out.println("Site Name : " + userCred.getSiteName());
					System.out.println("Site userName : " + userCred.getUserName());
					System.out.println("Site password : " + userCred.getPasswrod());

				}

				if (match == 0) {
					System.out.println("Site name does not match please try again ! ");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
