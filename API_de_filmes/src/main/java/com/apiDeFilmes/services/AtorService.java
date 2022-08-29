package com.apiDeFilmes.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiDeFilmes.entities.Ator;
import com.apiDeFilmes.repositories.AtorRepository;

@Service
public class AtorService {

	@Autowired
	private AtorRepository repo;
	
	public Ator findByNome(String nome) {
		Optional<Ator> obj = repo.findByNome(nome);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!Id: " + nome, "Tipo: " + Ator.class.getName()));
	}
	
}
