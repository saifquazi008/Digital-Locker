package com.test.lockme;

import java.util.List;
import java.util.Scanner;

import com.credential.lockme.Creds;
import com.credential.lockme.FatchBySite;
import com.credential.lockme.FetchCreds;
import com.credential.lockme.StoreCreds;
import com.test.app.LoginUser;
import com.test.app.ReadUsers;
import com.test.app.Registration;
import com.test.app.User;

public class MainTest {

	public static void main(String[] args) {

		System.out.println("==========================================");
		System.out.println("*					*");
		System.out.println("*   WELCOME TO LOCKME DIGITAL LOCKER	*");
		System.out.println("*					*");
		System.out.println("==========================================");

		System.out.println("--Please select your option--");
		System.out.println("==========================================");
		System.out.println("  --1) Register           2) Login --");
		Scanner scanner = new Scanner(System.in);
		int option = scanner.nextInt();
		switch (option) {
		case 1:
			User userReg = registerData();
			Registration.register(userReg);
			break;

		case 2:
			User userlog = loginData();
			boolean response = LoginUser.login(userlog);
			if (response) {

				afterLogin(userlog);
			}
			break;
		default:
			break;
		}
		scanner.close();
	}

	private static void afterLogin(User userlog) {
		System.out.println("==========================================");
		System.out.println("--Please select your option--");
		System.out.println("==========================================");
		System.out.println("  -- 1) Store Creds     2)  Fetch Creds --");
		Scanner keyboard = new Scanner(System.in);
		int option1 = keyboard.nextInt();
		switch (option1) {
		case 1:
			Creds userCreds = storeCredsData();
			StoreCreds.store(userlog, userCreds);
			break;
		case 2:

			afterFetching(userlog);

			break;
		}
		keyboard.close();
	}

	private static User registerData() {
		User user = new User();
		Scanner scanner = new Scanner(System.in);
		System.out.println("==========================================");
		System.out.println("*					*");
		System.out.println("*   WELCOME TO REGISTRATION PAGE	*");
		System.out.println("*					*");
		System.out.println("==========================================");
		System.out.println("Enter UserName : ");
		user.setName(scanner.nextLine());
		System.out.println("Enter Email  : ");
		user.setEmail(scanner.nextLine());
		System.out.println("Enter Password : ");
		user.setPassword(scanner.nextLine());
		System.out.println("Enter Confirm Password : ");
		user.setCnfPassword(scanner.nextLine());
		return user;
	}

	private static User loginData() {
		User user = new User();
		Scanner scanner = new Scanner(System.in);
		System.out.println("==========================================");
		System.out.println("*					*");
		System.out.println("*   WELCOME TO LOGIN PAGE	 *");
		System.out.println("*					*");
		System.out.println("==========================================");
		System.out.println("Enter UserName");
		user.setName(scanner.nextLine());
		System.out.println("Enter Password : ");
		user.setPassword(scanner.nextLine());
		return user;
	}

	private static Creds storeCredsData() {
		Creds creds = new Creds();
		Scanner scanner = new Scanner(System.in);
		System.out.println("==========================================");
		System.out.println("*					*");
		System.out.println("*   WELCOME TO STORE CREDS PAGE	*");
		System.out.println("*					*");
		System.out.println("==========================================");

		System.out.println("Enter UserID : ");
		creds.setId(scanner.nextLine());
		System.out.println("Enter UserName : ");
		creds.setUserName(scanner.nextLine());
		System.out.println("Enter Site Name  : ");
		creds.setSiteName(scanner.nextLine());
		System.out.println("Enter Password : ");
		creds.setPasswrod(scanner.nextLine());
		return creds;

	}

	private static String fatchBySite() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Site Name : ");
		return sc.nextLine();

	}

	public static void afterFetching(User userlog) {

		System.out.println("==========================================");
		System.out.println("--Please select your option--");
		System.out.println("==========================================");
		System.out.println("--1)  Fetch All    2)Fetch By SiteName--");
		Scanner sc1 = new Scanner(System.in);
		int option1 = sc1.nextInt();

		switch (option1) {
		case 1: {
			ReadUsers.getUsersCreds(userlog);
			break;
		}
		case 2: {
			String siteName = fatchBySite();
			List<Creds> credList = ReadUsers.getUsersCreds(userlog);
			FatchBySite.fatchingByeSite(credList, siteName);
			break;

		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + option1);

		}

	}

}
