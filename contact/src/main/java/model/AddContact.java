package model;

import javax.validation.constraints.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class AddContact {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@NotNull
	private String nom;
	
	@NotNull
	private String prenom;
	
	@NotNull
	private String numero;
	
	

	protected AddContact() {
		this.setNom("");
		this.setNumero("");
		this.setPrenom("");
	}

	
	public AddContact(String nom, String prenom, String numero) {
		this.setNom(nom);
		this.setNumero(numero);
		this.setPrenom(prenom);
	}
	
	 @Override
	    public String toString() {
	        return String.format(
	                "Contact[id=%d, nom='%s', prenom='%s']",
	                id, nom, prenom);
	    }
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
}
