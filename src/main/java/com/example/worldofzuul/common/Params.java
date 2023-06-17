package com.example.worldofzuul.common;

/**
 * @ClassName Params
 * @Description TODO
 * @Author Ducking
 * @DATE 2023/6/15 21:26
 * @Version 1.0
 */
public class Params {
    private Integer room;
    private Integer type;

    @Override
    public String toString() {
        return "Params{" +
                "room=" + room +
                ", type=" + type +
                '}';
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public int getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
