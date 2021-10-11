package com.example.accessingdatamongodb;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppsRepository extends MongoRepository<Apps, String> {

    public Apps findByName(String name);
    public List<Apps> findByDescription(String description);

}
