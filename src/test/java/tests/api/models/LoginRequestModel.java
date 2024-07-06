package tests.api.models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginRequestModel {

    private String email;
    private String password;

    public LoginRequestModel() {
    }

    public LoginRequestModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public LoginRequestModel withEmail(String email) {
        this.email = email;
        return this;
    }

    public LoginRequestModel withPassword(String password) {
        this.password = password;
        return this;
    }
}
