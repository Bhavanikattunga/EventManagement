package com.casestudy.events.Exceptions;

@SuppressWarnings("serial")
public class BookingNotFoundException extends RuntimeException {
	
	 public BookingNotFoundException(String message) {
	        super(message);
	    }

}
