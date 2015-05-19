package com.pointeuse.controler;

import com.pointeuse.client.Client;
import com.pointeuse.model.AbstractModel;

public class PointeuseControler extends AbstractControler {
    private Client client;
	
    public PointeuseControler(AbstractModel pointe) {
		super(pointe);
	}
    
    
	@Override
	void control(String name,String prenom) {
	      
		try {
			
			 client = new Client("localhost",8000);
			 client.requete(name+"#"+prenom+"\n");
			
			 String status= client.getStatus();
			 if(status.equals("granted")){
			  this.modelPointeuse.setGranted(true);	
			 }else{
				 this.modelPointeuse.setGranted(false);	 
			 }
		  }catch (Exception e) {
			e.printStackTrace();
		} 
    }
}
