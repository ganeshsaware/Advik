package com.Booking.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {

    private Long id;
    private String name;
    private  String surname;
    private long mob_no;
    private String email;
    private String city;
}
