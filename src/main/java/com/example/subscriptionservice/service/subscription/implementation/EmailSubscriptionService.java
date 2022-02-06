package com.example.subscriptionservice.service.subscription.implementation;

import com.example.subscriptionservice.constants.EmailConstants;
import com.example.subscriptionservice.dto.SubscriptionRequest;
import com.example.subscriptionservice.service.subscription.SubscriptionService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
@Data
public class EmailSubscriptionService implements SubscriptionService {
    private final EmailConstants emailConstants;

    @Override
    public ResponseEntity<String> subscribe(SubscriptionRequest subscriptionRequest) {
        return new RestTemplate().postForEntity(
                emailConstants.getEMAIL_URL(),
                subscriptionRequest,
                String.class);
    }
}
