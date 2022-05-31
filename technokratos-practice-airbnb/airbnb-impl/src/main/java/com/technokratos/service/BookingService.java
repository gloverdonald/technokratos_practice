package com.technokratos.service;

import com.technokratos.dto.request.AvailabilityRequest;
import com.technokratos.dto.request.BookingRequest;
import com.technokratos.dto.response.AvailabilityResponse;
import com.technokratos.dto.response.BookingResponse;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.UUID;

public interface BookingService {
    AvailabilityResponse saveAvailability(UUID apartmentId, AvailabilityRequest availabilityRequest, UserDetails userDetails);

    List<AvailabilityResponse> getAllAvailabilities(UUID apartmentId);

    void deleteAvailability(UUID availabilityId, UserDetails userDetails);

    BookingResponse addBooking(UUID apartmentId, BookingRequest bookingRequest, UserDetails userDetails);
}
