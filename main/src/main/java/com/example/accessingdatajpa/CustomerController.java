package com.example.accessingdatajpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@GetMapping("/get/{id}")
	public Customer getCustomer(@PathVariable Long id) {
		return service.getCustomer(id);
	}
	
	@GetMapping("/getall")
	public List<Customer> getAllCustomers(){
		return service.getAllCustomers();
	}
	
	@PostMapping(value="/addCustomer", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Customer addCustomer(@RequestBody Customer form) {
		return service.add(form);
	}
}
