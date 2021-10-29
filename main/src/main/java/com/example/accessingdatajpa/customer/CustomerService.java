package com.example.accessingdatajpa.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.accessingdatajpa.config.CaffeineCacheConfig;
import com.google.common.collect.ImmutableList;

@CacheConfig(cacheNames = "customer", cacheManager = CaffeineCacheConfig.CAFFEINE_CACHE_MANAGER)
@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository repository;
	
	@Cacheable(key = "#id", condition = "#id != null", unless = "#result == null")
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
