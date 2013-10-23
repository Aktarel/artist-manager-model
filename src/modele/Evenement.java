package modele;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Evenement implements Serializable, Comparable<Evenement> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idEv;

	public int getIdEv() {
		return idEv;
	}

	public void setIdEv(int idEv) {
		this.idEv = idEv;
	}

	private String nom;

	private String url;

	private String date;

	private String lat;

	private String longitude;
	
	@Embedded
	private Adresse adresse;
	
	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@ManyToOne( fetch = FetchType.EAGER)
	private Artiste artiste;

	public Evenement() {
		// TODO Auto-generated constructor stub
	}
	
	public Evenement(String nom, String url, String date, String lat,
			String longitude) {
		super();
		this.nom = nom;
		this.url = url;
		this.date = date;
		this.lat = lat;
		this.longitude = longitude;
	}

	public Evenement(String nom, String url, String date, String lat,
			String longitude,Adresse adr) {
		super();
		this.nom = nom;
		this.url = url;
		this.date = date;
		this.lat = lat;
		this.longitude = longitude;
		this.adresse = adr;
	}
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public int compareTo(Evenement o) {
		
//		if (this.date.after(o.getDate()))
//			return 0;
//		else
//			return 1;
		return -1;
	}

	public Artiste getArtiste() {
		return artiste;
	}

	public void setArtiste(Artiste artiste) {
		this.artiste = artiste;
	}

}
