package tests.api.models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscribeProductsUpdatesRequestModel {

    private ContactFieldsModel contactFieldsModel;
    private int portalId;

    public SubscribeProductsUpdatesRequestModel() {
    }

    public void setContactFields(ContactFieldsModel contactFieldsModel) {
        this.contactFieldsModel = contactFieldsModel;
    }

    public SubscribeProductsUpdatesRequestModel withPortalId(Integer portalId) {
        this.portalId = portalId;
        return this;
    }
}
