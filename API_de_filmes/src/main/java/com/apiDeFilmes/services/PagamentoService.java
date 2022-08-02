package com.apiDeFilmes.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiDeFilmes.entities.Pagamento;
import com.apiDeFilmes.repositories.PagamentoRepository;

@Service
public class PagamentoService {

	@Autowired
	private PagamentoRepository repository;
	
	public Pagamento find(Integer id) {
		Optional<Pagamento> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!Id: " + id, "Tipo: " + Pagamento.class.getName()));
	}
	
	
	public Pagamento insert(Pagamento obj) {
		obj.setId(null);
		obj = repository.save(obj);
		return repository.save(obj);
	}
	
	public Pagamento update(Integer id, Pagamento obj) {
		Pagamento newObj = find(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	public List<Pagamento> findAll(){
		return repository.findAll();
	}

	public void delete(Integer id) {
		find(id);		
		repository.deleteById(id);		
	}

	private void updateData(Pagamento newObj, Pagamento obj) {
		newObj.setNumeroCartao(obj.getNumeroCartao());
		newObj.setDatacobranca(obj.getDatacobranca());
		newObj.setTipoCartao(obj.getTipoCartao());
	}
}
