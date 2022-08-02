package com.apiDeFilmes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiDeFilmes.entities.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {

}
