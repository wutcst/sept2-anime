package com.example.worldofzuul.domain;

import com.example.worldofzuul.common.Direction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @ClassName Room
 * @Description 房间类
 * description String: 对房间的描述
 * exits HashMap: 改房间各个出口的集合
 * goods List: 房间中的货物列表
 * direction int: 方向，0，1，2，3分别代表向东、西、南、北
 * @Author Ducking
 * @DATE 2023/6/15 22:45
 * @Version 1.0
 */
public class Room {
    private int id;
    private String description;
    private HashMap<Integer, Room> exits;        // stores exits of this room.
    private List<Goods> goodsList;

    public Room(String description) {
        this.description = description;
        exits = new HashMap<>();
        goodsList = new ArrayList<>();
    }

    public void setExit(int direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    public Room getExit(int direction) {
        return exits.get(direction);
    }

    public void addGoods(Goods goods) {
        goodsList.add(goods);
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public String getDescription() {
        return description;
    }

    private String getExitString() {
        StringBuilder returnString = new StringBuilder("Exits:");
        Set<Integer> keys = exits.keySet();
        for (int exit : keys) {
            switch (exit) {
                case Direction.EAST -> returnString.append(" east");
                case Direction.WEST -> returnString.append(" west");
                case Direction.SOUTH -> returnString.append(" south");
                case Direction.NORTH -> returnString.append(" north");
            }
        }
        return returnString.toString();
    }

}


