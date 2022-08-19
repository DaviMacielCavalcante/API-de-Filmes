package com.apiDeFilmes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiDeFilmes.entities.Ator;
import com.apiDeFilmes.entities.Diretor;
import com.apiDeFilmes.entities.Filmes;
import com.apiDeFilmes.entities.Genero;
import com.apiDeFilmes.entities.Roteirista;

@Repository
public interface FilmesRepository extends JpaRepository<Filmes, Integer>{

	List<Filmes> findByTitulo(String titulo);
	
	List<Filmes> findByGenero(Genero genero);
	
	List<Filmes> findByDiretor(Diretor diretor);
	
	List<Filmes> findByRoteirista(Roteirista diretor);
	
	List<Filmes> findByAtor(Ator ator);

}
