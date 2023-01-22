package com.micro.service.storeservice.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StoreController {
    @CrossOrigin()
    @GetMapping("/eggs")
    public ResponseEntity<String> listeOeuf() {
        return ResponseEntity.ok("Egg1");
    }
}