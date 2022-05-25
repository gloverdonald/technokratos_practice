package com.technokratos.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Пара токенов")
public class TokensResponse {

    @ApiModelProperty(value = "Access токен")
    private String accessToken;

    @ApiModelProperty(value = "Refresh токен")
    private String refreshToken;
}
