package com.example.subscriptionservice.service.subscription;

import com.example.subscriptionservice.dto.ShopSubscription;
import org.springframework.stereotype.Service;

@Service
public interface SubscriptionDispatcher {
    void subscribe(ShopSubscription shopSubscription);
}
