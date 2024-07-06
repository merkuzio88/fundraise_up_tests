package tests.api.models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactFieldsModel {

    private String email;

    public ContactFieldsModel() {
    }

    public ContactFieldsModel(String email) {
        this.email = email;
    }
}
