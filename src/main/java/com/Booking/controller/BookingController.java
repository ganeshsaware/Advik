package com.Booking.controller;

import com.Booking.entity.Booking;
import com.Booking.payload.BookingDto;
import com.Booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @PostMapping("/addbook")
    public ResponseEntity<BookingDto>  addBooking(@RequestBody BookingDto booking){
        BookingDto bookingDto = bookingService.addBookings(booking);
        return new ResponseEntity<>(bookingDto, HttpStatus.CREATED);
    }

    @GetMapping("/getbooks")
    public ResponseEntity<List<BookingDto>> readBooking (){
        List<BookingDto> allBookings = bookingService.getAllBookings();
        return new ResponseEntity<>(allBookings, HttpStatus.OK);
    }

    @GetMapping("/getbook/{id}")
    public ResponseEntity<BookingDto> findBooking (@PathVariable ("id") long id){
        BookingDto bookingById = bookingService.getBookingById(id);
        return new ResponseEntity<>(bookingById, HttpStatus.FOUND);
    }

    @DeleteMapping("/deleteBooking/{id}")
    public ResponseEntity<String> deleteBooking (@PathVariable ("id") long id){
        String s = bookingService.deleteBooking(id);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @PutMapping("/updateBooking/{id}")
    public ResponseEntity<BookingDto> updateBooking (@PathVariable("id") long id, @RequestBody BookingDto booking){
        BookingDto bookingDto = bookingService.updateBooking(id, booking);
        return new ResponseEntity<>(bookingDto, HttpStatus.OK);
    }


}
