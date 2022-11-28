package com.casestudy.events.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.casestudy.events.Entity.Admin;
import com.casestudy.events.Entity.Event;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{
	@Query(nativeQuery=true,
			value="select * from Admin a where a.admin_name=:adminName")
	public List<Admin> findByName(String adminName);
}
