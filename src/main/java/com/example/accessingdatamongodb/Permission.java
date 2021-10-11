package com.example.accessingdatamongodb;

import org.springframework.data.annotation.Id;


public class Permission {

    @Id
    public String id;

    public String getId() {
        return id;
    }

    public String name;
    public String description;

    public Permission() {}

    public Permission(String description) {
        this.name = description;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format(
                "Permission[id=%s]",
                name);
    }

}


