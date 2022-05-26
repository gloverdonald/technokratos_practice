package com.technokratos.api;

import com.technokratos.dto.request.ApartmentInfoRequest;
import com.technokratos.dto.response.ApartmentInfoResponse;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/apartments/info")
public interface InfoApi {
    @PostMapping("/{apartment-id}")
    ApartmentInfoResponse createApartmentInfo(@PathVariable("apartment-id") UUID apartmentId,
                                              @RequestBody ApartmentInfoRequest apartmentInfoRequest);

    @GetMapping("/{apartment-id}")
    ApartmentInfoResponse getApartmentInfoByApartment(@PathVariable("apartment-id") UUID apartmentId);

    @PutMapping("/{apartment-id}")
    ApartmentInfoResponse updateApartmentInfoByApartment(@PathVariable("apartment-id") UUID apartmentId,
                                                         @RequestBody ApartmentInfoRequest apartmentInfoRequest);
}
