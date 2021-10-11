package com.example.accessingdatamongodb;

import org.springframework.data.annotation.Id;

import java.util.List;

public class UserPreference {

    @Id
    public String id;

    public List<String> notifications;
    public List<String> others;

    public UserPreference() {}

    public UserPreference(List<String> notifications, List<String> others) {
        this.notifications = notifications;
        this.others = others;
    }

    @Override
    public String toString() {
        return String.format(
                "UserPreference[id=%s, notifications='%s', others='%s']",
                id, notifications, others);
    }

}

