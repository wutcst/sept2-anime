package cn.edu.whut.sept.zuul;

import java.util.ArrayList;

/**
 * LookCommand类表示游戏中查看当前房间的命令。
 * 它显示当前房间的描述和房间内的物品。
 */
public class LookCommand extends Command {
    /**
     * 执行查看命令，显示当前房间的描述和房间内的物品。
     *
     * @param game 表示当前游戏状态的游戏对象。
     * @return false，表示命令执行不会结束游戏。
     */
    public boolean execute(Game game) {
        Room currentRoom = game.getCurrentRoom();

        /*
          输出当前房间的描述
         */
        System.out.println(currentRoom.getLongDescription());

        /*
          输出房间内的物品信息
         */
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
