package com.example.subscriptionservice.controller;

import com.example.subscriptionservice.dto.ShopSubscription;
import com.example.subscriptionservice.service.subscription.SubscriptionDispatcher;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subscribe")
@AllArgsConstructor
@CrossOrigin
public class SubscriptionController {
    private final SubscriptionDispatcher subscriptionDispatcher;

    @PostMapping
    public void newSubscribe(@RequestBody ShopSubscription shopSubscription) {
        subscriptionDispatcher.subscribe(shopSubscription);
    }

    @PostMapping("/new-clothes")
    public void newClothes(@RequestBody ShopSubscription shopSubscription) {
        subscriptionDispatcher.subscribe(shopSubscription);
    }
}

