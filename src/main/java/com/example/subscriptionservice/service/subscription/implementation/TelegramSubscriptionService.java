package com.example.subscriptionservice.service.subscription.implementation;

import com.example.subscriptionservice.constants.TelegramConstants;
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
public class TelegramSubscriptionService implements SubscriptionService {
    private final TelegramConstants telegramConstants;

    @Override
    public ResponseEntity<String> subscribe(SubscriptionRequest subscriptionRequest) {
        return new RestTemplate().postForEntity(
                        telegramConstants.getTELEGRAM_URL(),
                        subscriptionRequest,
                        String.class);
    }
}
