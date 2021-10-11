package com.example.accessingdatamongodb;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    public User findByUsername(String username);
    public List<User> findByEmail(String email);
    public List<User> findByUsernameRegex(String username);
    public List<User> findByUsernameLike(String username);

}
