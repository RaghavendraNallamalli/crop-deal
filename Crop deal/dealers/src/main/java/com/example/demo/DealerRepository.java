package com.example.demo;



import com.example.demo.Dealer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/*
 * Repository Interface for Dealer operations on the database
 * */
@Repository
public interface DealerRepository extends MongoRepository<Dealer, String>{
}