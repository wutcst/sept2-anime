package cn.edu.whut.sept.zuul;

import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;

public class Room
{
    private String description;
    private HashMap<String, Room> exits;        // stores exits of this room.

    private int num;
    private ArrayList<Item> items; // 添加物品列表

    public Room(String description,int num)
    {
        this.description = description;
        this.num = num;
        exits = new HashMap<>();
        items = new ArrayList<>(); // 初始化物品列表
    }

    public void setExit(String direction, Room neighbor)
    {
        exits.put(direction, neighbor);
    }

    public String getShortDescription()
    {
        return description;
    }

    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    public Room getExit(String direction)
    {
        return exits.get(direction);
    }

    //向房间内添加物品
    public void addItem(Item item) {
        items.add(item);
    }
    //移除房间内的物品
    public void removeItem(Item item) {
        items.remove(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }
    
}


