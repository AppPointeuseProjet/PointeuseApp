package com.pointeuse.model;

import java.util.ArrayList;

import com.pointeuse.observer.Observable;
import com.pointeuse.observer.Observeur;

public  abstract class AbstractModel implements Observable{
	protected String  name    = "";
	protected String  surname = "";
	protected boolean granted = false ;
	
	private ArrayList<Observeur> listObserver = new ArrayList<Observeur>();
	
	//Définit le  prénom entré par l'utilisateur
	public abstract void setName(String name);
	
	 //Définit le nombre à utiliser pour l'opération
	public abstract void setSurname(String surname);
	
	public abstract void setGranted(boolean granted);
	
	
	//Implémentation du pattern observer
	  public void addObserveur(Observeur vue) {
	    this.listObserver.add(vue);
	  }

	  public void removeObserveur(	Observeur vue ) {
	    listObserver.remove(vue);
	  }
	  
	  public void notifyObserveur(String str) {
		  for(Observeur vue : listObserver)
	          vue.onMdodelChange(name, surname,granted);
	  }

	
}
