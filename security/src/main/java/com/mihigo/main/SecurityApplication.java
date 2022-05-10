package com.mihigo.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mihigo.main.domain.Role;
import com.mihigo.main.domain.Uzer;
import com.mihigo.main.service.UzerService;

@SpringBootApplication
public class SecurityApplication implements CommandLineRunner {

	@Autowired
	private UzerService us;

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {
		us.createRole(new Role("ROLE_USER"));
		us.createRole(new Role("ROLE_MANAGER"));
		us.createRole(new Role("ROLE_ADMIN"));
		us.createRole(new Role("ROLE_SUPER_ADMIN"));

		us.createUser(new Uzer("mihigo", "mihigo", "password"));
		us.createUser(new Uzer("uwineza", "uwineza", "password"));
		us.createUser(new Uzer("bamenya", "bamenya", "password"));
		us.createUser(new Uzer("banange", "banange", "password"));

		us.addRoleToUser("mihigo", "ROLE_USER");
		us.addRoleToUser("mihigo", "ROLE_ADMIN");
		us.addRoleToUser("uwineza", "ROLE_MANAGER");
		us.addRoleToUser("bamenya", "ROLE_ADMIN");
		us.addRoleToUser("banange", "ROLE_SUPER_ADMIN");

	}

}
