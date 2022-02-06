package com.example.subscriptionservice.constants;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class EmailConstants {

    @Value("${email-url}")
    private String EMAIL_URL;

    public static final String EMAIL_SUBSCRIPTION_NAME = "email";
}
