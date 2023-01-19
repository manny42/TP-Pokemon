package com.micro.service.storeservice.web.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StoreController {
    @CrossOrigin()
    @GetMapping("/eggs")
    public String[] listeOeuf() {
        return new String[] { "Egg1" };
    }
}