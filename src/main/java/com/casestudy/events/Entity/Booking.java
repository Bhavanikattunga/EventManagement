package com.casestudy.events.Entity;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;//Java Persistence is the API for the management for persistence and object/relational mapping.
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookingId;
    @NotNull(message = "Date shouldn't be null  ")
    private Date date;
    @NotNull(message = "Status  shouldn't be null ")
    private String status;
    @NotNull(message = "Bill shouldn't be null ")
    private long bill;
    private long noOfAttendies;
    
    
    @JsonIgnore
    @ManyToMany(mappedBy = "bookings")
	public Set<Event> events = new HashSet<>();
    
    @JsonIgnore
    @OneToMany(mappedBy = "bookings")
    private Set<Payment> payments;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    private Customer customer;

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Booking(int bookingId, @NotNull(message = "Date shouldn't be null  ") Date date,
			@NotNull(message = "Status  shouldn't be null ") String status,
			@NotNull(message = "Bill shouldn't be null ") long bill, long noOfAttendies) {
		super();
		this.bookingId = bookingId;
		this.date = date;
		this.status = status;
		this.bill = bill;
		this.noOfAttendies = noOfAttendies;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getBill() {
		return bill;
	}

	public void setBill(long bill) {
		this.bill = bill;
	}

	public long getNoOfAttendies() {
		return noOfAttendies;
	}

	public void setNoOfAttendies(long noOfAttendies) {
		this.noOfAttendies = noOfAttendies;
	}

	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}

	public Set<Payment> getPayments() {
		return payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
    
    
    
    
  
}