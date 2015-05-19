package com.pointeuse.controler;

import com.pointeuse.model.AbstractModel;

public abstract class AbstractControler {
    
	protected AbstractModel modelPointeuse;
	
	public AbstractControler(AbstractModel pointe){
	    this.modelPointeuse = pointe;
	}
	    //Définit l'opérateur
	    public void setName(String nom){
	      control("VFN",nom);
	      modelPointeuse.setName(nom);
	    }
	     
	    //Définit le nombre
	    public void setSurname(String prenom){
	      control("VFS",prenom);
	      modelPointeuse.setSurname(prenom);
	    }
	    
	     
	    //Méthode de contrôle
	    abstract void control(String name,String prenom);
	
}
