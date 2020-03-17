package com.rcm.cucumber.api.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data @ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Client {
    @JsonAlias("id")
    private Long id;
    @JsonAlias("email")
    private String email;
    @JsonAlias("firstName")
    private String firstName;
    @JsonAlias("lastName")
    private String lastName;
    @JsonAlias("createAt")
    private Date createAt;

}
