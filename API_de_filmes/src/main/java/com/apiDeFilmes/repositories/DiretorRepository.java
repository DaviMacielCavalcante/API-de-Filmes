package com.apiDeFilmes.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiDeFilmes.entities.Diretor;

@Repository
public interface DiretorRepository extends JpaRepository<Diretor, Integer> {	
	
	Optional<Diretor> findByNome(String name);
}
