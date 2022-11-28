package com.casestudy.events.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.events.Entity.Customer;
@Repository
public interface CustomerRegistrationRepository extends JpaRepository<Customer, Integer>{
	
	public Customer findByCustomeremailid(String customeremailid);
	public Customer findByCustomeremailidAndCustomerpassword(String customeremailid,String customerpassword);
	
	
}
