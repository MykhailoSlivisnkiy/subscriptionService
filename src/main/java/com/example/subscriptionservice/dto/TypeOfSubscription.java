package com.example.subscriptionservice.dto;

import com.example.subscriptionservice.constants.EmailConstants;
import com.example.subscriptionservice.constants.TelegramConstants;

public enum TypeOfSubscription {
    EMAIL(EmailConstants.EMAIL_SUBSCRIPTION_NAME), TELEGRAM(TelegramConstants.TELEGRAM_SUBSCRIPTION_NAME);

    String typeValue;

    TypeOfSubscription(String typeValue) {
        this.typeValue = typeValue;
    }
}
