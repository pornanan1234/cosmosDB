package com.example.accessingdatamongodb;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SalesAreaRepository extends MongoRepository<SalesArea, String> {

    public SalesArea findByName(String name);

}
