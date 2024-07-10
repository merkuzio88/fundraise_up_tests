package tests.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscribeStatusRequestModel {

    @With
    private Boolean email_otp_verify_flow;

    @With
    private String email;

    @With
    private Boolean captcha_error;
}
