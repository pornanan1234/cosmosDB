package com.example.accessingdatamongodb;

import org.springframework.data.annotation.Id;


public class Apps {

    @Id
    public String id;

    public String getId() {
        return id;
    }

    public String name;
    public String description;

    public Apps() {}

    public Apps(String name, String description) {
        this.description = description;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format(
                "Apps[id=%s, name='%s', description='%s']",
                id, name, description);
    }

}

