package com.example.subscriptionservice.service.subscription.implementation;

import com.example.subscriptionservice.constants.ErrorMessage;
import com.example.subscriptionservice.dto.ShopSubscription;
import com.example.subscriptionservice.dto.SubscriptionRequest;
import com.example.subscriptionservice.exception.InvalidSubscriptionException;
import com.example.subscriptionservice.service.subscription.SubscriptionDispatcher;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DefaultSubscriptionDispatcher implements SubscriptionDispatcher {
    private final EmailSubscriptionService emailSubscriptionService;
    private final TelegramSubscriptionService telegramSubscriptionService;

    @Override
    public void subscribe(ShopSubscription shopSubscription) {

        shopSubscription.getTypesOfSubscription().forEach(item -> {
            switch (item) {
                case TELEGRAM:
                    telegramSubscriptionService.subscribe(new SubscriptionRequest(shopSubscription.getShopName(), "662449862"));
                    break;
                case EMAIL:
                    emailSubscriptionService.subscribe(new SubscriptionRequest(shopSubscription.getShopName(), "miwka0806@gmail.com"));
                    break;
                default:
                    throw new InvalidSubscriptionException(ErrorMessage.INVALID_SUBSCRIPTION_MESSAGE);
            }
        });
    }
}
