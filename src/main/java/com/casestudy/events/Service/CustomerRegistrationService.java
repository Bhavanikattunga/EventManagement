package com.casestudy.events.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.events.Entity.Customer;
import com.casestudy.events.Repository.CustomerRegistrationRepository;

@Service
public class CustomerRegistrationService {
	
	
	@Autowired
	private CustomerRegistrationRepository repo;
	public Customer saveCustomer(Customer customer) {
		
		return repo.save(customer);
		
	}
		
	public Customer fetchCustomerByEmailId(String email) {
		return repo.findByCustomeremailid(email);
	}
	
	public Customer fetchCustomerByEmailIdAndPassword(String email,String password) {
		return repo.findByCustomeremailidAndCustomerpassword(email,password);
	}
	
	public List<Customer> getAllCustomers(){
		List<Customer> allCustomers=repo.findAll();
		return allCustomers ;
	}
}
