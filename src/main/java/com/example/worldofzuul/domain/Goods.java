package com.example.worldofzuul.domain;

/**
 * @ClassName Goods
 * @Description TODO
 * @Author Ducking
 * @DATE 2023/6/15 23:07
 * @Version 1.0
 */
public class Goods {
    private Integer id;
    private String name;
    private String describe;
    private Integer weight;
    private Object picture;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Object getPicture() {
        return picture;
    }

    public void setPicture(Object picture) {
        this.picture = picture;
    }
}
