package modele;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Piste  implements Serializable,Comparable<Piste>  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idP;
	private String nom;
	private int classement;
	private BigInteger nbListeners;
	private BigInteger idDeezer;
	private String urlPreview;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Artiste artiste;
	
	public Piste() {
	}

	
	
	public Piste(int idP, String nom, int classement) {
		super();
		this.idP = idP;
		this.nom = nom;
		this.classement = classement;
	}



	public int getIdP() {
		return idP;
	}


	public void setIdP(int idP) {
		this.idP = idP;
	}

	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getClassement() {
		return classement;
	}


	public void setClassement(int classement) {
		this.classement = classement;
	}



	public Artiste getArtiste() {
		return artiste;
	}



	public void setArtiste(Artiste artiste) {
		this.artiste = artiste;
	}



	public BigInteger getNbListeners() {
		return nbListeners;
	}



	public void setNbListeners(BigInteger nbListeners) {
		this.nbListeners = nbListeners;
	}

	public int compareTo(Piste o) {
		if(o.classement<this.classement)
			return 1;
		else{
			return 0;
		}
	}



	public BigInteger getIdDeezer() {
		return idDeezer;
	}



	public void setIdDeezer(BigInteger bigInteger) {
		this.idDeezer = bigInteger;
	}



	public String getUrlPreview() {
		return urlPreview;
	}



	public void setUrlPreview(String urlPreview) {
		this.urlPreview = urlPreview;
	}
}
