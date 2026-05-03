package com.example.movilidadmdq.service;

import org.springframework.stereotype.Service;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class UberDeepLinkService {

    public String generarDeepLink(
            String origenNombre,
            double origenLat,
            double origenLng,
            String destinoNombre,
            double destinoLat,
            double destinoLng
    ) {
        Map<String, String> params = new LinkedHashMap<>();
        params.put("action", "setPickup");
        params.put("pickup[latitude]",  String.valueOf(origenLat));
        params.put("pickup[longitude]", String.valueOf(origenLng));
        params.put("pickup[nickname]",  origenNombre);
        params.put("dropoff[latitude]",  String.valueOf(destinoLat));
        params.put("dropoff[longitude]", String.valueOf(destinoLng));
        params.put("dropoff[nickname]",  destinoNombre);

        StringBuilder query = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (query.length() > 0) query.append("&");
            query.append(URLEncoder.encode(entry.getKey(),   StandardCharsets.UTF_8));
            query.append("=");
            query.append(URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8));
        }

        return "https://m.uber.com/ul/?" + query;
    }
}