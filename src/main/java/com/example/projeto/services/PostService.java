package com.example.projeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.projeto.entities.Post;
import com.example.projeto.repositories.PostRepository;
import com.example.projeto.services.exception.ResourceNotFoundException;

@Service
public class PostService { 
	
	@Autowired
	private PostRepository repository;
	
	public List<Post> findAll() {
		return repository.findAll();
	}
	
	public Post findById(Long id) {
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Post save(Post obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Post update(Post obj) {
		return repository.save(obj);
	}
	
	public Page<Post> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
		return repository.findAll(pageRequest);		
	}
}
