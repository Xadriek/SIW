
package it.uniroma3.siw.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

	private static final Logger logger=LogManager.getLogger();
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable=false)
	private String email;

	private String phoneNumber;

	private LocalDate dateOfBirth;

	private LocalDate registrationDate;

	@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
	private Address address;



	@OneToMany(mappedBy="customer",cascade= {CascadeType.PERSIST,CascadeType.REMOVE})
	@OrderBy("creationTime asc")
	private List<Order> payedOrders;

	public Customer() {
		
		logger.trace("This is a Trace message");
        logger.debug("This is a Debug message");
        logger.info("This is an Info message");
        logger.warn("This is a Warn message");
        logger.error("This is an Error message");
        logger.fatal("This is a Fatal message");
        
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

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", dateOfBirth=" + dateOfBirth + ", registrationDate="
				+ registrationDate + ", address=" + address + ", payedOrders=" + payedOrders + "]";
	}
	


	


}
