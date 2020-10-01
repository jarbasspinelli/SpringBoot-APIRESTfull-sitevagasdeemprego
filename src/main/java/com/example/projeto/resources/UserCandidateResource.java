package com.example.projeto.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.projeto.services.UserCandidateService;

@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
@RestController
@RequestMapping(value="/userscandidate")
public class UserCandidateResource {
	
	@Autowired
	private UserCandidateService service;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@GetMapping
	public ResponseEntity<List<com.example.projeto.entities.UserCandidate>> findAll() {
		List<com.example.projeto.entities.UserCandidate> u = service.findAll();
		return ResponseEntity.ok().body(u);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<com.example.projeto.entities.UserCandidate> findById(@PathVariable Long id) {
			com.example.projeto.entities.UserCandidate u = service.findById(id);
			return ResponseEntity.ok().body(u);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody @Validated @Valid com.example.projeto.entities.UserCandidate obj) {
		obj = service.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("Novo usuario criado");
        message.setText("Usuário" + obj + "Criado com Sucesso");
        message.setTo(obj.getEmail());
        message.setFrom("jfcspinelli@gmail.com");
        mailSender.send(message);
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody @Valid com.example.projeto.entities.UserCandidate obj, @PathVariable Long id) {
		((com.example.projeto.entities.UserCandidate) obj).setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
}
