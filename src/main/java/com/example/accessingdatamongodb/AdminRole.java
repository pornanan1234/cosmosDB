package com.example.accessingdatamongodb;

import org.springframework.data.annotation.Id;

import java.util.*;

public class AdminRole {

    @Id
    public String id;

    public String getId() {
        return id;
    }

    public String name;
    public List<String> permissions;
    public List<String> appList;

    public AdminRole() {}

    public AdminRole( String name, List<String> permissions,List<String> appList) {
        this.name = name;
        this.permissions = permissions;
        this.appList =appList;

    }

    public String getName() {
        return name;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public List<String> getAppList() {
        return appList;
    }

    @Override
    public String toString() {
        return String.format(
                "AdminRole[id=%s, name='%s', permissions='%s']",
                id, name, permissions);
    }

}


