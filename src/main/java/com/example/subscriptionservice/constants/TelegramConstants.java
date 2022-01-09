package com.example.subscriptionservice.constants;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class TelegramConstants {

    public static final String NEW_GOODS_IN_SHOP = "There new goods in second-hand %s";

    @Value("${telegram-url}")
    private String TELEGRAM_URL;
}
