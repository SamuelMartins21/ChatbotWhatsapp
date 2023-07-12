package com.whatsappstonksbot.bot.services;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.whatsappstonksbot.bot.Price;

@Service
public class FinnhubService {

    public static final String FINNHUB_TOKEN = System.getenv("FINNHUB_API_KEY");

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static Optional<Price> getStockDetails(String symbol) {

        try {
            
            String stockUrlQuery = URLEncoder.encode(symbol.toUpperCase(), StandardCharsets.UTF_8);
            String tokenUrlQuery = URLEncoder.encode(FINNHUB_TOKEN, StandardCharsets.UTF_8);

            String url = "https://finnhub.io/api/v1/quote?symbol=" + stockUrlQuery + "&token=" + tokenUrlQuery;

            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Accept", "application/json")
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();

            Price price = MAPPER.readValue(responseBody, Price.class);

            if ("0".equals(price.open)) {
                return Optional.empty();

            } else {
                return Optional.of(price);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return Optional.empty();
        }

    }
}
