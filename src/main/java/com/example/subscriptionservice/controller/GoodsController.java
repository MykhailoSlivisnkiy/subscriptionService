package com.example.subscriptionservice.controller;

import com.example.subscriptionservice.constants.TelegramConstants;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/goods")
@AllArgsConstructor
public class GoodsController {

    private TelegramConstants telegramConstants;

    @PostMapping
    public void addNewGoods(@RequestBody String goods) {
        ResponseEntity<String> responseEntity =
                new RestTemplate().postForEntity(
                        telegramConstants.getTELEGRAM_URL(),
                        String.format(TelegramConstants.NEW_GOODS_IN_SHOP,  goods),
                        String.class);
    }
}
