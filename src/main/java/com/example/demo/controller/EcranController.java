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
import com.example.demo.model.Ecran;
import com.example.demo.model.repository.EcranRepository;

@RestController
public class EcranController {

	@Autowired
	EcranRepository ecranRepository;
	@GetMapping("ecrans")
	public List<Ecran> getAllEcrans()
	{
		return (List<Ecran>) ecranRepository.findAll();
		
		
	}
	@PostMapping("ecrans")
	public Ecran addEcran(@Valid @RequestBody Ecran ecran)
	{
		
		return ecranRepository.save(ecran);
		
	}
	// Get a Single Utilisateur
	@GetMapping("/ecrans/{id}")
	public Ecran getEcranById(@PathVariable(value = "id") Long ecranId) {
	    return ecranRepository.findById(ecranId)
	            .orElseThrow(() -> new ResourceNotFoundException("ecran", "id", ecranId));
	}
	  
	// Delete a Utilisateur
	@DeleteMapping("/ecrans/{id}")
	public ResponseEntity<?> deleteEcran(@PathVariable(value = "id") Long ecranId) {
	    Ecran ecran = ecranRepository.findById(ecranId)
	            .orElseThrow(() -> new ResourceNotFoundException("ecran", "id", ecranId));

	    ecranRepository.delete(ecran);

	    return ResponseEntity.ok().build();
	}
	
	
}