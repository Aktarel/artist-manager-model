package modele;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse {

	private String city ;
	
	private String country;
	
	private String street;
	
	private String codePostal;
	  
	
	
	public Adresse(String city, String country, String street, String codePostal) {
		super();
		this.city = city;
		this.country = country;
		this.street = street;
		this.codePostal = codePostal;
	}

	public Adresse() {
		// TODO Auto-generated constructor stub
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	@Override
	public String toString() {
		return street+" "+city+" "+codePostal+" "+country;
	}
	
	
	 
}
