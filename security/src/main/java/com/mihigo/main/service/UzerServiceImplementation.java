package com.mihigo.main.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mihigo.main.domain.Role;
import com.mihigo.main.domain.Uzer;
import com.mihigo.main.repository.RoleRepository;
import com.mihigo.main.repository.UzerRepository;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UzerServiceImplementation implements UzerService {

	@Autowired
	private UzerRepository uz;
	@Autowired
	private RoleRepository rolerepo;

	@Override
	public Uzer createUser(Uzer uzer) {
		return uz.saveAndFlush(uzer);
	}

	@Override
	public Role createRole(Role role) {

		return rolerepo.saveAndFlush(role);
	}

	@Override
	public void addRoleToUser(String username, String role) {
		Uzer u = uz.findByUsername(username);
		Role r = rolerepo.findByRole(role);
		u.getRoles().add(r);

	}

	@Override
	public Uzer getUzer(String username) {
		return uz.findByUsername(username);
	}

	@Override
	public List<Uzer> getUser() {
		return uz.findAll();
	}

}
