
package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@NamedQuery(name="findAllCustomers",query="SELECT c FROM Customer c")
@Table(uniqueConstraints = @UniqueConstraint(columnNames= {"firstName","lastName","email"} ))
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(unique=true,nullable=false)
	private String email;

	private String phoneNumber;

	private LocalDate dateOfBirth;

	private LocalDate registrationDate;

	@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
	private Address address;

	@OneToMany(mappedBy="payer",cascade= {CascadeType.PERSIST,CascadeType.REMOVE})
	private List<Order> payedOrders;

	@OneToMany(mappedBy="deliver",cascade= {CascadeType.PERSIST,CascadeType.REMOVE})
	@OrderBy("creationTime asc")
	private List<Order> orders;

	public Customer() {
		this.orders=new ArrayList<Order>();
		this.payedOrders=new ArrayList<Order>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Order> getPayedOrders() {
		return payedOrders;
	}

	public void setPayedOrders(List<Order> payedOrders) {
		this.payedOrders = payedOrders;
	}
	

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	


}
