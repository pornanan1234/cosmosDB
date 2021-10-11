package com.example.accessingdatamongodb;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SoldtoRepository extends MongoRepository<Soldto, String> {

    public Soldto findByStripeNumber(String name);
    public List<Soldto> findByShipTosStripeNumber(String name);

}
