package com.casestudy.events.Service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.casestudy.events.Entity.Event;
import com.casestudy.events.Entity.Payment;
import com.casestudy.events.Exceptions.EventNotFoundException;
import com.casestudy.events.Exceptions.PaymentException;
import com.casestudy.events.Repository.IEventRepository;


@Service
public class EventServiceImpl implements IEventService{
	
	@Autowired
	IEventRepository eventRepository;
	
	public List<Event> getAllEvents(){
		List<Event>allEvents=eventRepository.findAll();
		return allEvents ;
	}

	
	@Override
	public Event addEvents(Event event) {
		// TODO Auto-generated method stub
		return eventRepository.save(event);
	}

	@Override
	public boolean cancelEvent(int eventId) {
		// TODO Auto-generated method stub
		eventRepository.deleteById(eventId);
		return true;
	}

	@Override
	
	public boolean updateEvent(int id, Event event) {
        Event e = new Event();
        e.setEventId(event.getEventId());
        e.setEventName(event.getEventName());
        e.setEventCost(event.getEventCost());
        e.setCapacity(event.getCapacity());
        e.setFood(event.isFood());
        eventRepository.save(e);
        return true;
	}

	public Event getEventById(int eventId) throws EventNotFoundException {
        // TODO Auto-generated method stub
        Optional<Event> event=eventRepository.findById(eventId);
        if(event.isPresent())
            return event.get();
            else
                throw new EventNotFoundException("No details found with the given id");
    }
	
	
}
