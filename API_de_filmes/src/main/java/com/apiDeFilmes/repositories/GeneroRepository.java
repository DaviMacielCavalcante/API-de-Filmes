package com.apiDeFilmes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiDeFilmes.entities.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer> {

}
