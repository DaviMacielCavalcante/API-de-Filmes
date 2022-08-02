package com.apiDeFilmes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiDeFilmes.entities.PerfilEControleParental;

@Repository
public interface PerfilEControleParentalRepository extends JpaRepository<PerfilEControleParental, Integer> {

}
