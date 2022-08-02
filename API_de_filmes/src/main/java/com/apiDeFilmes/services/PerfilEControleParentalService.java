package com.apiDeFilmes.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiDeFilmes.entities.PerfilEControleParental;
import com.apiDeFilmes.repositories.PerfilEControleParentalRepository;

@Service
public class PerfilEControleParentalService {

	@Autowired
	private PerfilEControleParentalRepository repository;
	
	public PerfilEControleParental find(Integer id) {
		Optional<PerfilEControleParental> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!Id: " + id, "Tipo: " + PerfilEControleParental.class.getName()));
	}
	
	
	public PerfilEControleParental insert(PerfilEControleParental obj) {
		obj.setId(null);
		obj = repository.save(obj);
		return repository.save(obj);
	}
	
	public PerfilEControleParental update(Integer id, PerfilEControleParental obj) {
		PerfilEControleParental newObj = find(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	public List<PerfilEControleParental> findAll(){
		return repository.findAll();
	}

	public void delete(Integer id) {
		find(id);		
		repository.deleteById(id);		
	}

	private void updateData(PerfilEControleParental newObj, PerfilEControleParental obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
		newObj.setRestricaoEtaria(obj.getRestricaoEtaria());
		newObj.setImagemURL(obj.getImagemURL());
	}
}
