package com.casestudy.events.Entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerid;
	@NotNull
	private String customeremailid;
	@NotNull
	private String customerpassword;
	@NotNull
	private String customerusername;
	@NotNull
	private long customermobileno;
	
	@JsonIgnore
    @OneToMany(mappedBy = "customer")
    private Set<Booking> bookings;

	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "eventId", referencedColumnName = "eventId")
    private Event event;


	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getCustomerid() {
		return customerid;
	}


	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}


	public String getCustomeremailid() {
		return customeremailid;
	}


	public void setCustomeremailid(String customeremailid) {
		this.customeremailid = customeremailid;
	}


	public String getCustomerpassword() {
		return customerpassword;
	}


	public void setCustomerpassword(String customerpassword) {
		this.customerpassword = customerpassword;
	}


	public String getCustomerusername() {
		return customerusername;
	}


	public void setCustomerusername(String customerusername) {
		this.customerusername = customerusername;
	}


	public long getCustomermobileno() {
		return customermobileno;
	}


	public void setCustomermobileno(long customermobileno) {
		this.customermobileno = customermobileno;
	}


	public Set<Booking> getBookings() {
		return bookings;
	}


	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}


	public Event getEvent() {
		return event;
	}


	public void setEvent(Event event) {
		this.event = event;
	}
	
	
	

}
