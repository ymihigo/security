package com.mihigo.main.service;

import java.util.List;

import com.mihigo.main.domain.Role;
import com.mihigo.main.domain.Uzer;

public interface UzerService {
	Uzer createUser(Uzer uzer);

	Role createRole(Role role);

	void addRoleToUser(String username, String role);

	Uzer getUzer(String username);
	
	List<Uzer> getUser();

}
