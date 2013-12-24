package com.epam.mentoring.configuration;

import com.epam.mentoring.core.Utils;

public class CredentialsConfiguration {

	private String login;
	private String password;
	private String userName;
	
//	you can get random row from this array 
	public CredentialsConfiguration(String[][] credentialsData) {
		int index = Utils.getRandomNumberInRange(0, 2);
		login = credentialsData[index][0];
		password = credentialsData[index][1];
		userName = credentialsData[index][2];
	}
	
	public CredentialsConfiguration(String[] credentialsData) {
		login = credentialsData[0];
		password = credentialsData[1];
		userName = credentialsData[2];
	}
	
	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public String getUserName() {
		return userName;
	}

	@Override
	public String toString() {
		return "CredentialsConfiguration [login=" + login + ", password=" + password + ", userName=" + userName + "]";
	}

}