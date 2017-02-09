package com.dakor.app.service.impl;

import com.dakor.app.data.dao.IUserDao;
import com.dakor.app.data.entity.UserEntity;
import com.dakor.app.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * .
 *
 * @author dkor
 */
@Service
public class UserService implements IUserService {

	private final IUserDao userDao;

	@Autowired
	public UserService(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<UserEntity> getAllUsers() {
		return userDao.findAll();
	}

	@Override
	public UserEntity getUserByLoginName(String login) {
		return userDao.findByLogin(login);
	}

	@Transactional
	@Override
	public void save(UserEntity userEntity) {
		userDao.save(userEntity);
	}

	@Transactional
	@Override
	public void delete(UserEntity userEntity) {
		userDao.delete(userEntity);
	}
}
