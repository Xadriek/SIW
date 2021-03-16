package it.uniroma3.db.products;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import it.uniroma3.siw.model.OrderLine;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String name;
	
	private String description;
	
	@ManyToMany(mappedBy = "products")
	private List<Provider> providers;
	
	@OneToMany(mappedBy= "products")
	private List<OrderLine> orderLines;

	public Product() {
		this.providers=new ArrayList<Provider>();
		this.orderLines=new ArrayList<OrderLine>();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Provider> getProviders() {
		return providers;
	}

	public void setProviders(List<Provider> providers) {
		this.providers = providers;
	}
	
}
