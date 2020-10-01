package com.example.projeto.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.projeto.entities.Jobs;
import com.example.projeto.services.JobsService;

@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
@RestController
@RequestMapping(value="/jobs")
public class JobsResource {
	
	@Autowired
	private JobsService service;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@GetMapping
	public ResponseEntity<List<Jobs>> findAll() {
		List<Jobs> u = service.findAll();
		return ResponseEntity.ok().body(u);
	}
	
	@GetMapping(value="/page")
	public ResponseEntity<Page<Jobs>> findPage(
			@RequestParam(value="page", defaultValue = "0")Integer page, 
			@RequestParam(value="linesPerPage", defaultValue = "24")Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue = "title")String orderBy, 
			@RequestParam(value="direction", defaultValue = "ASC")String direction) {
		Page<Jobs> u = service.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(u);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Jobs> findById(@PathVariable Long id) {
		Jobs u = service.findById(id);
		return ResponseEntity.ok().body(u);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody @Validated @Valid Jobs obj) {
		obj = service.save(obj);
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("Nova Vaga Cadastrada" + obj.getTitle());
        message.setText("Vaga" + obj.getTitle() + "Criado com Sucesso, Usuario responsavel: " + obj.getUser());
        message.setTo("jfcspinelli@gmail.com");
        message.setFrom("jfcspinelli@gmail.com");
        mailSender.send(message);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody @Valid Jobs obj, @PathVariable Long id) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
}
