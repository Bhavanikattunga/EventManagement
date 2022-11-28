package com.casestudy.events.WebController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.events.Entity.Booking;
import com.casestudy.events.Entity.Customer;
import com.casestudy.events.Entity.Event;
import com.casestudy.events.Exceptions.EventNotFoundException;
import com.casestudy.events.Repository.CustomerRegistrationRepository;
import com.casestudy.events.Repository.IEventRepository;
import com.casestudy.events.Service.CustomerRegistrationService;

@RestController
@RequestMapping("/app")
public class CustomerRegistrationController {
	
	@Autowired
	private CustomerRegistrationService service;
	
	@Autowired 
	IEventRepository eventRepository;
	   
	@Autowired 
	CustomerRegistrationRepository customerRepository;
	
	@PostMapping("/registercustomer")
	@CrossOrigin(origins = "http://localhost:4200")
	public Customer registerCustomer(@RequestBody Customer customer) throws Exception {
		
		String tempEmailId = customer.getCustomeremailid();
		if(tempEmailId != null && !"".equals(tempEmailId))
		{
			Customer customerobj = service.fetchCustomerByEmailId(tempEmailId);
			if(customerobj != null) {
				throw new Exception("Customer With "+tempEmailId+" is already exists");
			}
		}
		Customer customerobj = null;
		customerobj = service.saveCustomer(customer);
		
		return customerobj;
	}
	
	@PostMapping("/logincustomer")
	@CrossOrigin(origins = "http://localhost:4200")
	public Customer loginCustomer(@RequestBody Customer customer) throws Exception {
		String tempEmailId = customer.getCustomeremailid();
		String tempPass = customer.getCustomerpassword();
		Customer customerobj = null;
		if(tempEmailId != null && tempPass != null) {
			customerobj = service.fetchCustomerByEmailIdAndPassword(tempEmailId,tempPass);
		}
		if(customerobj == null) {
			throw new Exception("Invalid Credentials");
		}
		return customerobj;
	}
	@GetMapping("/customers")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Customer> getAllCustomers(){
		return service.getAllCustomers();
		
	}
	
	@PutMapping("event/{customerId}/{eventId}")
    public Customer assignEventToCustomer(@PathVariable int customerId,@PathVariable int eventId) {
		Customer customer = customerRepository.findById(customerId).get();
        Event event = eventRepository.findById(customerId).get();
        customer.setEvent(event);
        return customerRepository.save(customer);
    }

}
