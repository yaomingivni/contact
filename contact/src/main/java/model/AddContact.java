package model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Controller;

@Controller
public class AddContact {

	@NotNull
	@Size(min=1, max=50)
	private String nom;
	
	@NotNull
	@Size(min=1, max=50)
	private String prenom;
	
	@NotNull
	private int numero;

	
	
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

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
}
