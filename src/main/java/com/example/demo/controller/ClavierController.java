package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Clavier;
import com.example.demo.model.repository.ClavierRepository;

@RestController
public class ClavierController {

	@Autowired
	ClavierRepository clavierRepository;
	@GetMapping("claviers")
	public List<Clavier> getAllClaviers()
	{
		return (List<Clavier>) clavierRepository.findAll();
		
		
	}
	@PostMapping("claviers")
	public Clavier addClavier(@Valid @RequestBody Clavier clavier)
	{
		
		return clavierRepository.save(clavier);
		
	}
	// Get a Single Utilisateur
	@GetMapping("/claviers/{id}")
	public Clavier getClavierById(@PathVariable(value = "id") Long clavierId) {
	    return clavierRepository.findById(clavierId)
	            .orElseThrow(() -> new ResourceNotFoundException("clavier", "id", clavierId));
	}
	  
	// Delete a Utilisateur
	@DeleteMapping("/claviers/{id}")
	public ResponseEntity<?> deleteClavier(@PathVariable(value = "id") Long clavierId) {
	    Clavier clavier = clavierRepository.findById(clavierId)
	            .orElseThrow(() -> new ResourceNotFoundException("clavier", "id", clavierId));

	    clavierRepository.delete(clavier);

	    return ResponseEntity.ok().build();
	}
	
	
}