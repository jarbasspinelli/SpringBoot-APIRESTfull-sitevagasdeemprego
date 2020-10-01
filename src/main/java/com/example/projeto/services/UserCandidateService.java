package com.example.projeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projeto.entities.UserCandidate;
import com.example.projeto.repositories.UserCandidateRepository;
import com.example.projeto.services.exception.ResourceNotFoundException;

@Service
public class UserCandidateService { 
	
	@Autowired
	private UserCandidateRepository repository;
	
	public List<UserCandidate> findAll() {
		return repository.findAll();
	}
	
	public UserCandidate findById(Long id) {
		Optional<UserCandidate> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public UserCandidate save(UserCandidate obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public UserCandidate update(UserCandidate obj) {
		return repository.save(obj);
	}
}
