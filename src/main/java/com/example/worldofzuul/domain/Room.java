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
public class Room extends RoomInfo {
    private HashMap<Integer, Integer> exits;        // stores exits of this room.
    private List<Goods> goodsList;
    private boolean istransport;

    public Room() {
        exits = new HashMap<>();
        goodsList = new ArrayList<>();
        istransport = false;
    }

    public Room(RoomInfo roomInfo) {
        this.id = roomInfo.id;
        this.name = roomInfo.name;
        this.description = roomInfo.description;

        exits = new HashMap<>();
        goodsList = new ArrayList<>();
    }

    public void setExit(int direction, int neighborRoomId) {
        exits.put(direction, neighborRoomId);
    }

    /**
     * 获取当前房间某方向上的下一个房间id
     *
     * @param direction 方位
     * @return 返回房间id，若无房间则返回-1
     */
    public Integer getExit(int direction) {
        if (exits.containsKey(direction)) {
            return exits.get(direction);
        }
        return -1;
    }

    public void addGoods(Goods goods) {
        goodsList.add(goods);
    }

    public List<Goods> getGoodsList() {
        return goodsList;
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
    public void setIstransport(){
        istransport = true;
    }
    public boolean getIstransport(){
        return istransport;
    }

}


