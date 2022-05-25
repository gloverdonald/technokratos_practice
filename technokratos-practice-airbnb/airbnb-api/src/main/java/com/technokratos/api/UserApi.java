package com.technokratos.api;

import com.technokratos.dto.response.PhotoResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RequestMapping("/api/v1/users")
public interface UserApi<PRINCIPAL> {

    @ApiOperation(value = "Добавление аватара", produces = "text/plain")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Идентификатор Фото",
                    response = PhotoResponse.class)})
    @PostMapping("/{id}/avatar")
    @ResponseStatus(HttpStatus.OK)
    String uploadAvatar(@ApiParam(value = "Фото") @RequestParam("photo") MultipartFile photo,
                        @ApiParam(value = "Идентификатор пользователя") @PathVariable("id") UUID userId,
                        @AuthenticationPrincipal PRINCIPAL userPrincipal);

    @ApiOperation(value = "Удаление аватара")
    @DeleteMapping("/{id}/avatar")
    @ResponseStatus(HttpStatus.OK)
    void deleteAvatar(@ApiParam(value = "Идентификатор пользователя") @PathVariable("id") UUID userId,
                      @AuthenticationPrincipal PRINCIPAL userPrincipal);
}
