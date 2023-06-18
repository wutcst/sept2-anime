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
    private Integer roomId;

    public Goods() {
        
    }

    public Goods(String name, Integer weight, Integer roomId) {
        this.name = name;
        this.weight = weight;
        this.roomId = roomId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
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
