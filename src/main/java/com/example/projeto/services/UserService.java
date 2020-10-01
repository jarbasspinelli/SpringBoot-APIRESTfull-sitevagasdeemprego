package com.example.projeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.projeto.entities.User;
import com.example.projeto.repositories.UserRepository;
import com.example.projeto.services.exception.ResourceNotFoundException;

@Service
public class UserService { 
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User save(User obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
		repository.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possivel excluir User com registros filhos!");
		}
	}
	
	public User update(User obj) {
		return repository.save(obj);
	}
}
