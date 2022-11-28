package com.casestudy.events.Entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int eventId;
	@NotNull(message = "Name shouldn't be null  ")
	private String eventName;
	@NotNull(message = "Cost shouldn't be null  ")
	private double eventCost;
	@NotNull(message = "Capacity shouldn't be null  ")
	private long Capacity;
	private boolean food;
	
	@JsonIgnore
    @OneToMany(mappedBy = "event")
    private Set<Customer> customer;

	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Booked_Events",
                joinColumns=@JoinColumn(name="Events"),
                inverseJoinColumns=@JoinColumn(name="Bookings"))
	public Set<Booking> bookings = new HashSet<>();


	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Event(int eventId, @NotNull(message = "Name shouldn't be null  ") String eventName,
			@NotNull(message = "Cost shouldn't be null  ") double eventCost,
			@NotNull(message = "Capacity shouldn't be null  ") long capacity, boolean food ) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.eventCost = eventCost;
		Capacity = capacity;
		this.food = food;
		
	}


	public int getEventId() {
		return eventId;
	}


	public void setEventId(int eventId) {
		this.eventId = eventId;
	}


	public String getEventName() {
		return eventName;
	}


	public void setEventName(String eventName) {
		this.eventName = eventName;
	}


	public double getEventCost() {
		return eventCost;
	}


	public void setEventCost(double eventCost) {
		this.eventCost = eventCost;
	}


	public long getCapacity() {
		return Capacity;
	}


	public void setCapacity(long capacity) {
		Capacity = capacity;
	}


	public boolean isFood() {
		return food;
	}


	public void setFood(boolean food) {
		this.food = food;
	}


	public Set<Customer> getCustomers() {
		return customer;
	}


	public void setCustomers(Set<Customer> customer) {
		this.customer = customer;
	}


	public Set<Booking> getBookings() {
		return bookings;
	}


	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}
	
}
