package com.mihigo.main.controller;

import java.net.URI;
import java.util.List;

import javax.servlet.Servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mihigo.main.domain.Role;
import com.mihigo.main.domain.Uzer;
import com.mihigo.main.service.UzerService;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserResources {

	@Autowired
	private UzerService uz;

	@GetMapping("/users")
	public ResponseEntity<List<Uzer>> getAlluzers() {
		return ResponseEntity.ok().body(uz.getUser());
	}

	@PostMapping("/users/new")
	public ResponseEntity<?> createUser(@RequestBody Uzer uzer) {
		URI uri = java.net.URI
				.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/users/new").toUriString());
		return ResponseEntity.created(uri).body(uz.createUser(uzer));
	}

	@PostMapping("/role/new")
	public ResponseEntity<?> createRole(@RequestBody Role role) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/new").toUriString());
		return ResponseEntity.created(uri).body(uz.createRole(role));
	}

	@PostMapping("/users/addrole")
	public ResponseEntity<?> roleToUser(@RequestBody RoleToUser rtu) {

		URI uri = URI
				.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/users/addrole").toUriString());
		uz.addRoleToUser(rtu.getUsername(), rtu.getPassword());
		return ResponseEntity.ok().build();
	}
}

@Data
class RoleToUser {
	private String username;
	private String password;

	public RoleToUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoleToUser(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
