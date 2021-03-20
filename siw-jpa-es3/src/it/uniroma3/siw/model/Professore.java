package it.uniroma3.siw.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Professore {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;



	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String cognome;
	@OneToMany(mappedBy="titolare")
	private List<Corso> corsi;
	@ManyToMany(mappedBy="commissione")
	private List<Corso> membroDiCommissione;

	public Professore(){
		corsi=new ArrayList<Corso>();
		membroDiCommissione=new ArrayList<Corso>();



	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public List<Corso> getCorsi() {
		return corsi;
	}

	public void setCorsi(List<Corso> corsi) {
		this.corsi = corsi;
	}

	public List<Corso> getMembroDiCommissione() {
		return membroDiCommissione;
	}

	public void setMembroDiCommissione(List<Corso> membroDiCommissione) {
		this.membroDiCommissione = membroDiCommissione;
	}
}
