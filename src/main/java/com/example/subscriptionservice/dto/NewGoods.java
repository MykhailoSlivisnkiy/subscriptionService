package com.example.subscriptionservice.dto;

import com.example.subscriptionservice.entity.Goods;
import lombok.Data;

import java.util.List;

@Data
public class NewGoods {

    private List<Goods> newGoods;
    private String shopName;
}
