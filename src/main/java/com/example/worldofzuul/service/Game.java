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
package com.example.worldofzuul.service;

import com.example.worldofzuul.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Stack;

@Service
public class Game {
    private Room currentRoom;
    private Stack<Integer> way;

    @Autowired
    private RoomService roomService;

    public Game() {
        createRooms();
        way = new Stack<>();
    }

    private void createRooms() {

/*        Room outside, theater, pub, lab, office;

        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");

        // initialise room exits
        outside.setExit(Direction.EAST, theater);
        outside.setExit(Direction.SOUTH, lab);
        outside.setExit(Direction.WEST, pub);

        theater.setExit(Direction.WEST, outside);

        pub.setExit(Direction.EAST, outside);

        lab.setExit(Direction.NORTH, outside);
        lab.setExit(Direction.EAST, office);

        office.setExit(Direction.WEST, lab);

        currentRoom = outside;  // start game outside*/
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }
}