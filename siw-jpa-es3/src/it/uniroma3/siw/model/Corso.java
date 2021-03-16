package it.uniroma3.siw.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Corso {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)

	@Column(nullable=false)
	private String denominazione;
	@ManyToOne
	private Professore titolare;
	@ManyToMany
	private List<Professore> commissione;

	public Corso() {
		commissione=new ArrayList<Professore>();
	}
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDenominazione() {
		return denominazione;
	}
	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}
	public Professore getTitolare() {
		return titolare;
	}
	public void setTitolare(Professore titolare) {
		this.titolare = titolare;
	}
	public List<Professore> getCommissione() {
		return commissione;
	}
	public void setCommissione(List<Professore> commissione) {
		this.commissione = commissione;
	}
}
