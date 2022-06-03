package io.focati.java8.tools.entity;

import lombok.Data;

import java.util.List;

@Data
public class OnlineShoppingCart {
    private List<Shop> shops;
    private List<Customer> customers;
}
