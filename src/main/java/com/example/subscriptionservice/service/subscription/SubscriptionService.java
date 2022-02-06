package com.example.subscriptionservice.service.subscription;

import com.example.subscriptionservice.dto.SubscriptionRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface SubscriptionService {
    ResponseEntity<String> subscribe(SubscriptionRequest subscriptionRequest);
}
