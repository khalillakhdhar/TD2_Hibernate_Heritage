package com.example.demo.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Device;
import com.example.demo.model.Ecran;

public interface DeviceRepository extends CrudRepository<Device, Long> {

}
