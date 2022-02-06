package com.example.subscriptionservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class ShopSubscription {
    String shopName;
    List<TypeOfSubscription> typesOfSubscription;
}
