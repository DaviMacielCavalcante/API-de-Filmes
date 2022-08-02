package com.apiDeFilmes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiDeFilmes.entities.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer> {

}
