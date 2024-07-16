package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RFRepository extends MongoRepository<Rfid, String> {
}
