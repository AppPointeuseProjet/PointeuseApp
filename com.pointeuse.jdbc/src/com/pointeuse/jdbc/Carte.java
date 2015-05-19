/**
 * 
 */
package com.pointeuse.jdbc;

import java.util.Date;

/**
 * @author Pepe
 *
 */
public class Carte {
	private String numSerie;
	private Date dateExpiration;
	private String statut;
	private Personnel personnel;
	private PlageHoraire plageHoraire;

	/**
	 * 
	 */
	public Carte() {
		super();
	}

	/**
	 * @param numSerie
	 * @param dateExpiration
	 * @param statut
	 * @param personnel
	 * @param plageHoraire
	 */
	public Carte(String numSerie, Date dateExpiration, String statut,
			Personnel personnel, PlageHoraire plageHoraire) {
		super();
		this.numSerie = numSerie;
		this.dateExpiration = dateExpiration;
		this.statut = statut;
		this.personnel = personnel;
		this.plageHoraire = plageHoraire;
	}

	/**
	 * @return the numSerie
	 */
	public String getNumSerie() {
		return numSerie;
	}

	/**
	 * @param numSerie the numSerie to set
	 */
	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	/**
	 * @return the dateExpiration
	 */
	public Date getDateExpiration() {
		return dateExpiration;
	}

	/**
	 * @param dateExpiration the dateExpiration to set
	 */
	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	/**
	 * @return the statut
	 */
	public String getStatut() {
		return statut;
	}

	/**
	 * @param statut the statut to set
	 */
	public void setStatut(String statut) {
		this.statut = statut;
	}

	/**
	 * @return the personnel
	 */
	public Personnel getPersonnel() {
		return personnel;
	}

	/**
	 * @param personnel the personnel to set
	 */
	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}

	/**
	 * @return the plageHoraire
	 */
	public PlageHoraire getPlageHoraire() {
		return plageHoraire;
	}

	/**
	 * @param plageHoraire the plageHoraire to set
	 */
	public void setPlageHoraire(PlageHoraire plageHoraire) {
		this.plageHoraire = plageHoraire;
	}

}
