package com.pointeuse.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.pointeuse.controler.AbstractControler;
import com.pointeuse.controler.PointeuseControler;
import com.pointeuse.model.AbstractModel;
import com.pointeuse.model.Pointeuse;
import com.pointeuse.observer.Observeur;

public class PointeuseVue extends JFrame implements Observeur{
	
	  private JLabel lblNom  = new JLabel("NOM");
	  private JLabel lblPrenom  = new JLabel("PRENOM");
	  private JTextField txtNom  = new JTextField();
	  private JTextField txtPrenom = new JTextField();
	  private JButton btnNew =new JButton("New");
	  private JButton btnSave = new JButton("Save");
	  private JButton btnQuitter = new JButton("Exit");
      private JPanel pnlNord = new JPanel();
      private JPanel pnlSud = new JPanel();
      
      
      
	  private AbstractControler controler;
	  private AbstractModel model = new Pointeuse();
	  
	  public PointeuseVue(){
		  model.addObserveur(this);
		  controler = new PointeuseControler(model);
	  }
	  
	  public PointeuseVue(AbstractControler controler){                
	    this.controler=controler;
	  }
	  public void buildPnl (){
		  //Construction de la grille 
		  pnlNord.setLayout(new GridLayout(2, 2));
		 
		  //Ajout des label et zone de texte dans la zone Nord
		  pnlNord.add(lblNom);
		  pnlNord.add(txtNom);
		  pnlNord.add(lblPrenom);
		  pnlNord.add(txtPrenom);
		  
		  //Positionner les bouttons
		  pnlSud.setLayout(new FlowLayout());
		  
		  //Attribuer les dimensions aux bouttons
		  btnNew.setSize( 100,100);
		  btnSave.setSize( 100,100);
		  btnQuitter.setSize( 100,100);
		  
		  //listener des boutons
		  btnNew.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				//Le controleur recupère et set/notifie le model de la donnée nom qui a été entré
				String nom = JOptionPane.showInputDialog(btnNew, "Non:");
				
				
				controler.setName(nom);
				
				//JOptionPane.showMessageDialog(btnNew,txtNom.getText());
				
			}
		});
		  
		  btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Le controleur notifie le model de la donnée prenom qui a été entré
				controler.setSurname("toto");
				//JOptionPane.showMessageDialog(btnSave, txtPrenom.getText());	
			}
		});
		  
		  btnQuitter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnSave, "quitté");
				
			}
		});
		  //Ajout des bouttons dans la zone Sud
		  pnlSud.add(btnNew);
		  pnlSud.add(btnSave);
		  pnlSud.add(btnQuitter);
		  
		  this.add(pnlNord,BorderLayout.CENTER);
		  this.add(pnlSud,BorderLayout.SOUTH);
		  setSize(400,300); 
		  setVisible(true);
	  }
	@Override
	public void onMdodelChange( String name, String surname,boolean granted) {
		
		txtNom.setText(name);
		txtPrenom.setText(surname);
		
		if(granted){
			
			txtNom.setBackground(Color.GREEN);
			txtPrenom.setBackground(Color.GREEN);
			
		} else {
			
			txtNom.setBackground(Color.RED);
			txtPrenom.setBackground(Color.RED);
		}
		
	}
	
	public static void main(String [] args) {
		
		new PointeuseVue().buildPnl();
	}
} 
	
