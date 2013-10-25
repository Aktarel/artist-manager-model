package modele;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Utilisateur {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idU;

	private String ipAdresse;
	
	private Date dateDerniereConnection;
	
	@ManyToMany(fetch=FetchType.EAGER)
	private List<Artiste> artistesFavoris;

	public int getIdU() {
		return idU;
	}

	public void setIdU(int idU) {
		this.idU = idU;
	}

	public String getIpAdresse() {
		return ipAdresse;
	}

	public void setIpAdresse(String ipAdresse) {
		this.ipAdresse = ipAdresse;
	}

	public Date getDateDerniereConnection() {
		return dateDerniereConnection;
	}

	public void setDateDerniereConnection(Date dateDerniereConnection) {
		this.dateDerniereConnection = dateDerniereConnection;
	}

	public Utilisateur(int idU, String ipAdresse, Date dateDerniereConnection,
			List<Artiste> artistes) {
		super();
		this.idU = idU;
		this.ipAdresse = ipAdresse;
		this.dateDerniereConnection = dateDerniereConnection;
		this.artistesFavoris = artistes;
	}
	
	
	public Utilisateur() {
		// TODO Auto-generated constructor stub
	}

	public List<Artiste> getArtistesFavoris() {
		return artistesFavoris;
	}

	public void setArtistesFavoris(List<Artiste> artistesFavoris) {
		this.artistesFavoris = artistesFavoris;
	}

	public Utilisateur(String ipAdresse, Date dateDerniereConnection) {
		super();
		this.ipAdresse = ipAdresse;
		this.dateDerniereConnection = dateDerniereConnection;
	}
	
	
	
}
