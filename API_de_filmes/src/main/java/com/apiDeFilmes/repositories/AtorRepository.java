package com.apiDeFilmes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiDeFilmes.entities.Ator;

@Repository
public interface AtorRepository extends JpaRepository<Ator, Integer> {

}
