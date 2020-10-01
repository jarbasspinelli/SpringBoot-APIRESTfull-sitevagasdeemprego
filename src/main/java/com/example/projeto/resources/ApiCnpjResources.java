package com.example.projeto.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value="/apicnpj")
@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
public class ApiCnpjResources {
	
	@GetMapping
	@RequestMapping(value="/{cnpj}")
	public ResponseEntity<ResponseEntity<String>> find(@PathVariable(value="cnpj", required=false) String cnpj) {
		String url = "https://www.receitaws.com.br/v1/cnpj/" + cnpj;
		RestTemplate urln = new RestTemplate();
		ResponseEntity<String> url2 = urln.getForEntity(url, String.class);
		ResponseEntity<String> response = url2;
		return ResponseEntity.ok().body(response);
	}
}
