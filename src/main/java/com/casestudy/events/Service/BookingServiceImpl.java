package com.casestudy.events.Service;



import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.casestudy.events.Entity.Booking;
import com.casestudy.events.Exceptions.BookingNotFoundException;
import com.casestudy.events.Repository.BookingRepository;



@Service // indicates that an annotated class is a service class.



public class BookingServiceImpl implements BookingService {



   @Autowired // marks a constructor, field, or setter method to be autowired by Spring
                // dependency injection.



   BookingRepository bookingRepository;



   @Override
    public List<Booking> findAll() {
        // TODO Auto-generated method stub



       List<Booking> list = (List<Booking>) bookingRepository.findAll();
        return list;
    }



   /*
     * @Override public List<Booking> bookingById(int bookingId) { // TODO
     * Auto-generated method stub Optional<Booking> optional =
     * bookingRepository.findById(bookingId); if(optional.isPresent()) { return
     * bookingRepository.findAll(); } else { throw new
     * BookingNotFoundException("No product found with id"); }
     *
     * }
     */



   @Override
    public boolean deleteBooking(int bookingId) {
        // TODO Auto-generated method stub
        bookingRepository.deleteById(bookingId);
        return true;



   }



   @Override
    public boolean updateById(int bookingId, Booking booking) {
        // TODO Auto-generated method stub
        Booking e = new Booking();
        e.setBookingId(booking.getBookingId());
        e.setDate(booking.getDate());
        e.setStatus(booking.getStatus());
        e.setBill(booking.getBill());
        e.setNoOfAttendies(booking.getNoOfAttendies());
        bookingRepository.save(e);
        return true;
    }



   @Override
    public Booking createBooking(Booking booking) {
        // TODO Auto-generated method stub
        return bookingRepository.save(booking);
    }



   @Override
    public Booking getBookingById(int bookingId) throws BookingNotFoundException {
        // TODO Auto-generated method stub
        Optional<Booking> booking = bookingRepository.findById(bookingId);
        if (booking.isPresent())
            return booking.get();
        else
            throw new BookingNotFoundException("No details found with the given id");
    }



}