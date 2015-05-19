/**
 * 
 */
package com.pointeuse.jdbc;



/**
 * @author Pepe
 *
 */
public class Employee {
    private int id;
//    private String category; // manager,directeur,ouvrier,technicien
	private String name;
	private String prenom;
	
	
	/**
	 * 
	 */
	public Employee() {
		super();
	}
	/**
	 * @param id
	 * @param name
	 * @param prenom
	 */
	public Employee(int id, String name, String prenom) {
		super();
		this.id = id;
		this.name = name;
		this.prenom = prenom;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", prenom=" + prenom
				+ "]";
	}
	
	
}
