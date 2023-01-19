package com.micro.service.mongodemo.repository;

import com.micro.service.mongodemo.model.MedicalReport;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MedicalReportRepository extends MongoRepository<MedicalReport, String> {
    MedicalReport findByDocumentId(String documentId);

    List<MedicalReport> findAll();
    List<MedicalReport> findByName(String name);

    public long count();
}
