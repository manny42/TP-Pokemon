package com.micro.service.mongodemo;

import com.micro.service.mongodemo.model.MedicalReport;
import com.micro.service.mongodemo.repository.MedicalReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccessingDataMongodbApplication implements CommandLineRunner {

    @Autowired
    private MedicalReportRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataMongodbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();

        // save a couple of customers
        repository.save(new MedicalReport( "Smith", "ABD123", 0));
        repository.save(new MedicalReport( "Fool", "XX_XX", 12));

        // fetch all customers
        System.out.println("Medical reports found with findAll():");
        System.out.println("-------------------------------");
        for (MedicalReport customer : repository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();

        // fetch an individual customer
        System.out.println("Medical report found with findByName('Fool'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByName("Fool"));

        System.out.println("Customers found with findByName('Smith'):");
        System.out.println("--------------------------------");
        for (MedicalReport customer : repository.findByName("Smith")) {
            System.out.println(customer);
        }

    }

}