package com.example.subscriptionservice.service.user;

import com.example.subscriptionservice.dto.UserShopInfoDto;
import com.example.subscriptionservice.entity.Shop;
import com.example.subscriptionservice.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class UserService {

    public ResponseEntity<User> getCurrentUser(String token) {
        return new RestTemplate().postForEntity(
                "http://localhost:8080/auth/get-current-user",
                token,
                User.class);
    }

    public UserShopInfoDto getUserInformationRelatedToShop(Long shopId, String token) {

        boolean isUserSubscribed;
        boolean isUserFavoriteShop;

        User user =  getCurrentUser(token).getBody();

        assert user != null;

        if(user.getSubscribedShops() == null || user.getSubscribedShops().isEmpty()) {
            isUserSubscribed = false;
        } else {
            Shop shop = user.getSubscribedShops().stream()
                    .filter(item -> item.getId().equals(shopId))
                    .findAny()
                    .orElse(null);

            isUserSubscribed = shop != null;
        }

        if(user.getFavoriteShops() == null || user.getFavoriteShops().isEmpty()) {
            isUserFavoriteShop = false;
        } else {
            Shop shop = user.getFavoriteShops().stream()
                    .filter(item -> item.getId().equals(shopId))
                    .findAny()
                    .orElse(null);

            isUserFavoriteShop = shop != null;
        }


        return new UserShopInfoDto(isUserSubscribed, isUserFavoriteShop);
    }

}
