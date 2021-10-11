package com.example.accessingdatamongodb;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserMetadataRepository extends MongoRepository<UserMetadata, String> {

    public UserMetadata findBySoldTosUniqueid(String uniqueid);

}
