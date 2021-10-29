package com.example.accessingdatajpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.collect.ImmutableList;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository repository;
	
	public Customer getCustomer(long id) {
		return repository.findById(id);
	}
	public Customer add(Customer customer) {
		return repository.save(customer);
	}
	public void delete(Customer customer){
		repository.delete(customer);
	}
	public List<Customer> getAllCustomers(){
		return ImmutableList.copyOf(repository.findAll());
	}
}
