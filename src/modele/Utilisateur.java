package modele;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * Un utilisateur en mode non connecte, il est identifie par son ip donc plutot
 * un guest
 * 
 * @author nicolas
 * 
 */
@Entity
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idU;

	private String ipAdresse;

	private Date dateDerniereConnection;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "FANS", joinColumns = @JoinColumn(name = "ID_USER", referencedColumnName = "IDU"), inverseJoinColumns = @JoinColumn(name = "ID_ARTISTE", referencedColumnName = "IDA",unique=true))
	private Set<Artiste> favoris = new HashSet<Artiste>();

	public Set<Artiste> getFavoris() {
		return favoris;
	}

	public void setFavoris(Set<Artiste> favoris) {
		this.favoris = favoris;
	}

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
	}

	public Utilisateur(String ipAdresse, Date dateDerniereConnection) {
		super();
		this.ipAdresse = ipAdresse;
		this.dateDerniereConnection = dateDerniereConnection;
	}
	
	public Utilisateur(int idU, String ipAdresse, Date dateDerniereConnection,
			Set<Artiste> favoris) {
		super();
		this.idU = idU;
		this.ipAdresse = ipAdresse;
		this.dateDerniereConnection = dateDerniereConnection;
		this.favoris = favoris;
	}

	public void addFavoris(Artiste a){
		favoris.add(a);
	}
	
	
}
