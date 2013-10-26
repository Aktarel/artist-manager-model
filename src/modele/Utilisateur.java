package modele;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Utilisateur {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idU;

	private String ipAdresse;
	
	private Date dateDerniereConnection;
	

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

	public Utilisateur(int idU, String ipAdresse, Date dateDerniereConnection) {
		super();
		this.idU = idU;
		this.ipAdresse = ipAdresse;
		this.dateDerniereConnection = dateDerniereConnection;
	}
	
	
	public Utilisateur() {
		// TODO Auto-generated constructor stub
	}


	public Utilisateur(String ipAdresse, Date dateDerniereConnection) {
		super();
		this.ipAdresse = ipAdresse;
		this.dateDerniereConnection = dateDerniereConnection;
	}
	
	
	
}
