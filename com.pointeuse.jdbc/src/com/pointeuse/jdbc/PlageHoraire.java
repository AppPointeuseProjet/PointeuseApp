/**
 * 
 */
package com.pointeuse.jdbc;

import java.sql.Date;

/**
 * @author Pepe
 *
 */
public class PlageHoraire {
	private String libelle;
	private Date heure_debut;
	private Date heure_fin;
	/**
	 * 
	 */
	public PlageHoraire() {
		super();
	}
	/**
	 * @param libelle
	 * @param heure_debut
	 * @param heure_fin
	 */
	public PlageHoraire(String libelle, Date heure_debut, Date heure_fin) {
		super();
		this.libelle = libelle;
		this.heure_debut = heure_debut;
		this.heure_fin = heure_fin;
	}
	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}
	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	/**
	 * @return the heure_debut
	 */
	public Date getHeure_debut() {
		return heure_debut;
	}
	/**
	 * @param heure_debut the heure_debut to set
	 */
	public void setHeure_debut(Date heure_debut) {
		this.heure_debut = heure_debut;
	}
	/**
	 * @return the heure_fin
	 */
	public Date getHeure_fin() {
		return heure_fin;
	}
	/**
	 * @param heure_fin the heure_fin to set
	 */
	public void setHeure_fin(Date heure_fin) {
		this.heure_fin = heure_fin;
	}

	
}
