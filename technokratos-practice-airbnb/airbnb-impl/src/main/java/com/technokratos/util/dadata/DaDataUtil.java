package com.technokratos.util.dadata;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.technokratos.util.dadata.model.DaDataAddressEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor
@Component
@Slf4j
public class DaDataUtil {

    @Value("${dadata.auth.key}")
    private String authKey;

    @Value("${dadata.auth.secret}")
    private String authSecret;

    private static final String API_URL = "https://dadata.ru/api";
    private static final String API_VERSION = "v2";
    private static final String REQUEST_METHOD_GET = "GET";
    private static final String REQUEST_METHOD_POST = "POST";
    private final Gson gson = new GsonBuilder().create();

    public DaDataAddressEntity cleanAddress(String source) {
        return cleanAddresses(source)[0];
    }

    public DaDataAddressEntity[] cleanAddresses(String... sources) {
        return populate(sources);
    }

    private <T> T populate(String... sources) {
        return gson.fromJson(fetchJson(sources), (Class<T>) DaDataAddressEntity[].class);
    }

    private String fetchJson(String... sources) {
        String toReturn = null;
        try {
            URL url = new URL(API_URL + "/" + API_VERSION + "/" + "clean/address");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(DaDataUtil.REQUEST_METHOD_POST);
            connection.addRequestProperty("Content-Type", "application/json");
            connection.addRequestProperty("Authorization", "Token " + authKey);
            connection.addRequestProperty("X-Secret", authSecret);
            if (sources.length > 0) {
                connection.setDoOutput(true);
                OutputStream outputStream = connection.getOutputStream();
                outputStream.write(gson.toJson(sources).getBytes(StandardCharsets.UTF_8));
                outputStream.flush();
                outputStream.close();
            }
            InputStream inputStream = connection.getInputStream();
            toReturn = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            inputStream.close();
        } catch (IOException e) {
            System.out.println("Error fetching data " + e);
        }
        return toReturn;
    }
}
