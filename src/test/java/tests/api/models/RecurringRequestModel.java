package tests.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import lombok.experimental.Accessors;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class RecurringRequestModel {

    @With
    private String sessionUuid;
    @With
    private String respondentUuid;
    @With
    private Map<String, String> responses;
    @With
    private boolean isCompleted;

    @JsonProperty(value = "isCompleted")
    public boolean isCompleted() {
        return isCompleted;
    }
}
