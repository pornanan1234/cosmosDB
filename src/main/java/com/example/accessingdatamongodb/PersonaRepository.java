package com.example.accessingdatamongodb;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonaRepository extends MongoRepository<Persona, String> {


    public Persona findBySalesareasAndCustomerGroups(String salesarea,String customerGroup);
}
