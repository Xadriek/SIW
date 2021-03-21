package it.uniroma3.siw.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private LocalDateTime creationTime;
	
	@OneToMany
	@JoinColumn(name="orders_id")
	private List<OrderLine> orderLines;
	
	@ManyToOne
	private Customer payer;
	
	@ManyToOne
	private Customer deliver;
	
	public Order() {
		this.orderLines=new ArrayList<OrderLine>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public Customer getPayer() {
		return payer;
	}

	public void setPayer(Customer payer) {
		this.payer = payer;
	}

	public Customer getDeliver() {
		return deliver;
	}

	public void setDeliver(Customer deliver) {
		this.deliver = deliver;
	}
	
	
}
