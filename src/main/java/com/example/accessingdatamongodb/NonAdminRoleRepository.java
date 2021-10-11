package com.example.accessingdatamongodb;

import java.util.List;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NonAdminRoleRepository extends MongoRepository<NonAdminRole, String> {


    public NonAdminRole findByName(String name);
    public Optional<NonAdminRole> findById(String Id);

}
