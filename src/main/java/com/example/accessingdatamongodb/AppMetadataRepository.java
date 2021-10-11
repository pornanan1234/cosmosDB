package com.example.accessingdatamongodb;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppMetadataRepository extends MongoRepository<AppMetadata, String> {

    public AppMetadata findByRoles(String name);

}
