package com.dakor.app.system;

import com.dakor.app.util.ToStringUtils;
import org.apache.commons.lang3.Validate;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;

/**
 * .
 *
 * @author dkor
 */
public class User extends org.springframework.security.core.userdetails.User {

	public User(String username, String password, String role) {
		super(username, password, Collections.singleton(new SimpleGrantedAuthority(Validate.notNull(role))));
	}

	@Override
	public String toString() {
		return ToStringUtils.getBuilder(this)
				.append("username", getUsername())
				.append("password", getPassword())
				.append("role", getAuthorities().iterator().next().getAuthority())
				.toString();
	}
}
