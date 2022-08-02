package com.apiDeFilmes.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiDeFilmes.entities.Genero;
import com.apiDeFilmes.repositories.GeneroRepository;

@Service
public class GeneroService {

	@Autowired
	private GeneroRepository repository;
	
	public Genero find(Integer id) {
		Optional<Genero> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!Id: " + id, "Tipo: " + Genero.class.getName()));
	}
	
	
	public Genero insert(Genero obj) {
		obj.setId(null);
		obj = repository.save(obj);
		return repository.save(obj);
	}
	
	public Genero update(Integer id, Genero obj) {
		Genero newObj = find(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	public List<Genero> findAll(){
		return repository.findAll();
	}

	public void delete(Integer id) {
		find(id);		
		repository.deleteById(id);		
	}

	private void updateData(Genero newObj, Genero obj) {
		newObj.setNome(obj.getNome());;		
	}
}
