package com.example.accessingdatamongodb;

import org.springframework.data.annotation.Id;

import java.util.*;

public class NonAdminRole {

    @Id
    public String id;
    public String name;
    public List<String> permissions;

    public String getId() {
        return id;
    }

    public NonAdminRole() {}

    public NonAdminRole( String name, List<String> permissions) {
        this.name = name;
        this.permissions = permissions;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format(
                "NonAdminRole[id=%s, permissions='%s']",
                name, permissions);
    }

}


