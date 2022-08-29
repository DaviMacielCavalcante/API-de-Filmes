package com.apiDeFilmes.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiDeFilmes.entities.Roteirista;

@Repository
public interface RoteiristaRepository extends JpaRepository<Roteirista, Integer> {	
	
	Optional<Roteirista> findByNome(String nome);
}
