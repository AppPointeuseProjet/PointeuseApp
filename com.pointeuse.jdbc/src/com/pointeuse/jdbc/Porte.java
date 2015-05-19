/**
 * 
 */
package com.pointeuse.jdbc;

/**
 * @author Pepe
 *
 */
public class Porte {

	private String numPorte;
	private String service;
	private String batiment;
	/**
	 * 
	 */
	public Porte() {
		super();
	}
	/**
	 * @param numPorte
	 * @param service
	 * @param batiment
	 */
	public Porte(String numPorte, String service, String batiment) {
		super();
		this.numPorte = numPorte;
		this.service = service;
		this.batiment = batiment;
	}
	/**
	 * @return the numPorte
	 */
	public String getNumPorte() {
		return numPorte;
	}
	/**
	 * @param numPorte the numPorte to set
	 */
	public void setNumPorte(String numPorte) {
		this.numPorte = numPorte;
	}
	/**
	 * @return the service
	 */
	public String getService() {
		return service;
	}
	/**
	 * @param service the service to set
	 */
	public void setService(String service) {
		this.service = service;
	}
	/**
	 * @return the batiment
	 */
	public String getBatiment() {
		return batiment;
	}
	/**
	 * @param batiment the batiment to set
	 */
	public void setBatiment(String batiment) {
		this.batiment = batiment;
	}

}
