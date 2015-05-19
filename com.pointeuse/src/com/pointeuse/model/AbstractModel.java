package com.pointeuse.model;

import java.util.ArrayList;

import com.pointeuse.observer.Observable;
import com.pointeuse.observer.Observeur;

public  abstract class AbstractModel implements Observable{
	protected String  name    = "";
	protected String  surname = "";
	protected boolean granted = false ;
	
	private ArrayList<Observeur> listObserver = new ArrayList<Observeur>();
	
	//D�finit le  pr�nom entr� par l'utilisateur
	public abstract void setName(String name);
	
	 //D�finit le nombre � utiliser pour l'op�ration
	public abstract void setSurname(String surname);
	
	public abstract void setGranted(boolean granted);
	
	
	//Impl�mentation du pattern observer
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
