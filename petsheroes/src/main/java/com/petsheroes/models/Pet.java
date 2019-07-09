package com.petsheroes.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Pet implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idPet;
	
	@ManyToOne
	private User user;
	
	private String nomePet;
	private int idade;
	private String compIdade;
	private String porte;
	private String cidade;
	private String estado;
	public long getIdPet() {
		return idPet;
	}
	public void setIdPet(long idPet) {
		this.idPet = idPet;
	}
	public String getNomePet() {
		return nomePet;
	}
	public void setNomePet(String nomePet) {
		this.nomePet = nomePet;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getCompIdade() {
		return compIdade;
	}
	public void setCompIdade(String compIdade) {
		this.compIdade = compIdade;
	}
	public String getPorte() {
		return porte;
	}
	public void setPorte(String porte) {
		this.porte = porte;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}
