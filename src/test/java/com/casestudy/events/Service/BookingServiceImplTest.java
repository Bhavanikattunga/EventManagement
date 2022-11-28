package com.casestudy.events.Service;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.casestudy.events.Entity.Booking;
import com.casestudy.events.Exceptions.BookingNotFoundException;
import com.casestudy.events.Repository.BookingRepository;



@ExtendWith(MockitoExtension.class)
public class BookingServiceImplTest {
    @Mock
  
    BookingRepository bookingRepository;
    
    @Mock
  
    BookingService service;
    Date date = StringToDate( "2022-11-04 05:30:00");
    private Date StringToDate(String string) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Test
    public void testcreateBooking() {
       
        Booking booking=new Booking(33,date,"Booked",60000,60);
        bookingRepository.save(booking);
        assertThat(booking.getBookingId()).isEqualTo(33);
    }
   
    @Test
    public void testGetAllBooking() throws BookingNotFoundException {    
        
        List<Booking> list = new ArrayList<Booking>();
        Booking booking = new Booking(33,date,"Booked",60000,60);
        list.add(booking);
        when(service.findAll()).thenReturn(list);
        List<Booking> bookingList = service.findAll();





      assertEquals(1, bookingList.size());
        verify(service, times(1)).findAll();
    }
    @Test
    public void testGetBoookingById() throws BookingNotFoundException {





      when(service.getBookingById(33)).thenReturn(new Booking(33,date,"Booked",60000,60));
       Booking booking = service.getBookingById(33);
        assertEquals(date, booking.getDate());





  }
    
    
//    @Test
//    public void testUpdateEvent() {
//
//        Event event = repo.findById(13).get();       
//        event.setCapacity(200);       
//        Event updatedevent = repo.save(event);  
//        assertThat(updatedevent.getEventCost()).isEqualTo(200);
//    }
    
    
    @Test
    public void testdeleteBooking() {
        bookingRepository.deleteById(47);
        assertThat(bookingRepository.existsById(47)).isFalse();
    }
    



}