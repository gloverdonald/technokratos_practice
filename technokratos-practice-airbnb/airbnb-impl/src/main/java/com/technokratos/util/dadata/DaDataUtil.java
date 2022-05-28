package com.technokratos.util.dadata;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.technokratos.util.dadata.model.DaDataAddressEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
@Slf4j
public class DaDataUtil {
    private static final String CLEAN_ADDRESS_URL = "https://dadata.ru/api/v2/clean/address";
    private final Gson gson = new GsonBuilder().create();
    @Value("${dadata.auth.key}")
    private String authKey;
    @Value("${dadata.auth.secret}")
    private String authSecret ;

    public DaDataAddressEntity cleanAddress(String source) {
        return gson.fromJson(fetchJson(source), DaDataAddressEntity[].class)[0];
    }

    private String fetchJson(String... sources) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Content-Type", "application/json");
        headers.set("Authorization", "Token " + authKey);
        headers.set("X-Secret", authSecret);
        String data = gson.toJson(sources);
        HttpEntity<String> entity = new HttpEntity<>(data, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(CLEAN_ADDRESS_URL, HttpMethod.POST, entity, String.class);
        return response.getBody();
    }
}
