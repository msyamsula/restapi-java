package com.project.restapijava.ReqBody;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostPersonReqBody {
    
    @JsonProperty("name")
    public String name;

    @JsonProperty("account_id")
    public Integer accountId;

    @JsonProperty("address")
    public String address;

}
