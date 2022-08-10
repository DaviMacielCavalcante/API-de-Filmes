package com.apiDeFilmes.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.apiDeFilmes.entities.Genero;
import com.apiDeFilmes.services.GeneroService;

@RestController
@RequestMapping(value = "/generos")
public class GeneroResource {

	@Autowired
	private GeneroService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		
		Genero obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> insert(@RequestBody Genero obj){
		
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}" ,method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody Genero obj, @PathVariable Integer id){
		
		obj.setId(id);
		
		obj = service.update(id, obj);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}" ,method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Integer id){
		
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
}
