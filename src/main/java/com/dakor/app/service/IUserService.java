package com.dakor.app.service;

import com.dakor.app.data.entity.UserEntity;

import java.util.List;

/**
 * .
 *
 * @author dkor
 */
public interface IUserService {

	List<UserEntity> getAllUsers();

	UserEntity getUserByLoginName(String login);

	void save(UserEntity userEntity);

	void delete(UserEntity userEntity);
}
