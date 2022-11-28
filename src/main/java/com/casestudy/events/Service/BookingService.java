package com.casestudy.events.Service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.casestudy.events.Entity.Booking;
import com.casestudy.events.Exceptions.BookingNotFoundException;
@Service
public interface BookingService {
   public List<Booking> findAll();
   public Booking getBookingById(int bookingId) throws BookingNotFoundException;
    public boolean deleteBooking(int bookingId);
   public boolean updateById(int bookingId, Booking booking);
   public Booking createBooking(Booking booking);
}