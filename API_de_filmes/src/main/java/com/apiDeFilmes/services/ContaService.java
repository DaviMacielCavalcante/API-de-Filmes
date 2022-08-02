package com.apiDeFilmes.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiDeFilmes.entities.Conta;
import com.apiDeFilmes.repositories.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository repository;
	
	public Conta find(Integer id) {
		Optional<Conta> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!Id: " + id, "Tipo: " + Conta.class.getName()));
	}
	
	
	public Conta insert(Conta obj) {
		obj.setId(null);
		obj = repository.save(obj);
		return repository.save(obj);
	}
	
	public Conta update(Integer id, Conta obj) {
		Conta newObj = find(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	public List<Conta> findAll(){
		return repository.findAll();
	}

	public void delete(Integer id) {
		find(id);		
		repository.deleteById(id);		
	}

	private void updateData(Conta newObj, Conta obj) {
		newObj.setTipoPlano(obj.getTipoPlano());	
		newObj.setEmail(obj.getEmail());
		newObj.setSenha(obj.getSenha());
		newObj.setTelefone(obj.getTelefone());
	}
}
