package com.apiDeFilmes.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiDeFilmes.entities.Ator;
import com.apiDeFilmes.repositories.AtorRepository;

@Service
public class AtorService {

	@Autowired
	private AtorRepository repository;
	
	public Ator find(Integer id) {
		Optional<Ator> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!Id: " + id, "Tipo: " + Ator.class.getName()));
	}
	
	
	public Ator insert(Ator obj) {
		obj.setId(null);
		obj = repository.save(obj);
		return repository.save(obj);
	}
	
	public Ator update(Integer id, Ator obj) {
		Ator newObj = find(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	public List<Ator> findAll(){
		return repository.findAll();
	}

	public void delete(Integer id) {
		find(id);		
		repository.deleteById(id);		
	}

	private void updateData(Ator newObj, Ator obj) {
		newObj.setNome(obj.getNome());;		
	}
}
