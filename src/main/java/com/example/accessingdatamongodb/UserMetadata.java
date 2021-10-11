package com.example.accessingdatamongodb;

import org.springframework.data.annotation.Id;

import java.util.List;

public class UserMetadata {

    @Id
    public String id;

    public List<Soldto> soldTos;

    public UserMetadata() {}

    public UserMetadata(List<Soldto> soldTos) {
        this.soldTos = soldTos;
    }

    @Override
    public String toString() {
        return String.format(
                "UserMetadata[id=%s, soldTos='%s']",
                id, soldTos);
    }

}

