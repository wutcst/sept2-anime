package com.example.worldofzull;

import cn.edu.whut.sept.zuul.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GameTest {
    private Game game;
    private Room room;

    @Before
    public void setUp() throws Exception {
        game = new Game();
        room = new Room("Test Room", 0);
        game.setCurrentRoom(room);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addItemToRoom() {
        // 创建物品
        Item item1 = new Item("Book", 0, 0.5);
        Item item2 = new Item("Key", 1, 0.1);

        // 将物品添加到房间中
        game.addItemToRoom(item1, room);
        game.addItemToRoom(item2, room);

        // 获取房间内的物品列表
        ArrayList<Item> items = room.getItems();

        // 验证物品数量和属性
        assertEquals(2, items.size());

        Item addedItem1 = items.get(0);
        assertEquals("Book", addedItem1.getName());
        assertEquals(0, addedItem1.getNumber(), 0);
        assertEquals(0.5, addedItem1.getWeight(), 0.01);

        Item addedItem2 = items.get(1);
        assertEquals("Key", addedItem2.getName());
        assertEquals(1, addedItem2.getNumber(), 0);
        assertEquals(0.1, addedItem2.getWeight(), 0.01);
    }
    @Test
    public void testLookCommand() {
        // 创建物品
        Item item1 = new Item("Book", 0, 0.5);
        Item item2 = new Item("Key", 1, 0.1);

        // 将物品添加到房间中
        game.addItemToRoom(item1, room);
        game.addItemToRoom(item2, room);

        // 执行 "look" 命令
        Command lookCommand = new LookCommand();
        lookCommand.execute(game);
    }
    @Test
    public void testTeleportRoom() {
        // 获取传输房间
        Room trainingRoom = game.getRooms().get(8);
        Room dormitoryRoom = game.getRooms().get(6);

        assertNotNull(trainingRoom);
        assertNotNull(dormitoryRoom);

        // 测试进入传输房间后是否会随机传输到其他房间
        ArrayList<Room> teleportRooms = new ArrayList<>();
        teleportRooms.add(trainingRoom);
        teleportRooms.add(dormitoryRoom);

        for (Room room : teleportRooms) {
            Room nextRoom = game.teleportToRandomRoom(room);
            assertNotNull(nextRoom);
            assertFalse(nextRoom.IsTeleportRoom());
        }
    }
}