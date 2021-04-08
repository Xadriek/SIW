package it.uniroma3.siw.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name="findAllProducts",query="SELECT p FROM Product p")
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
	public Product(String name) {
		this.name=name;
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

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", providers=" + providers
				+ ", orderLines=" + orderLines + "]";
	}
	
}
