package com.micro.service.mongodemo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("medicalreports")
public class MedicalReport {

    @Id
    private String id;

    private String name;
    private String documentId;
    private long bonesCracked;

    public MedicalReport(String name, String documentId, long bonesCracked) {
        super();
        this.name = name;
        this.documentId = documentId;
        this.bonesCracked = bonesCracked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public long getBonesCracked() {
        return bonesCracked;
    }

    public void setBonesCracked(long bonesCracked) {
        this.bonesCracked = bonesCracked;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, name='%s', bonesCracked='%s']",
                id, name, bonesCracked);
    }
}
