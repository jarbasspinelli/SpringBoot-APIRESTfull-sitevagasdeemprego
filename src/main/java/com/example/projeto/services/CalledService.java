package com.example.projeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projeto.entities.Called;
import com.example.projeto.repositories.CalledRepository;
import com.example.projeto.services.exception.ResourceNotFoundException;

@Service
public class CalledService { 
	
	@Autowired
	private CalledRepository repository;
	
	public List<Called> findAll() {
		return repository.findAll();
	}
	
	public Called findById(Long id) {
		Optional<Called> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
		
	}
	
	public Called save(Called obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Called update(Called obj) {
		return repository.save(obj);
	}
}
