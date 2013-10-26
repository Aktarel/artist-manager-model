package modele;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Objet representant une image
 * @deprecated : les catalogues de photos ne sont plus accessible depuis le 22/10/2013
 * @author nicolas
 *
 */
@Entity
public class Image implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idI;

	@Column(nullable = false)
	private String url;

	@Column(name = "date_ajout")
	private String dateAjoute;

	@ManyToOne(fetch = FetchType.EAGER)
	private Artiste artiste;

	public Image(String url) {
		super();
		this.url = url;
	}

	public Image() {
		// TODO Auto-generated constructor stub
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Artiste getArtiste() {
		return artiste;
	}

	public void setArtiste(Artiste artiste) {
		this.artiste = artiste;
	}

	public String getDateAjoute() {
		return dateAjoute;
	}

	public void setDateAjoute(String dateAjoute) {
		this.dateAjoute = dateAjoute;
	}

	public int getIdI() {
		return idI;
	}

	public void setIdI(int idI) {
		this.idI = idI;
	}


}
