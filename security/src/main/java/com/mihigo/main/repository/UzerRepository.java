package com.mihigo.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mihigo.main.domain.Uzer;


@Repository
public interface UzerRepository extends JpaRepository<Uzer, Integer> {

	Uzer findByUsername(String username);
}
