package com.credential.lockme;

import java.io.Serializable;

public class Creds implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String id;
	public String userName;
	public String passwrod;
	public String siteName;

	public Creds(String id, String userName, String passwrod, String siteName) {
		super();
		this.id = id;
		this.userName = userName;
		this.passwrod = passwrod;
		this.siteName = siteName;
	}

	public Creds() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasswrod() {
		return passwrod;
	}

	public void setPasswrod(String passwrod) {
		this.passwrod = passwrod;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	@Override
	public String toString() {
		return "Creds [id=" + id + ", userName=" + userName + ", passwrod=" + passwrod + ", siteName=" + siteName + "]";
	}

}
