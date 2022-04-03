package com.example.subscriptionservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserShopInfoDto {
    private Boolean isUserSubscribed;
    private Boolean isUserFavoriteShop;
}
