package com.apiDeFilmes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiDeFilmes.entities.perfil_e_controle_parental;

@Repository
public interface PerfilEControleParentalRepository extends JpaRepository<perfil_e_controle_parental, Integer> {

}
