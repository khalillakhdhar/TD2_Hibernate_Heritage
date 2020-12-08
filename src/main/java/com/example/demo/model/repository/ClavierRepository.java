package com.example.demo.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Clavier;
import com.example.demo.model.Ecran;

public interface ClavierRepository extends CrudRepository<Clavier, Long> {

}
