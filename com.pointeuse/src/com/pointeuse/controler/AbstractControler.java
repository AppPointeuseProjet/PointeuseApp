package com.pointeuse.controler;

import com.pointeuse.model.AbstractModel;

public abstract class AbstractControler {
    
	protected AbstractModel modelPointeuse;
	
	public AbstractControler(AbstractModel pointe){
	    this.modelPointeuse = pointe;
	}
	    //D�finit l'op�rateur
	    public void setName(String nom){
	      control("VFN",nom);
	      modelPointeuse.setName(nom);
	    }
	     
	    //D�finit le nombre
	    public void setSurname(String prenom){
	      control("VFS",prenom);
	      modelPointeuse.setSurname(prenom);
	    }
	    
	     
	    //M�thode de contr�le
	    abstract void control(String name,String prenom);
	
}
