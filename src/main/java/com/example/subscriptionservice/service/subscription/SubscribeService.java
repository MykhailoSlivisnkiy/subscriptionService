package com.example.subscriptionservice.service.subscription;

import com.example.subscriptionservice.entity.Shop;
import com.example.subscriptionservice.entity.User;
import com.example.subscriptionservice.repository.UserRepository;
import com.example.subscriptionservice.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SubscribeService {

    private final UserService userService;
    private final UserRepository userRepository;

    public Boolean unsubscribe(Long shopId, String token) {
        User user =  userService.getCurrentUser(token).getBody();

        assert user != null;

        Shop shop = user.getSubscribedShops().stream().filter(item -> item.getId().equals(shopId))
                .findAny()
                .orElse(null);

        user.getSubscribedShops().remove(shop);

        System.out.println(user);

        userRepository.save(user);

        return false;
    }
}
