package com.dakor.app.data.dao;

import com.dakor.app.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * .
 *
 * @author dkor
 */
public interface IUserDao extends JpaRepository<UserEntity, String> {

    UserEntity findByLogin(String login);
}
