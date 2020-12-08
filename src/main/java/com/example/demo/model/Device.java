package com.example.demo.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.TableGenerator;

@Entity //table dans la BD
@Inheritance(strategy = InheritanceType.JOINED) //la jointure se crée avec l'héritage
@DiscriminatorColumn(name = "Type") //il fait la differences entre les instances et dans la base de données
@TableGenerator(name = "device_GEN", table = "Id_GEN",
pkColumnName = "GEN_name", valueColumnName = "GEN_value", allocationSize
= 1)
public class Device {
@Id
long id;
String device_name;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getDevice_name() {
	return device_name;
}
public void setDevice_name(String device_name) {
	this.device_name = device_name;
}




}
