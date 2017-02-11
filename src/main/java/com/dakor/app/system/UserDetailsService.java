package com.dakor.app.system;

import com.dakor.app.data.entity.UserEntity;
import com.dakor.app.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * .
 *
 * @author dkor
 */
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private IUserService userService;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		User user = null;

		if (StringUtils.isNotBlank(login)) {
			UserEntity userEntity = userService.getUserByLoginName(login);
			if (userEntity != null) {
				user = new User(login, userEntity.getPassword(), userEntity.getRole().name());
			}
		}

		log.info("Logging for the user: " + user);

		return user;
	}
}
