package com.apiDeFilmes.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiDeFilmes.entities.perfil_e_controle_parental;
import com.apiDeFilmes.repositories.PerfilEControleParentalRepository;

@Service
public class PerfilEControleParentalService {

	@Autowired
	private PerfilEControleParentalRepository repository;
	
	public perfil_e_controle_parental find(Integer id) {
		Optional<perfil_e_controle_parental> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!Id: " + id, "Tipo: " + perfil_e_controle_parental.class.getName()));
	}
	
	
	public perfil_e_controle_parental insert(perfil_e_controle_parental obj) {
		obj.setId(null);
		obj = repository.save(obj);
		return repository.save(obj);
	}
	
	public perfil_e_controle_parental update(Integer id, perfil_e_controle_parental obj) {
		perfil_e_controle_parental newObj = find(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	public List<perfil_e_controle_parental> findAll(){
		return repository.findAll();
	}

	public void delete(Integer id) {
		find(id);		
		repository.deleteById(id);		
	}

	private void updateData(perfil_e_controle_parental newObj, perfil_e_controle_parental obj) {
		newObj.setNome(obj.getNome());
		newObj.setRestricaoEtaria(obj.getRestricaoEtaria());
		newObj.setImagemURL(obj.getImagemURL());
	}
}
