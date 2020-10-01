package com.example.projeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.projeto.entities.Jobs;
import com.example.projeto.repositories.JobsRepository;
import com.example.projeto.services.exception.ResourceNotFoundException;

@Service
public class JobsService { 
	
	@Autowired
	private JobsRepository repository;
	
	public List<Jobs> findAll() {
		return repository.findAll();
	}
	
	public Jobs findById(Long id) {
		Optional<Jobs> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Jobs save(Jobs obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Jobs update(Jobs obj) {
		return repository.save(obj);
	}
	
	public Page<Jobs> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
		return repository.findAll(pageRequest);
		
	}
}
