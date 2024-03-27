package com.Booking.service;

import com.Booking.entity.Booking;
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

    public Booking addBookings (Booking booking){
        return bookingRepo.save(booking);
    }

    public List<Booking> getAllBookings() {
        List<Booking> all = bookingRepo.findAll();
        return all;
    }

    public Booking getBookingById(long id) {
        Booking booking = bookingRepo.findById(id).orElseThrow(() -> new RuntimeException("Id not found" + id));
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

    Booking mapTOEntity (BookingDto dto){

        Booking map = mapper.map(dto, Booking.class);
//        Booking booking = new Booking();
//        booking.setId(dto.getId());
//        booking.setName(dto.getName());
//        booking.setSurname(dto.getSurname());
//        booking.setMob_no(dto.getMob_no());
//        booking.setEmail(dto.getEmail());
//        booking.setCity(dto.getCity());
        return map;
    }

    BookingDto mapToDto (Booking booking){

        BookingDto map = mapper.map(booking, BookingDto.class);
//        BookingDto dto1 = new BookingDto();
//        dto1.setId(booking.getId());
//        dto1.setName(booking.getName());
//        dto1.setSurname(booking.getSurname());
//        dto1.setMob_no(booking.getMob_no());
//        dto1.setEmail(booking.getEmail());
//        dto1.setCity(booking.getCity());
        return map;
    }
}
