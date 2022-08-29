package com.apiDeFilmes.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiDeFilmes.entities.Diretor;
import com.apiDeFilmes.repositories.DiretorRepository;

@Service
public class DiretorService {

	@Autowired
	private DiretorRepository repo;
	
	public Diretor findByNome(String nome) {
		Optional<Diretor> obj = repo.findByNome(nome);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!Id: " + nome, "Tipo: " + Diretor.class.getName()));
	}
	
}
