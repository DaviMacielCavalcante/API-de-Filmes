package com.apiDeFilmes.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiDeFilmes.entities.Roteirista;
import com.apiDeFilmes.repositories.RoteiristaRepository;

@Service
public class RoteiristaService {

	@Autowired
	private RoteiristaRepository repo;
	
	public Roteirista findByNome(String nome) {
		Optional<Roteirista> obj = repo.findByNome(nome);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!Id: " + nome, "Tipo: " + Roteirista.class.getName()));
	}
	
}
