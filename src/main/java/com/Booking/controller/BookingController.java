package com.Booking.controller;

import com.Booking.entity.Booking;
import com.Booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @PostMapping("/addbook")
    public Booking addBooking(@RequestBody Booking booking){
        return bookingService.addBookings(booking);
    }

    @GetMapping("/getbooks")
    public List<Booking> readBooking (){
        return bookingService.getAllBookings();
    }

    @GetMapping("/getbook/{id}")
    public Booking findBooking (@PathVariable ("id") long id){
        return bookingService.getBookingById(id);
    }

    @DeleteMapping("/deleteBooking/{id}")
    public String deleteBooking (@PathVariable ("id") long id){
        return bookingService.deleteBooking(id);
    }

    @PutMapping("/updateBooking/{id}")
    public Booking updateBooking (@PathVariable("id") long id, @RequestBody Booking booking){
        return bookingService.updateBooking(id, booking);
    }


}
