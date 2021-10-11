package com.example.accessingdatamongodb;

import org.springframework.data.annotation.Id;

import java.util.List;

public class AppMetadata {

    @Id
    public String id;

    public List<String> roles;
    public List<String> permissions;
    public List<String> apps;

    public AppMetadata() {}

    public AppMetadata(List<String> roles, List<String> permissions , List<String> apps) {
        this.permissions = permissions;
        this.apps = apps;
        this.roles = roles;

    }

    @Override
    public String toString() {
        return String.format(
                "AppMetadata[id=%s, roles='%s', permissions='%s' , apps='%s']",
                id, roles, permissions,apps);
    }

}

