package com.example.accessingdatamongodb;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserTokenRepository extends MongoRepository<UserToken, String> {

    public List<UserToken> findByUserProfileUsername(String username);

}
