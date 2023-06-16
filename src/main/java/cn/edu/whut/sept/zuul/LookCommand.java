package cn.edu.whut.sept.zuul;

import java.util.ArrayList;

public class LookCommand extends Command {
    public boolean execute(Game game) {
        Room currentRoom = game.getCurrentRoom();

        // 输出当前房间的描述
        System.out.println(currentRoom.getLongDescription());

        // 输出房间内的物品信息
        ArrayList<Item> items = currentRoom.getItems();
        if (items.size() > 0) {
            System.out.println("Items in the room:");
            for (Item item : items) {
                System.out.println("- " + item.getName() + " (Number: "+item.getNumber() + " Weight: " + item.getWeight() + ")");
            }
        } else {
            System.out.println("There are no items in the room.");
        }

        return false;
    }
}
