package com.example.accessingdatajpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@WebMvcTest(controllers=CustomerController.class)
public class CustomerControllerTests {

    private String customerFirstName = "Alan";
    private String customerLastName = "Li";

    @Autowired
	private MockMvc mockMvc;

    @Autowired
    private CustomerService service;

    @Test
    public void addCustomerTest() throws Exception{
        Customer addCustomer = new Customer(customerFirstName, customerLastName);
        when(service.add(eq(addCustomer))).thenReturn(addCustomer);
        this.mockMvc.perform(post("/addCustomer")
            .contentType("application/json")
            .content(addCustomer.toString()))
            .andExpect(status().isOk());
            
    }
}
