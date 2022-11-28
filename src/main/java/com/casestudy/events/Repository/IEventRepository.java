package com.casestudy.events.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.casestudy.events.Entity.Admin;
import com.casestudy.events.Entity.Event;
@Repository
public interface IEventRepository extends JpaRepository<Event, Integer>{
	@Query(nativeQuery=true,value="select * from Event e where e.event_id=:eventId")
	public Event getById(int eventId);
}
