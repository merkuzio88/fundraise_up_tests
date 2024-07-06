package tests.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UnsuccessfulLoginResponseModel {

    private String message;

    public UnsuccessfulLoginResponseModel() {
    }

    public UnsuccessfulLoginResponseModel(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
