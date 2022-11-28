package com.casestudy.events.WebController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.events.Entity.Booking;
import com.casestudy.events.Entity.Event;
import com.casestudy.events.Exceptions.BookingNotFoundException;
import com.casestudy.events.Exceptions.EventNotFoundException;
import com.casestudy.events.Repository.BookingRepository;
import com.casestudy.events.Repository.IEventRepository;
import com.casestudy.events.Service.IEventService;


@RestController
@RequestMapping("/app")
@CrossOrigin(origins = {"http://localhost:8095", "http://localhost:4200"},allowedHeaders = "*")
public class EventController {
	@Autowired
	IEventService eventService;
	
	@Autowired
	IEventRepository eventRepository;
	
	@Autowired
	BookingRepository bookingRepository;
	
	@PostMapping("/addevent")
	public boolean addEvent(@RequestBody Event event){
		eventService.addEvents(event);
		return true;
	}
	
	@GetMapping("/events")
	public List<Event> getAllEvents() throws EventNotFoundException{
		return eventService.getAllEvents();
		
	}
	@GetMapping("/geteventbyid/{eventId}")
    public ResponseEntity<Event> getEventById(@PathVariable ("eventId") int eventId)throws EventNotFoundException{
        Event event =eventService.getEventById(eventId);
        return new ResponseEntity<Event>(event,HttpStatus.OK);
    }
	@DeleteMapping("/delete/{eventId}")
	public boolean cancelEvent(@PathVariable int eventId) {
		 return eventService.cancelEvent(eventId);
	}
	
	@PutMapping("/update/{Id}")
	public boolean updateEvent(@PathVariable int Id, @RequestBody Event event) {
		 return eventService.updateEvent(Id,event);
	}
	
	@PutMapping("event/booking/{eventId}/{bookingId}")
    public Event addBookingToEvent(@PathVariable int eventId,@PathVariable int bookingId) {
        Event event = eventRepository.findById(eventId).get();
        Booking booking = bookingRepository.findById(bookingId).get();
        event.bookings.add(booking);
        return eventRepository.save(event);
    }
	
}
