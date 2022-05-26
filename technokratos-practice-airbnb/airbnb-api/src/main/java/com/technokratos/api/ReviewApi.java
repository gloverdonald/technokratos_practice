package com.technokratos.api;

import com.technokratos.dto.request.ApartmentReviewRequest;
import com.technokratos.dto.response.ApartmentReviewResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/apartments/review")
public interface ReviewApi<PRINCIPAL> {

    @ApiOperation(value = "Добавление отзыва об апартаменте", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Добавленный отзыв",
                    response = ApartmentReviewResponse.class)})
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{apartment-id}")
    ApartmentReviewResponse createApartmentReview(@ApiParam(value = "Идентификатор апартамента")
                                                  @PathVariable("apartment-id") UUID apartmentId,
                                                  @ApiParam(value = "Отзыв об апартаменте")
                                                  @Valid @RequestBody ApartmentReviewRequest reviewRequest,
                                                  @AuthenticationPrincipal PRINCIPAL userPrincipal);

    @ApiOperation(value = "Получение отзывов об апартаменте", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Полученные отзывы",
                    response = ApartmentReviewResponse.class)})
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{apartment-id}")
    List<ApartmentReviewResponse> getReviewByApartment(@ApiParam(value = "Идентификатор апартамента")
                                                       @PathVariable("apartment-id") UUID apartmentId);

    @ApiOperation(value = "Обновление отзыва об апартаменте", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Обновленный отзыв",
                    response = ApartmentReviewResponse.class)})
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{apartment-id}")
    ApartmentReviewResponse updateReviewByApartment(@ApiParam(value = "Идентификатор апартамента")
                                                    @PathVariable("apartment-id") UUID reviewId,
                                                    @ApiParam(value = "Отзыв об апартаменте")
                                                    @Valid @RequestBody ApartmentReviewRequest reviewRequest,
                                                    @AuthenticationPrincipal PRINCIPAL userPrincipal);
}