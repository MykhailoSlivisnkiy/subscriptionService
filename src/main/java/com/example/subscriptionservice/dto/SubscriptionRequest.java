package com.example.subscriptionservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SubscriptionRequest {
    String shopName;
    String destination;
}
