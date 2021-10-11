package com.example.accessingdatamongodb;

import org.springframework.data.annotation.Id;


public class SalesArea {

    @Id
    public String id;

    public String name;
    public String description;

    public SalesArea() {}

    public SalesArea(String name, String description) {
        this.description = description;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format(
                "SalesArea[id=%s, name='%s', description='%s']",
                id, name, description);
    }

}

