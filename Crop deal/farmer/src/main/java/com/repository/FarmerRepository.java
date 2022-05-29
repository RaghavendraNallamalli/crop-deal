package com.repository;

import com.model.Farmer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmerRepository extends MongoRepository<Farmer, String>{
}