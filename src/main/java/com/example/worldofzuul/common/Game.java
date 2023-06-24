/**
 * 该类是“World-of-Zuul”应用程序的主类。
 * 《World of Zuul》是一款简单的文本冒险游戏。用户可以在一些房间组成的迷宫中探险。
 * 你们可以通过扩展该游戏的功能使它更有趣!.
 * <p>
 * 如果想开始执行这个游戏，用户需要创建Game类的一个实例并调用“play”方法。
 * <p>
 * Game类的实例将创建并初始化所有其他类:它创建所有房间，并将它们连接成迷宫；它创建解析器
 * 接收用户输入，并将用户输入转换成命令后开始运行游戏。
 *
 * @author Michael Kölling and David J. Barnes
 * @version 1.0
 */
package com.example.worldofzuul.common;

import com.baomidou.mybatisplus.extension.api.R;
import com.example.worldofzuul.domain.Room;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Stack;

@Component
public class Game {
    private final Stack<Integer> way;
    private List<Room> roomList;
    private Integer currentRoomId;

    public Game() {
        this.roomList = null;
        this.way = new Stack<>();
    }

    public boolean initCurrentRoomId() {
        if (roomList == null) {
            return false;
        }
        for (Room room : roomList) {
            if (room.getName().equals("gate")) {
                currentRoomId = room.getId();
                return true;
            }
        }
        return false;

    }

    public boolean createRooms() {
        if (roomList == null) {
            return false;
        }
        System.out.println("init the game......");
        for (Room room : roomList) {
            int roomId = room.getId();
            switch (roomId) {
                case 0 -> {
                    room.setExit(Direction.EAST, 1);
                    room.setExit(Direction.SOUTH, 3);
                }
                case 1 -> {
                    room.setExit(Direction.EAST, 2);
                    room.setExit(Direction.WEST, 0);
                    room.setExit(Direction.SOUTH, 4);
                }
                case 2 -> {
                    room.setExit(Direction.WEST, 1);
                    room.setExit(Direction.SOUTH, 5);
                }
                case 3 -> {
                    room.setExit(Direction.EAST, 4);
                    room.setExit(Direction.SOUTH, 6);
                    room.setExit(Direction.NORTH, 0);
                }
                case 4 -> {
                    room.setExit(Direction.EAST, 5);
                    room.setExit(Direction.WEST, 3);
                    room.setExit(Direction.SOUTH, 7);
                    room.setExit(Direction.NORTH, 1);
                }
                case 5 -> {
                    room.setExit(Direction.WEST, 4);
                    room.setExit(Direction.SOUTH, 8);
                    room.setExit(Direction.NORTH, 2);
                    room.setIstransport();
                }
                case 6 -> {
                    room.setExit(Direction.EAST, 7);
                    room.setExit(Direction.NORTH, 3);
                    room.setIstransport();
                }
                case 7 -> {
                    room.setExit(Direction.EAST, 8);
                    room.setExit(Direction.WEST, 6);
                    room.setExit(Direction.NORTH, 4);
                }
                case 8 -> {
                    room.setExit(Direction.WEST, 7);
                    room.setExit(Direction.NORTH, 5);
                }
                default -> {
                    continue;
                }
            }
        }
        return true;
    }

    /**
     * 进入下一个房间
     *
     * @return true/false
     */
    public boolean goNextRoom() {
        if (currentRoomId == null) {
            return false;
        }
        this.way.push(currentRoomId);
        return true;
    }

    /**
     * 返回上一个房间
     *
     * @return 上一个房间的roomId，返回-1则无上一个房间
     */
    public Integer backPreRoom() {
        if (this.way.empty()) {
            return -1;
        }
        return this.way.pop();
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public Room getRoomById(Integer id) {
        for (Room room : roomList) {
            if (room.getId() == id) {
                return room;
            }
        }
        return null;
    }

    public Room getCurrentRoom() {
        for (Room room : roomList) {
            if (room.getId() == this.currentRoomId) {
                return room;
            }
        }
        return null;
    }

    public Integer getCurrentRoomId() {
        return currentRoomId;
    }

    public void setCurrentRoomId(Integer roomId) {
        this.currentRoomId = roomId;
    }

    public boolean checkIsInit() {
        return this.roomList != null && !this.roomList.isEmpty() && this.currentRoomId != null;
    }

    public Room TransportTorandom(Room currentroom){
        List<Room> aviliablerooms  = roomList;
        for(Room room:roomList){
            if(!room.getIstransport())
                aviliablerooms.add(room);
        }
        int randomIndex = (int) (Math.random() * aviliablerooms.size());
        Room nextRoom = aviliablerooms.get(randomIndex);

        // 如果下一个房间是传输房间，则递归调用传输方法
        if (nextRoom.getIstransport()) {
            nextRoom = TransportTorandom(nextRoom);
        }

        return nextRoom;
    }
}