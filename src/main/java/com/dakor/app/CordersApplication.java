package com.dakor.app;

import com.dakor.app.data.entity.UserEntity;
import com.dakor.app.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@SpringBootApplication
public class CordersApplication {
	@Autowired
	private IUserService userService;
/*
	@RequestMapping("/")
	public String welcome(@RequestParam("p") String param) {
		String name;

		if (param.equals("1")) {
			name = userService.getUserByLoginName("guest").getFirstName();
		} else {
			name = userService.getUserByLoginName("login").getLastName();
		}

		return "welcome, " + name;
	}*/

	public static void main(String[] args) {
		SpringApplication.run(CordersApplication.class, args);
	}

	@Bean
	CommandLineRunner getCommandLineRunner() {
		return args -> {
			if (userService.getUserByLoginName("login") == null) {
				UserEntity user = new UserEntity();
				user.setLogin("login");
				user.setFirstName("first name");
				user.setLastName("last name");
				user.setPassword("123456");
				user.setEmail("dakor@meta.ua");
				userService.save(user);
			}

			if (userService.getUserByLoginName("guest") == null) {
				UserEntity user = new UserEntity();
				user.setLogin("guest");
				user.setFirstName("guest name");
				user.setLastName("guest surname");
				user.setPassword("quest");
				user.setEmail("guest@mail.com");
				userService.save(user);
			}
		};
	}
}
