package com.Booking.service;

import com.Booking.entity.Booking;
import com.Booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepo;

    public Booking addBookings (Booking booking){
        return bookingRepo.save(booking);
    }

    public List<Booking> getAllBookings() {
        List<Booking> all = bookingRepo.findAll();
        return all;
    }

    public Booking getBookingById(long id) {
        Booking booking = bookingRepo.findById(id).orElseThrow(() -> new RuntimeException("ID not found" + id));
            return booking;
    }

    public String deleteBooking(long id) {
        Booking booking = bookingRepo.findById(id).orElseThrow(() -> new RuntimeException("id not found" + id));
        bookingRepo.deleteById(booking.getId());
        return "Bookings deleted with id "+booking.getId();
    }

    public Booking updateBooking(long id, Booking booking) {
        Booking booking1 = bookingRepo.findById(id).orElseThrow(() -> new RuntimeException("Id not found " + id));

        booking1.setName(booking.getName());
        booking1.setSurname(booking.getSurname());
        booking1.setCity(booking.getCity());
        booking1.setEmail(booking.getEmail());
        booking1.setMob_no(booking.getMob_no());
        Booking save = bookingRepo.save(booking1);
        return save;
    }
}
