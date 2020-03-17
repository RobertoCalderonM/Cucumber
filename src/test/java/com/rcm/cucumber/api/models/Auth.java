package com.rcm.cucumber.api.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.ToString;

@Getter  @ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Auth {
    @JsonAlias("access_token")
    private String accessToken;
    @JsonAlias("token_type")
    private String tokenType;
    @JsonAlias("refresh_token")
    private String refreshToken;
    @JsonAlias("expires_in")
    private String expiresIn;
    @JsonAlias("scope")
    private String scope;
}
