package tests.api.models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RecurringRequestModel {

    private String sessionUuid;
    private String respondentUuid;
    private Map<String, String> responses;
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

    public RecurringRequestModel withIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
        return this;
    }
}
