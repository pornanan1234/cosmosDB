package com.example.accessingdatamongodb;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerGroupRepository extends MongoRepository<CustomerGroup, String> {

    public CustomerGroup findByName(String name);
    public List<CustomerGroup> findByDescription(String description);

}
