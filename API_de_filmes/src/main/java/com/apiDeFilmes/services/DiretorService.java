package com.apiDeFilmes.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiDeFilmes.entities.Diretor;
import com.apiDeFilmes.repositories.DiretorRepository;

@Service
public class DiretorService {

	@Autowired
	private DiretorRepository repository;
	
	public Diretor find(Integer id) {
		Optional<Diretor> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!Id: " + id, "Tipo: " + Diretor.class.getName()));
	}
	
	
	public Diretor insert(Diretor obj) {
		obj.setId(null);
		obj = repository.save(obj);
		return repository.save(obj);
	}
	
	public Diretor update(Integer id, Diretor obj) {
		Diretor newObj = find(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	public List<Diretor> findAll(){
		return repository.findAll();
	}

	public void delete(Integer id) {
		find(id);		
		repository.deleteById(id);		
	}

	private void updateData(Diretor newObj, Diretor obj) {
		newObj.setNome(obj.getNome());;		
	}
}
