package com.dakor.app.data.entity;

import javax.persistence.*;

/**
 * .
 *
 * @author dkor
 */
@MappedSuperclass
public class AbstractUserEntity extends AbstractEntity {
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;

	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;

	@Column(name = "LOGIN_NAME", unique = true, nullable = false, length = 50)
	private String login;

	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@Column(name = "EMAIL", nullable = false, unique = true, length = 50)
	private String email;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ROLE_ID", nullable = false)
	private UserRoleEntity userRole;

	@PrePersist
	public void prePersist() {
		if (userRole == null) {
			userRole = new UserRoleEntity();
			userRole.setRole("USER");
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserRoleEntity getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRoleEntity userRole) {
		this.userRole = userRole;
	}
}
