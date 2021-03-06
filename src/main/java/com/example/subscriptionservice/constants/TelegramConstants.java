package com.example.subscriptionservice.constants;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class TelegramConstants {

    @Value("${telegram-url}")
    private String TELEGRAM_URL;

    public static final String TELEGRAM_SUBSCRIPTION_NAME = "telegram";
}
