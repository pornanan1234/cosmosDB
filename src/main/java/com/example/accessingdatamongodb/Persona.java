package com.example.accessingdatamongodb;

import org.springframework.data.annotation.Id;

import java.util.*;

public class Persona {

    @Id
    public String id;


    public String name;

    public List<String> salesareas;

    public List<String> getSalesareas() {
        return salesareas;
    }

    public List<String> customerGroups;

    public List<String> getCustomerGroups() {
        return customerGroups;
    }

    public String adminRole;
    public List<String> nonAdminList;


    public Persona() {}


    public Persona(Persona persona) {
        this.salesareas = persona.salesareas;
        this.customerGroups = persona.customerGroups;
        this.adminRole = persona.adminRole;
        this.nonAdminList = persona.nonAdminList;


    }


    public Persona(String name,List<String> salesareas, List<String> customerGroups,AdminRole adminRole,List<NonAdminRole> nonAdminList) {
        this.salesareas = salesareas;
        this.customerGroups = customerGroups;
        this.adminRole = adminRole.getId();

        List<String> temps = new ArrayList<>();

        for(int i = 0;i<nonAdminList.size();i++){
            temps.add(nonAdminList.get(i).getId());
        }

        this.nonAdminList = temps;


        this.name =name;

    }

    public String getAdminRole() {
        return adminRole;
    }

    public List<String> getNonAdminList() {
        return nonAdminList;
    }

    @Override
    public String toString() {
        return String.format(
                "Persona[name=%s, salesarea='%s', customerGroup='%s']",
                name, salesareas, customerGroups);
    }

}


