package com.project.restapijava.ReqBody;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostAccountReqBody {

    @JsonProperty("username")
    public String username;

    @JsonProperty("password")
    public String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

    

}
