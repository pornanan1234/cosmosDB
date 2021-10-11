package com.example.accessingdatamongodb;

import java.util.List;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminRoleRepository extends MongoRepository<AdminRole, String> {


    public AdminRole findByName(String name);
    public Optional<AdminRole> findById(String Id);

}
