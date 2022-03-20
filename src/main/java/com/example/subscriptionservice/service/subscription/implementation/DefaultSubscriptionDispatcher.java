package com.example.subscriptionservice.service.subscription.implementation;

import com.example.subscriptionservice.constants.ErrorMessage;
import com.example.subscriptionservice.dto.ShopSubscription;
import com.example.subscriptionservice.dto.SubscriptionRequest;
import com.example.subscriptionservice.entity.User;
import com.example.subscriptionservice.exception.InvalidSubscriptionException;
import com.example.subscriptionservice.service.subscription.SubscriptionDispatcher;
import com.example.subscriptionservice.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DefaultSubscriptionDispatcher implements SubscriptionDispatcher {
    private final EmailSubscriptionService emailSubscriptionService;
    private final UserService userService;
    private final TelegramSubscriptionService telegramSubscriptionService;

    @Override
    public void subscribe(ShopSubscription shopSubscription) {

        User user = userService.getCurrentUser(shopSubscription.getToken()).getBody();

        assert user != null;

        shopSubscription.getTypesOfSubscription().forEach(item -> {
            switch (item) {
                case TELEGRAM:

                    telegramSubscriptionService.subscribe(new SubscriptionRequest(shopSubscription.getShopName(), user.getTelegramId()));
                    break;
                case EMAIL:
                    emailSubscriptionService.subscribe(new SubscriptionRequest(shopSubscription.getShopName(), user.getEmail()));
                    break;
                default:
                    throw new InvalidSubscriptionException(ErrorMessage.INVALID_SUBSCRIPTION_MESSAGE);
            }
        });
    }
}
