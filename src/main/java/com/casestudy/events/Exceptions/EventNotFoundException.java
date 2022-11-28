package com.casestudy.events.Exceptions;

import java.util.List;

import com.casestudy.events.Entity.Event;

public class EventNotFoundException extends Exception{
	
	public EventNotFoundException(String message) {
		super(message);
	}
	public static boolean checkIfListEmpty(List<Event> allEvents) {
		if(allEvents.isEmpty()) {
			return true;
		}
		return false;
	}
	public static boolean checkIfEventExist(List<Event> allEvents, int eventId) {
		// TODO Auto-generated method stub
		return false;
	}
}
