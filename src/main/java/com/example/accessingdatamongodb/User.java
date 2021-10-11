package com.example.accessingdatamongodb;

import org.springframework.data.annotation.Id;


public class User {

    @Id
    public String id;

    public String username;

    public String getUsername() {
        return username;
    }

    public String email;
    public String name;
    public String userType;
    public String roleType;
    public String status;
    public String tel;
    public String country;
    public String defaultLanguage;
    public UserPreference userPreference;


    public User() {}

    public User(String username, String email, String name, String userType, String roleType , String status, String tel, String country , String defaultLanguage,
                UserPreference userPreference) {
        this.email = email;
        this.username = username;
        this.name = name;
        this.userType=userType;
        this.roleType=roleType;
        this.status = status;
        this.tel = tel;
        this.country = country;
        this.defaultLanguage = defaultLanguage;
        this.userPreference = userPreference;

    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%s, username='%s', email='%s', name='%s', status='%s', tel='%s', country='%s', defaultLanguage='%s']",
                id, username, email, name , status ,  tel , country , defaultLanguage );
    }

}

