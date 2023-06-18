package cn.edu.whut.sept.zuul;

public class GoCommand extends Command
{
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
//                // 当前房间是传输房间，随机传输到另一个房间
//                ArrayList<Room> availableRooms = currentRoom.getAvailableRooms();
//                int randomIndex = (int) (Math.random() * availableRooms.size());
//                nextRoom = availableRooms.get(randomIndex);
                System.out.println("This is a deliverable room.  Transporting...");

                nextRoom = game.teleportToRandomRoom(nextRoom);
            }
            game.setCurrentRoom(nextRoom);
            System.out.println(nextRoom.getLongDescription());
        }

        return false;
    }
}
