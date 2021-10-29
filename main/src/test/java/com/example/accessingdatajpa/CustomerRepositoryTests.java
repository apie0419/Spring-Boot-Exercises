package com.example.accessingdatajpa;

import java.util.List;

import com.example.accessingdatajpa.customer.Customer;
import com.example.accessingdatajpa.customer.CustomerRepository;
import com.google.common.collect.ImmutableList;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerRepositoryTests {
    
    @Autowired
    CustomerRepository repository;

    private long customerId = 1;
    private String customerFirstName = "Alan";
    private String customerLastName = "Li";


    @Test
    @Order(1)
    @Rollback(value=false)
    public void saveCustomerTest(){
        Customer customer = new Customer(customerFirstName, customerLastName);
        Customer c = repository.save(customer);
        Assertions.assertThat(c.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getCustomerByIdTest(){
        System.out.println("ID2:" + customerId);
        Customer customer = repository.findById(customerId);
        
        Assertions.assertThat(customer.getLastName()).isEqualTo(customerLastName);
        Assertions.assertThat(customer.getFirstName()).isEqualTo(customerFirstName);
        Assertions.assertThat(customer.getId()).isEqualTo(customerId);
    }

    @Test
    @Order(3)
    public void getListOfCustomerTest(){
        List<Customer> customers = ImmutableList.copyOf(repository.findAll());
        
        Assertions.assertThat(customers.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value=false)
    public void updateCustomerTest(){
        String newFirstName = "Billy";
        String newLastName = "Chuang";
        Customer customer = repository.findById(customerId);
        customer.setFirstName(newFirstName);
        customer.getLastName(newLastName);
        Customer updatedCustomer = repository.save(customer);
        
        Assertions.assertThat(updatedCustomer.getFirstName()).isEqualTo(newFirstName);
        Assertions.assertThat(updatedCustomer.getLastName()).isEqualTo(newLastName);
    }
    @Test
    @Order(5)
    @Rollback(value=false)
    public void deleteCustomerTest(){
        Customer customer = repository.findById(customerId);
        repository.delete(customer);
        Customer deleted = repository.findById(customerId);
        
        Assertions.assertThat(deleted).isNull();
    }

}
