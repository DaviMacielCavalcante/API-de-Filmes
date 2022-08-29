package com.apiDeFilmes.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiDeFilmes.entities.Genero;
import com.apiDeFilmes.repositories.GeneroRepository;

@Service
public class GeneroService {

	@Autowired
	private GeneroRepository repo;
	
	public Genero findByNome(String nome) {
		Optional<Genero> obj = repo.findByNome(nome);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!Id: " + nome, "Tipo: " + Genero.class.getName()));
	}
	
}
