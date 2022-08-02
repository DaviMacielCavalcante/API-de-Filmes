package com.apiDeFilmes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiDeFilmes.entities.Ator;
import com.apiDeFilmes.entities.Diretor;
import com.apiDeFilmes.entities.Filme;
import com.apiDeFilmes.entities.Genero;
import com.apiDeFilmes.entities.Roteirista;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer> {

	List<Filme> findByTitulo(String titulo);
	
	List<Filme> findByGenero(Genero genero);
	
	List<Filme> findByDiretor(Diretor diretor);
	
	List<Filme> findByRoteirista(Roteirista diretor);
	
	List<Filme> findByAtor(Ator ator);

}
