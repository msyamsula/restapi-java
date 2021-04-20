package com.project.restapijava.ReqBody;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PutPersonReqBody {
    
    @JsonProperty("id")
    public Integer id;

    @JsonProperty("name")
    public String name;

    @JsonProperty("address")
    public String address;

    @JsonProperty("account_id")
    public Integer accountId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

}
