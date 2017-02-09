package com.dakor.app;

import com.dakor.app.data.dao.IUserDao;
import com.dakor.app.data.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@SpringBootApplication
public class CordersApplication {
	@Autowired
	private IUserDao userDao;

	@RequestMapping("/")
	public String welcome(@RequestParam("p") String param) {
		String name;

		List<UserEntity> users = userDao.findAll(new Sort(new Sort.Order(Sort.Direction.DESC, "id")));
		if (param.equals("1")) {
			name = users.get(0).getName();
		} else {
			name = users.get(1).getName();
		}

		return "welcome, " + name;
	}

	public static void main(String[] args) {
		SpringApplication.run(CordersApplication.class, args);
	}

	@Bean
	CommandLineRunner getCommandLineRunner() {
		return args -> {
			List<UserEntity> users = new ArrayList<>();
			UserEntity user = new UserEntity();
			user.setLogin("login");
			user.setName("name");
			user.setCreatedDate(new Date());
			users.add(user);

			user = new UserEntity();
			user.setLogin("guest");
			user.setName("guest");
			user.setCreatedDate(new Date());
			users.add(user);

			userDao.save(users);
		};
	}
}
