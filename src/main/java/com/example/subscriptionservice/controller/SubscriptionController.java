package com.example.subscriptionservice.controller;

import com.example.subscriptionservice.dto.ShopSubscription;
import com.example.subscriptionservice.dto.UserShopInfoDto;
import com.example.subscriptionservice.service.subscription.SubscribeService;
import com.example.subscriptionservice.service.subscription.SubscriptionDispatcher;
import com.example.subscriptionservice.service.user.UserService;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subscribe")
@AllArgsConstructor
@CrossOrigin
public class SubscriptionController {
    private final SubscriptionDispatcher subscriptionDispatcher;
    private final SubscribeService subscribeService;
    private final UserService userService;

    @GetMapping
    public UserShopInfoDto getUserInformationRelatedToShop(@RequestParam(name = "shopId") Long shopId, @RequestParam(name = "token") String token) {

        return userService.getUserInformationRelatedToShop(shopId, token);
    }

    @PostMapping
    public void newSubscribe(@RequestBody ShopSubscription shopSubscription) {
        subscriptionDispatcher.subscribe(shopSubscription);
    }

    @GetMapping("/unsubscribe")
    public Boolean unsubscribe(@RequestParam(name = "shopId") Long shopId, @RequestParam(name = "token") String token) {
       return subscribeService.unsubscribe(shopId, token);
    }

    @PostMapping("/new-clothes")
    public void newClothes(@RequestBody ShopSubscription shopSubscription) {
        subscriptionDispatcher.subscribe(shopSubscription);
    }
}

