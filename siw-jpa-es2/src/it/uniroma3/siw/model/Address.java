package it.uniroma3.siw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
   @Column(nullable = false)
    private String street;
   
    @Column(nullable = false)
     private String city;
    
     private String state;
     
    @Column(nullable = false)
     private String zipcode;
    
    @Column(nullable = false)
    private String country;

}