package com.whatsappstonksbot.bot.services;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.whatsappstonksbot.bot.Price;

public class FinnhubService {
    public static final String FINNHUB_TOKEN = System.getenv("FINNHUB_API_KEY");

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static Optional<Price> getStockDetails(String symbol) {

        try {

            String stockUrlQuery = URLEncoder.encode(symbol.toUpperCase(), StandardCharsets.UTF_8);
            String tokenUrlQuery = URLEncoder.encode(FINNHUB_TOKEN, StandardCharsets.UTF_8);

            URL url = new URL("https://finnhub.io/api/v1/quote?symbol=" + stockUrlQuery + "&token=" + tokenUrlQuery);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("accept", "application/json");
            InputStream responseStream = connection.getInputStream();
            Price price = MAPPER.readValue(responseStream, Price.class);

            if ("0".equals(price.open)) {
                return Optional.empty();

            } else {
                return Optional.of(price);
            }

        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }

    }
}
