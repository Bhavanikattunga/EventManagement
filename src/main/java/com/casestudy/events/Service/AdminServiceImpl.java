package com.casestudy.events.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.casestudy.events.Entity.Admin;
import com.casestudy.events.Repository.AdminRepository;

@Service
public class AdminServiceImpl {
	@Autowired
	AdminRepository adminRepository;
	public boolean LoginToSite(Admin admin) {
		List<Admin> reg=new ArrayList<Admin>(); 
		reg.addAll(adminRepository.findByName(admin.getAdminName()));
	        if(reg.isEmpty()){
	            System.out.println("No user found");
	            return false;
	        }
	        else{
	            if((reg.get(0).getPassword()).equals(admin.getPassword())){
	                return true;
	            }
	            else return false;
	        }
	    }

}
