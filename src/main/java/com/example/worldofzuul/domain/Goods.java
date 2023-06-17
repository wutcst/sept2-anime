package com.example.worldofzuul.domain;

/**
 * @ClassName Goods
 * @Description 物品类
 * @Author Ducking
 * @DATE 2023/6/15 23:07
 * @Version 1.0
 */
public class Goods {
    private int id;
    private String name;
    private Integer weight;

    public Goods(String name, String description, Integer weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
