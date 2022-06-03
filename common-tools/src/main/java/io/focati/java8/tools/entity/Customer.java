package io.focati.java8.tools.entity;

import lombok.Data;

import java.util.List;

@Data
public class Customer {
    private String name;
    private Integer age;
    private Integer budget;
    private List<CustomerItem> items;
}
