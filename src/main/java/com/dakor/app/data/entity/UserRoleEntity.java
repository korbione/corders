package com.dakor.app.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * .
 *
 * @author dkor
 */
@Entity
@Table(name = "USER_ROLES")
public class UserRoleEntity extends AbstractEntity {
	@Column(name = "ROLE", nullable = false, length = 30)
	private String role;

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
