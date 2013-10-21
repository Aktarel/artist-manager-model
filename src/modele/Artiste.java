package modele;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentSkipListSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Sort;
import org.hibernate.annotations.SortType;

@Entity
public class Artiste{
	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idA;

	@Column(unique = true, nullable = false)
	private String nom;

	@Column(length = 500)
	private String description;

	@OneToMany(mappedBy = "artiste", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@Sort(type = SortType.NATURAL) 
	private SortedSet<Piste> listePiste = new ConcurrentSkipListSet<Piste>();

	@OneToMany(mappedBy = "artiste", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<Image> listeImage = new HashSet<Image>();
	
	@OneToMany(mappedBy="artiste",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<Similaire> listeSimilaire = new HashSet<Similaire>();


	public Artiste(String nom, String description2) {
		this.setNom(nom);
		this.setDescription(description2);

	}

	public Artiste() {
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String toString() {

		StringBuffer sb = new StringBuffer();
		for (Piste unePiste : listePiste)
			sb.append(unePiste.getNom() + "\n");

		StringBuffer sb2 = new StringBuffer();
		for (modele.Image uneImage : listeImage)
			sb2.append(uneImage.getUrl() + "\n");

		return "Artiste -> mon id est " + idA + " et mon nom est " + nom
				+ " et mes photos sont a cette adresse: " + sb2.toString()
				+ " \n " + "mes buzz : " + sb.toString() + " \n";

	}

	public Set<Image> getListeImage() {
		return listeImage;
	}

	public void setListeImage(Set<Image> listeImage) {
		this.listeImage = listeImage;
	}

	public SortedSet<Piste> getListePiste() {
		return listePiste;
	}

	public void setListePiste(SortedSet<Piste> listePiste) {
		this.listePiste = listePiste;
	}

	public void addImage(Image uneImage) {

		uneImage.setArtiste(this);
		listeImage.add(uneImage);
	}

	public void addPiste(Piste unePiste) {
		unePiste.setArtiste(this);
		listePiste.add(unePiste);
	}

	public int getIdA() {
		return idA;
	}

	public void setIdA(int idA) {
		this.idA = idA;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void addSimilaire(Similaire similaire) {
		this.listeSimilaire.add(similaire);
	}
	public Set<Similaire> getListeSimilaire() {
		return listeSimilaire;
	}

	public void setListeSimilaire(Set<Similaire> listeSimilaire) {
		this.listeSimilaire = listeSimilaire;
	}
}
