package tests.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscribeProductsUpdatesRequestModel {

    private ContactFieldsModel contactFields;
    private int portalId;

    public SubscribeProductsUpdatesRequestModel() {
    }

    @JsonProperty(value="contactFields")
    public ContactFieldsModel getContactFieldsModel() {
        return contactFields;
    }

    public void setContactFields(ContactFieldsModel contactFields) {
        this.contactFields = contactFields;
    }

    public int getPortalId() {
        return portalId;
    }

    public void setPortalId(int portalId) {
        this.portalId = portalId;
    }

    public SubscribeProductsUpdatesRequestModel withPortalId(Integer portalId) {
        this.portalId = portalId;
        return this;
    }
}
