package com.casestudy.events.WebController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.events.Entity.Admin;
import com.casestudy.events.Entity.Booking;
import com.casestudy.events.Service.AdminServiceImpl;
import com.casestudy.events.Service.BookingService;

@RestController
@RequestMapping("/app")
@CrossOrigin(origins = {"http://localhost:8095", "http://localhost:4200"},allowedHeaders = "*")
public class AdminController {
	@Autowired
    AdminServiceImpl adminService;
	
	@PostMapping("/Login")
	public boolean LoginToSite(@RequestBody Admin admin){
		if(adminService.LoginToSite(admin)==false) {
			return false;
		}
		else {
			return true;
		}	
	} 

}
