package it.uniroma3.siw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderLine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int quantity;
	private float price;
}