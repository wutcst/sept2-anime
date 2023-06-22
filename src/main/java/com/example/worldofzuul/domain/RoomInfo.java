package com.example.worldofzuul.domain;

/**
 * @ClassName RoomInfo
 * @Description TODO
 * @Author Ducking
 * @DATE 2023/6/18 14:26
 * @Version 1.0
 */
public class RoomInfo {

    protected int id;
    protected String name;
    protected String description;

    public RoomInfo() {
    }

    public RoomInfo(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RoomInfo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
