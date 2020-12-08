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
import com.example.demo.model.Device;
import com.example.demo.model.repository.DeviceRepository;

@RestController
public class DeviceController {

	@Autowired
	DeviceRepository deviceRepository;
	@GetMapping("devices")
	public List<Device> getAllDevices()
	{
		return (List<Device>) deviceRepository.findAll();
		
		
	}
	@PostMapping("devices")
	public Device addDevice(@Valid @RequestBody Device device)
	{
		
		return deviceRepository.save(device);
		
	}
	// Get a Single Utilisateur
	@GetMapping("/devices/{id}")
	public Device getDeviceById(@PathVariable(value = "id") Long deviceId) {
	    return deviceRepository.findById(deviceId)
	            .orElseThrow(() -> new ResourceNotFoundException("device", "id", deviceId));
	}
	  
	// Delete a Utilisateur
	@DeleteMapping("/devices/{id}")
	public ResponseEntity<?> deleteDevice(@PathVariable(value = "id") Long deviceId) {
	    Device device = deviceRepository.findById(deviceId)
	            .orElseThrow(() -> new ResourceNotFoundException("device", "id", deviceId));

	    deviceRepository.delete(device);

	    return ResponseEntity.ok().build();
	}
	
	
}