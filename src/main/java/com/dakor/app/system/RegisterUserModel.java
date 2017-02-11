package com.dakor.app.system;

import java.io.Serializable;

/**
 * .
 *
 * @author dkor
 */
public class RegisterUserModel implements Serializable {
	private static final long serialVersionUID = -8385037422114007668L;

	public String username;
	public String password;
	public String confirmPassword;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}
