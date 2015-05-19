/**
 * 
 */
package com.pointeuse.jdbc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

/**
 * @author Pepe
 *
 */
public class DaoH2 {

	private Connection conn ;
	private String nom = "";
	private String prenom = "";
	public DaoH2 ()
	{
		try {
			Class.forName("org.h2.Driver");//instanciation du drivers

		}catch (Exception e) {
			e.printStackTrace();
		}	
	}	
	public boolean verifyExistEmployer (String name) {
		String requeteSQL = " SELECT id,name,surname FROM EMPLOYES WHERE EMPLOYES.NAME ='"+name+"' limit 1";
		System.out.println(requeteSQL);
		try {
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requeteSQL);
			while(result.next()) {
				return true ;	 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean verifyExistEmployerName (String name) {
		String requeteSQL = " SELECT id,name,surname FROM EMPLOYES WHERE EMPLOYES.NAME ='"+name+"' limit 1";
		System.out.println(requeteSQL);
		try {
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requeteSQL);
			while(result.next()) {
				return true ;	 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean verifyExistEmployerSurName (String surname) {
		String requeteSQL = " SELECT id,name,surname FROM EMPLOYES WHERE EMPLOYES.SURNAME ='"+surname+"' limit 1";
		System.out.println(requeteSQL);
		try {
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requeteSQL);
			while(result.next()) {
				return true ;	 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public List<Employee> listAll(){
		String requeteSQL = " SELECT * FROM EMPLOYES";
		List<Employee> list = new ArrayList<Employee>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requeteSQL);
			while(result.next()) {
				Employee emp = new  Employee(result.getInt("ID"),result.getString("NAME"),result.getString("SURNAME"));
				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
    public List<Personnel>  afficheListePersonnel(){
    	String requeteSQL = "SELECT * FROM PERSONNEL";
    	List<Personnel> list = new ArrayList<Personnel>();
		Statement  stmt;
		try {
			stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(requeteSQL);
			while(result.next()) {
				
				Personnel personnel = new  Personnel(result.getString("MATRICULE"),result.getString("NOM"),result.getString("PRENOM"));
				list.add(personnel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
    
	
	public void createPlageHoraire( String libelle, Date heureDebut, Date heureFin){
		String requeteSQL = " INSERT INTO PLAGE_HORAIRE (libelle,heure_debut,heure_fin) VALUES (?,?,?) ";
		System.out.println(requeteSQL);

		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(requeteSQL);
			stmt.setString(1, libelle);
			stmt.setDate(2, heureDebut);
			stmt.setDate(3, heureFin);
			stmt.executeQuery(requeteSQL);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	public void createPersonnel( String matricule,  String nom,  String prenom){
		String requeteSQL = " INSERT INTO PERSONNEL (matricule,nom,prenom) VALUES (?,?,?) ";
		System.out.println(requeteSQL);

		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(requeteSQL);
			stmt.setString(1, matricule);
			stmt.setString(2, nom);
			stmt.setString(3, prenom);
			stmt.executeQuery(requeteSQL);
		} catch (SQLException e) {

			e.printStackTrace();
		}			
	}
	public void createPorte( String numPorte,  String service,  String batiment){
		String requeteSQL = " INSERT INTO PORTE (numPorte,service,batiment) VALUES (?,?,?) ";
		System.out.println(requeteSQL);

		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(requeteSQL);
			stmt.setString(1, numPorte);
			stmt.setString(2, service);
			stmt.setString(3, batiment);
			stmt.executeQuery(requeteSQL);
		} catch (SQLException e) {

			e.printStackTrace();
		}					
	}
	public void createCarte( String numSerie,  Date dateExpiration,  String statut,String libelle, String matricule ){
		String requeteSQL = " INSERT INTO CARTE (numSerie,dateExpiration,statut,libelle,matricule) VALUES (?,?,?,?,?) ";
		System.out.println(requeteSQL);

		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(requeteSQL);
			stmt.setString(1, numSerie);
			stmt.setDate(2, dateExpiration);
			stmt.setString(3, statut);
			stmt.setString(4, libelle);
			stmt.setString(5, matricule);
			stmt.executeQuery(requeteSQL);
		} catch (SQLException e) {

			e.printStackTrace();
		}		
	}
	public void createDroitAcces( String numSerie,  String numPorte, String codeAcces){
		String requeteSQL = " INSERT INTO DROIT_ACCESS (NUMSERIE,NUMPORTE,OUVRE) VALUES (?,?,?) ";
		System.out.println(requeteSQL);

		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(requeteSQL);
			stmt.setString(1, numSerie);
			stmt.setString(2, numPorte);
			stmt.setString(3, codeAcces);
			stmt.executeQuery(requeteSQL);
		} catch (SQLException e) {

			e.printStackTrace();
		}		
	}
	

	public void connect(){
		try {
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dev/pointeuseDB1", "sa","");
			System.out.println("connected!!");  
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void disconnect(){
		try {
			if (conn!=null)conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public void loadData(){
		FileReader reader;
		try {
			reader = new FileReader("pointeuse.sql");
			BufferedReader bf = new BufferedReader(reader);
			String sql ;
			StringBuilder sb = new StringBuilder();
			while( (sql=bf.readLine())!=null )
			{
			  sb.append(sql);	
			}
		  String [] requetes = sb.toString().split(";");
		  Statement stmt =  conn.createStatement();
		  for (int i = 0; i < requetes.length; i++) {
			stmt.execute(requetes[i]);
		  }
		  bf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	 
	     
	
	}
	public static void main(String[] args) {
		System.out.println(new DaoH2().verifyExistEmployer("pap"));	
	}
}
