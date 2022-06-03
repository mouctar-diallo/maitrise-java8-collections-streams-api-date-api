package io.focati.java8.tools.entity;

import lombok.Data;

import java.util.List;

@Data
public class Shop {
    private String name;
    private List<ShopItem> items;
}
