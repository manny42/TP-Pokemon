package com.micro.service.userservice.web.controller;

import com.micro.service.userservice.web.model.UserTransaction;
import com.micro.service.userservice.web.repository.UserTransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userTransactions")
public class UserController {

    @Autowired
    private UserTransactionRepo userTransactionRepo;

    @PostMapping
    public UserTransaction save(@RequestBody UserTransaction userTransactionDetails) {
        return userTransactionRepo.save(userTransactionDetails);
    }

    @GetMapping
    public List<UserTransaction> getTransactions() {
        return userTransactionRepo.findAll();
    }

    @GetMapping("/{id}")
    public UserTransaction findTransactionItemById(@PathVariable int id) {
        return userTransactionRepo.findItemById(id);
    }


    @DeleteMapping("/{id}")
    public String deleteTransactionById(@PathVariable int id)   {
        return userTransactionRepo.deleteUserTransaction(id);
    }
}