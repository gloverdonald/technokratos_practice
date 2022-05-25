package com.technokratos.api;

import com.technokratos.dto.response.PhotoResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/photo")
public interface PhotoApi {

    @ApiOperation(value = "Получение фото и данных o нем", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Фото",
                    response = PhotoResponse.class)})
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    PhotoResponse downloadPhoto(@ApiParam(value = "Идентификатор фото") @PathVariable("id") String id);

    @ApiOperation(value = "Отображение фото")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Фото")})
    @GetMapping(value = "/view/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<byte[]> showPhoto(@ApiParam(value = "Идентификатор фото") @PathVariable("id") String id);

}
