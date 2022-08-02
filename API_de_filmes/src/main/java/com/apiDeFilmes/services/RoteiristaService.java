package com.apiDeFilmes.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiDeFilmes.entities.Roteirista;
import com.apiDeFilmes.repositories.RoteiristaRepository;

@Service
public class RoteiristaService {

	@Autowired
	private RoteiristaRepository repository;
	
	public Roteirista find(Integer id) {
		Optional<Roteirista> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!Id: " + id, "Tipo: " + Roteirista.class.getName()));
	}
	
	
	public Roteirista insert(Roteirista obj) {
		obj.setId(null);
		obj = repository.save(obj);
		return repository.save(obj);
	}
	
	public Roteirista update(Integer id, Roteirista obj) {
		Roteirista newObj = find(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	public List<Roteirista> findAll(){
		return repository.findAll();
	}

	public void delete(Integer id) {
		find(id);		
		repository.deleteById(id);		
	}

	private void updateData(Roteirista newObj, Roteirista obj) {
		newObj.setNome(obj.getNome());;		
	}
}
