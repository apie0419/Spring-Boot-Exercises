package com.example.accessingdatajpa.customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	private String firstName;
	private String lastName;

    protected Customer() {}

    public Customer(String firstName, String lastName) {
	    this.firstName = firstName;
	    this.lastName = lastName;
	}

	@Override
	public String toString() {
	    return String.format(
	      "{\"id\": %d, \"firstName\": \"%s\", \"lastName\": \"%s\"}",
	      id, firstName, lastName);
	}

    public Long getId() {
	    return id;
	}

    public String getFirstName() {
	    return firstName;
	}

    public String getLastName() {
	    return lastName;
	}

	public void setId(long id) {
		this.id = id;
	}

    public void setFirstName(String firstName) {
	    this.firstName = firstName;
	}

    public void getLastName(String lastName) {
	    this.lastName = lastName;
	}
	
}

