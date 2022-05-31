package com.technokratos.api;

import com.technokratos.dto.request.ApartmentRequest;
import com.technokratos.dto.request.AvailabilityRequest;
import com.technokratos.dto.request.BookingRequest;
import com.technokratos.dto.response.ApartmentResponse;
import com.technokratos.dto.response.AvailabilityResponse;
import com.technokratos.dto.response.BookingResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/apartments")
public interface ApartmentApi<PRINCIPAL, T> {
    @ApiOperation(value = "Добавление апартамента", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Добавленный апартамент",
                    response = ApartmentResponse.class)})
    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    ApartmentResponse create(@ApiParam(value = "Данные для адреса") @Valid @RequestBody ApartmentRequest apartmentRequest,
                             @AuthenticationPrincipal PRINCIPAL userPrincipal);

    @ApiOperation(value = "Получение апартамента", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Полученный апартамент",
                    response = ApartmentResponse.class)})
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ApartmentResponse get(@ApiParam(value = "Идентификатор апартамента") @PathVariable UUID id);

    @ApiOperation(value = "Удаление апартамента")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@ApiParam(value = "Идентификатор апартамента") @PathVariable UUID id,
                @AuthenticationPrincipal PRINCIPAL userPrincipal
    );

    @ApiOperation(value = "Обновление апартамента", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Обновленный апартамент",
                    response = ApartmentResponse.class)})
    @PostMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    ApartmentResponse update(@ApiParam(value = "Идентификатор апартамента") @PathVariable UUID id,
                             @ApiParam(value = "Данные для обновления апартамента")
                             @Valid @RequestBody ApartmentRequest apartmentRequest,
                             @AuthenticationPrincipal PRINCIPAL userPrincipal
    );

    @ApiOperation(value = "Добавление фото апартамента", produces = "text/plain")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Идентификатор фото")})
    @PostMapping("/{id}/photo")
    @ResponseStatus(HttpStatus.OK)
    String uploadPhoto(@ApiParam(value = "Фото") @RequestParam("photo") MultipartFile photo,
                       @ApiParam(value = "Идентификатор апартамента") @PathVariable("id") UUID apartmentId,
                       @AuthenticationPrincipal PRINCIPAL userPrincipal);


    @ApiOperation(value = "Получение всех фото апартамента", produces = "text/plain")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Идентификаторы всех фото")})
    @GetMapping("/{id}/photos")
    @ResponseStatus(HttpStatus.OK)
    List<String> allPhotos(@ApiParam(value = "Идентификатор апартамента") @PathVariable("id") UUID apartmentId);

    @ApiOperation(value = "Удаление фото апартамента")
    @DeleteMapping("/{id}/photo/{photoId}")
    @ResponseStatus(HttpStatus.OK)
    void deletePhoto(@ApiParam(value = "Идентификатор апартамента") @PathVariable("id") UUID apartmentId,
                     @ApiParam(value = "Идентификатор фотографии") @PathVariable("photoId") String photoId,
                     @AuthenticationPrincipal PRINCIPAL userPrincipal
    );

    @ApiOperation(value = "Удаление всех фото апартамента")
    @DeleteMapping("/{id}/photos")
    @ResponseStatus(HttpStatus.OK)
    void deletePhotos(@ApiParam(value = "Идентификатор апартамента") @PathVariable("id") UUID apartmentId,
                      @AuthenticationPrincipal PRINCIPAL userPrincipal);

    @ApiOperation(value = "Добавление доступного периода для бронирования", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Добавленный доступный период",
                    response = AvailabilityResponse.class)})
    @PostMapping(value = "/{id}/availability")
    @ResponseStatus(HttpStatus.CREATED)
    AvailabilityResponse createAvailability(@ApiParam(value = "Идентификатор апартамента")
                                            @PathVariable("id") UUID apartmentId,
                                            @ApiParam(value = "Доступный период")
                                            @Valid @RequestBody AvailabilityRequest availabilityRequest,
                                            @AuthenticationPrincipal PRINCIPAL userPrincipal);

    @ApiOperation(value = "Получение всех доступных периодов для бронирования", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Полученные доступные периоды",
                    response = AvailabilityResponse.class)})
    @GetMapping(value = "/{id}/availabilities")
    @ResponseStatus(HttpStatus.OK)
    List<AvailabilityResponse> getAllAvailabilities(@ApiParam(value = "Идентификатор апартамента")
                                                    @PathVariable("id") UUID apartmentId);

    @ApiOperation(value = "Удаление доступного периода для бронирования")
    @DeleteMapping(value = "/{id}/availability")
    @ResponseStatus(HttpStatus.OK)
    void deleteAvailability(@ApiParam(value = "Идентификатор доступного периода")
                            @PathVariable("id") UUID availabilityId,
                            @AuthenticationPrincipal PRINCIPAL userPrincipal);

    @ApiOperation(value = "Добавление бронирования", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Добавленное бронирование",
                    response = BookingResponse.class)})
    @PostMapping(value = "/{id}//booking")
    @ResponseStatus(HttpStatus.CREATED)
    BookingResponse addBooking(@ApiParam(value = "Идентификатор апартамента")
                               @PathVariable("id") UUID apartmentId,
                               @ApiParam(value = "Данные бронирования")
                               @Valid @RequestBody BookingRequest bookingRequest,
                               @AuthenticationPrincipal PRINCIPAL userPrincipal);

    @ApiOperation(value = "Получение всех апартаментов с заданными параметрами", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Полученные апартаменты",
                    response = ApartmentResponse.class)})
    @GetMapping(value = "/all")
    @ResponseStatus(HttpStatus.OK)
    List<ApartmentResponse> getAllApartments(Specification<T> specification);
}
