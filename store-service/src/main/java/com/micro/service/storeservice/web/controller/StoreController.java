package com.micro.service.storeservice.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class StoreController {
    @GetMapping("/eggs")
    public ResponseEntity<Map<String, String>> listeOeuf() {
        Map<String, String> map = new HashMap<>();
        map.put("value", "Eggs");
        return ResponseEntity.ok(map);
    }
}
