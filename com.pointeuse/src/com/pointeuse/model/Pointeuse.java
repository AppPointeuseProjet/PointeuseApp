package com.pointeuse.model;

public class Pointeuse extends AbstractModel{

	@Override
	public void setName(String name) {
		this.name=name;
		notifyObserveur(name);	
	}

	@Override
	public void setSurname(String surname) {
		this.surname=surname;
		notifyObserveur(surname);
	}

	@Override
	public void setGranted(boolean granted) {
		this.granted=granted;
	//	notifyObserveur(granted);
	}
}
