package com.example.demo.model;

import javax.persistence.Entity;

@Entity
public class Ecran extends Device {
String qualite;
int resolution;
public String getQualite() {
	return qualite;
}
public void setQualite(String qualite) {
	this.qualite = qualite;
}
public int getResolution() {
	return resolution;
}
public void setResolution(int resolution) {
	this.resolution = resolution;
}



}
