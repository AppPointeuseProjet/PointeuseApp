/**
 * 
 */
package com.pointeuse.jdbc;

/**
 * @author Pepe
 *
 */
public class DroitAcces {
	private Porte porte;
	private Carte carte;
	private int codeAcces;

	/**
	 * 
	 */
	public DroitAcces() {
		super();
	}

	/**
	 * @param porte
	 * @param carte
	 * @param codeAcces
	 */
	public DroitAcces(Porte porte, Carte carte, int codeAcces) {
		super();
		this.porte = porte;
		this.carte = carte;
		this.codeAcces = codeAcces;
	}

	/**
	 * @return the porte
	 */
	public Porte getPorte() {
		return porte;
	}

	/**
	 * @param porte the porte to set
	 */
	public void setPorte(Porte porte) {
		this.porte = porte;
	}

	/**
	 * @return the carte
	 */
	public Carte getCarte() {
		return carte;
	}

	/**
	 * @param carte the carte to set
	 */
	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	/**
	 * @return the codeAcces
	 */
	public int getCodeAcces() {
		return codeAcces;
	}

	/**
	 * @param codeAcces the codeAcces to set
	 */
	public void setCodeAcces(int codeAcces) {
		this.codeAcces = codeAcces;
	}
	
}
