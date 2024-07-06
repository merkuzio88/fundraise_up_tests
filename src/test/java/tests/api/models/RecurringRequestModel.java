package tests.api.models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Map;

public class RecurringRequestModel implements Serializable {

    private String sessionUuid;
    private String respondentUuid;
    private Map<String, String> responses;
    @JsonProperty(value="isCompleted")
    private boolean isCompleted;

    public RecurringRequestModel() {
    }

    public RecurringRequestModel(String sessionUuid, String respondentUuid, Map<String, String> responses, boolean isCompleted) {
        this.sessionUuid = sessionUuid;
        this.respondentUuid = respondentUuid;
        this.responses = responses;
        this.isCompleted = isCompleted;
    }

    public String getSessionUuid() {
        return sessionUuid;
    }

    public void setSessionUuid(String sessionUuid) {
        this.sessionUuid = sessionUuid;
    }

    public String getRespondentUuid() {
        return respondentUuid;
    }

    public void setRespondentUuid(String respondentUuid) {
        this.respondentUuid = respondentUuid;
    }

    public Map<String, String> getResponses() {
        return responses;
    }

    public void setResponses(Map<String, String> responses) {
        this.responses = responses;
    }

    @JsonProperty(value="isCompleted")
    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public RecurringRequestModel withSessionUuid(String sessionUuid) {
        this.sessionUuid = sessionUuid;
        return this;
    }

    public RecurringRequestModel withRespondentUuid(String respondentUuid) {
        this.respondentUuid = respondentUuid;
        return this;
    }

    public RecurringRequestModel withResponses(Map<String, String> responses) {
        this.responses = responses;
        return this;
    }

    @JsonProperty(value="isCompleted")
    public RecurringRequestModel withCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
        return this;
    }
}
