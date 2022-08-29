package com.apiDeFilmes.repositories;

import java.util.List;
import java.util.stream.Collectors;

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
	
	default List<Filmes> findByGenero(Genero genero){
		List<Filmes> filmes = findAll();
		List<Filmes> filmesG = filmes.stream().filter(Filmes ->
		Filmes.getGeneros().contains(genero)).collect(Collectors.toList());
		return filmesG;
	}
	
	default List<Filmes> findByDiretor(Diretor diretor) {
		List<Filmes> filmes = findAll();	
		List<Filmes> filmesDir = filmes.stream().filter(Filmes -> Filmes.getDirecao().contains(diretor)).collect(Collectors.toList());
		return filmesDir;		
	}
	
	default List<Filmes> findByRoteirista(Roteirista roteirista) {
		List<Filmes> filmes = findAll();	
		List<Filmes> filmesR = filmes.stream().filter(Filmes -> Filmes.getRoteiro().contains(roteirista)).collect(Collectors.toList());
		return filmesR;
	}

	default List<Filmes> findByAtor(Ator ator) {
		List<Filmes> filmes = findAll();	
		List<Filmes> filmesAtor = filmes.stream().filter(Filmes -> Filmes.getElenco().contains(ator)).collect(Collectors.toList());
		return filmesAtor;
	}

}
