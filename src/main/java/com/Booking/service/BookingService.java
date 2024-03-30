package com.Booking.service;

import com.Booking.entity.Booking;
import com.Booking.exception.ResourceNotFoundException;
import com.Booking.payload.BookingDto;
import com.Booking.repository.BookingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepo;
    @Autowired
    private ModelMapper mapper;

    public BookingDto addBookings (BookingDto booking){
        Booking map = mapper.map(booking, Booking.class);
        Booking save = bookingRepo.save(map);
        BookingDto map1 = mapper.map(save, BookingDto.class);
        return map1;
    }

    public List<BookingDto> getAllBookings() {
        List<Booking> all = bookingRepo.findAll();
        List<BookingDto> list = all.stream().map(e -> mapper.map(e, BookingDto.class)).toList();
        return list;
    }

    public BookingDto getBookingById(long id) {
        Booking booking = bookingRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
        BookingDto map = mapper.map(booking, BookingDto.class);
        return map;
    }

    public String deleteBooking(long id) {
        Booking booking = bookingRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("id not found " + id));
        bookingRepo.deleteById(booking.getId());
        return "Bookings deleted with id "+booking.getId();
    }

    public BookingDto updateBooking(long id, BookingDto booking) {
        Booking booking1 = bookingRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
        booking1.setName(booking.getName());
        booking1.setSurname(booking.getSurname());
        booking1.setMob_no(booking.getMob_no());
        booking1.setEmail(booking.getEmail());
        booking1.setCity(booking.getCity());
        Booking save = bookingRepo.save(booking1);
        BookingDto map = mapper.map(save, BookingDto.class);
        return map;
    }

    public BookingDto patchBooking(long id, BookingDto booking) {

        Booking booking1 = bookingRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
       if (booking.getName() != null && !booking1.getName().equals(booking.getName())) {
           booking1.setName(booking.getName());
       }
       if (booking.getSurname() != null && !booking1.getSurname().equals(booking.getSurname())) {
           booking1.setSurname(booking.getSurname());
       }
       if (booking.getEmail() != null && !booking1.getEmail().equals(booking.getEmail())) {
           booking1.setMob_no(booking.getMob_no());
       }
       if (booking.getMob_no() != 0 && booking1.getMob_no() != (booking.getMob_no())){
           booking1.setMob_no(booking.getMob_no());
       }
       if (booking.getCity() != null && !booking1.getCity().equals(booking.getCity())){
           booking1.setCity(booking.getCity());
       }

        Booking save = bookingRepo.save(booking1);
        BookingDto map = mapper.map(save, BookingDto.class);
        return map;
    }
}
