package com.example.movilidadmdq.controller;

import com.example.movilidadmdq.service.UberDeepLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/deeplink")
@CrossOrigin(origins = "http://localhost:5173")
public class DeepLinkController {

    @Autowired
    private UberDeepLinkService uberDeepLinkService;

    @GetMapping("/uber")
    public Map<String, String> getUberDeepLink(
            @RequestParam String origenNombre,
            @RequestParam double origenLat,
            @RequestParam double origenLng,
            @RequestParam String destinoNombre,
            @RequestParam double destinoLat,
            @RequestParam double destinoLng
    ) {
        String link = uberDeepLinkService.generarDeepLink(
                origenNombre, origenLat, origenLng,
                destinoNombre, destinoLat, destinoLng
        );
        return Map.of("deepLink", link);
    }
}