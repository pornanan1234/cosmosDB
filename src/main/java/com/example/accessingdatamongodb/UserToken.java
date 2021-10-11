package com.example.accessingdatamongodb;

import org.springframework.data.annotation.Id;


public class UserToken {

    @Id
    public String id;

    public User userProfile;
    public UserMetadata userMetadata;
    public AppMetadata appMetadata;

    public UserToken() {}

    public UserToken(User userProfile, UserMetadata userMetadata,AppMetadata appMetadata) {
        this.id = userProfile.getUsername();
        this.userProfile = userProfile;
        this.userMetadata = userMetadata;
        this.appMetadata = appMetadata;

    }

    @Override
    public String toString() {
        return String.format(
                "UserToken[id=%s, userProfile='%s', userMetadata='%s']",
                id, userProfile, userMetadata);
    }


}

