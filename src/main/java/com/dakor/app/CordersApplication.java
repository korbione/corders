package com.dakor.app;

import com.dakor.app.data.entity.UserEntity;
import com.dakor.app.service.IUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@Profile("dev")
public class CordersApplication {

	public static void main(String[] args) {
		SpringApplication.run(CordersApplication.class, args);
	}

	@Bean
	CommandLineRunner getCommandLineRunner(IUserService userService) {
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
