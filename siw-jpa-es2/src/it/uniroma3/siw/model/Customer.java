
package it.uniroma3.siw.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Customer {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

@Column(nullable = false)
private String firstName;

@Column(nullable = false)
private String lastName;

private String email;
private String phoneNumber;

private LocalDate dateOfBirth;

private LocalDate registrationDate;

@OneToOne
private Address address;

}
