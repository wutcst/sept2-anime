package cn.edu.whut.sept.zuul;

/**
 * GoCommand类表示游戏中的前进命令。
 * 它允许玩家在游戏中移动到相邻的房间。
 */
public class GoCommand extends Command
{
    /**
     * 执行前进命令，将玩家移动到指定方向的相邻房间。
     *
     * @param game 表示当前游戏状态的游戏对象。
     * @return false，表示命令执行不会结束游戏。
     */
    public boolean execute(Game game)
    {
        if(!hasSecondWord()) {
            System.out.println("Go where?");
        }

        String direction = getSecondWord();
        Room currentRoom = game.getCurrentRoom();
        Room nextRoom = game.getCurrentRoom().getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            if (nextRoom.IsTeleportRoom()) {
                 /*
                    当前房间是传输房间，随机传输到另一个房间
                  */
                System.out.println("This is a deliverable room.  Transporting...");

                nextRoom = game.teleportToRandomRoom(nextRoom);
            }
            game.setCurrentRoom(nextRoom);
            System.out.println(nextRoom.getLongDescription());
        }

        return false;
    }
}
