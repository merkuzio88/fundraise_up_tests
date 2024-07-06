package tests.api.models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RecurringResponseModel {

    private String submissionId;
    private String respondentId;

    public RecurringResponseModel() {
    }

    public RecurringResponseModel(String submissionId, String respondentId) {
        this.submissionId = submissionId;
        this.respondentId = respondentId;
    }

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

    public String getRespondentId() {
        return respondentId;
    }

    public void setRespondentId(String respondentId) {
        this.respondentId = respondentId;
    }

    public RecurringResponseModel withSubmissionId(String submissionId) {
        this.submissionId = submissionId;
        return this;
    }

    public RecurringResponseModel withRespondentId(String respondentId) {
        this.respondentId = respondentId;
        return this;
    }
}
