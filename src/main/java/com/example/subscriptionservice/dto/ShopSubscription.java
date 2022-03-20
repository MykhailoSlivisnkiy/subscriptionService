package com.example.subscriptionservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class ShopSubscription {
    String shopName;
    String token;
    List<TypeOfSubscription> typesOfSubscription;
}
