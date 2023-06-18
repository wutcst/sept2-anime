/**
 * 该类是“World-of-Zuul”应用程序的主类。
 * 《World of Zuul》是一款简单的文本冒险游戏。用户可以在一些房间组成的迷宫中探险。
 * 你们可以通过扩展该游戏的功能使它更有趣!.
 *
 * 如果想开始执行这个游戏，用户需要创建Game类的一个实例并调用“play”方法。
 *
 * Game类的实例将创建并初始化所有其他类:它创建所有房间，并将它们连接成迷宫；它创建解析器
 * 接收用户输入，并将用户输入转换成命令后开始运行游戏。
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 1.0
 */
package cn.edu.whut.sept.zuul;

import java.util.ArrayList;

public class Game
{
    private Parser parser;
    private Room currentRoom;

    private ArrayList<Room> rooms = new ArrayList<>();

    public Game()
    {
        createRooms();
        parser = new Parser();
    }

    private void createRooms()
    {
//        Room outside, theater, pub, lab, office;

        Room gate, training, dormitory, lobby, playground, office, classroom, messhall, garden;

        garden = new Room("in the garden",0);
        classroom = new Room("in the classroom",1);
        messhall = new Room("in the mess hall",2);
        office = new Room("in the computing admin office",3);
        lobby = new Room("in the lobby",4);
        playground = new Room("on the playground",5);
        dormitory = new Room("in a dormitory",6);
        gate = new Room("the main entrance of the university",7);
        training = new Room("in the training room",8);

        gate.setExit("east",training);
        gate.setExit("west",dormitory);
        gate.setExit("north",lobby);

        training.setExit("west",gate);
        training.setExit("north",playground);

        dormitory.setExit("east",gate);
        dormitory.setExit("north",office);

        lobby.setExit("east",playground);
        lobby.setExit("west",office);
        lobby.setExit("north",classroom);
        lobby.setExit("south",gate);

        playground.setExit("west",lobby);
        playground.setExit("north",messhall);
        playground.setExit("south",training);

        office.setExit("east",lobby);
        office.setExit("north",garden);
        office.setExit("south",dormitory);

        classroom.setExit("east",messhall);
        classroom.setExit("west",garden);
        classroom.setExit("south",lobby);

        messhall.setExit("west",classroom);
        messhall.setExit("south",playground);

        garden.setExit("east",classroom);
        garden.setExit("south",office);

        currentRoom = gate;

        training.setisTeleportRoom(true);
        dormitory.setisTeleportRoom(true);

        rooms.add(garden);rooms.add(classroom);rooms.add(messhall);rooms.add(office);rooms.add(lobby);
        rooms.add(playground);rooms.add(dormitory);rooms.add(gate);rooms.add(training);

        Item lanqiu, zuqiu, longxi, lizi, mofashu, wujinzhiren, mao, gou, yazi, siwangzhizhua,
                pingguo, jushenzhichui, duolandun, hongshuijing, pobaizhiren, sanxiangzhili;
        wujinzhiren = new Item("无尽之刃",0,1.35);
        siwangzhizhua = new Item("死亡之爪",1,1.485);
        hongshuijing = new Item("红水晶",2,1.6335);
        sanxiangzhili = new Item("三相之力",3,1.79685);
        pobaizhiren = new Item("破败之刃",4,1.976535);
        longxi = new Item("龙息",5,2.174189);
        duolandun = new Item("多兰盾",6,2.391607);
        mao = new Item("猫",7,2.630768);
        gou = new Item("狗",8,2.893845);
        pingguo = new Item("苹果",9,3.183229);
        lizi = new Item("梨子",10,3.501552);
        mofashu = new Item("魔法书",11,3.851708);
        yazi = new Item("鸭子",12,4.2368878);
        jushenzhichui = new Item("巨神之锤",13,4.660566);
        lanqiu = new Item("篮球",14,23.1455);
        zuqiu = new Item("足球",15,453.4);

        training.addItem(lanqiu);
        training.addItem(zuqiu);

        dormitory.addItem(longxi);
        dormitory.addItem(lizi);

        office.addItem(mofashu);
        office.addItem(wujinzhiren);
        office.addItem(mao);

        classroom.addItem(jushenzhichui);
        classroom.addItem(duolandun);
        classroom.addItem(hongshuijing);

        messhall.addItem(pobaizhiren);
        messhall.addItem(sanxiangzhili);

        garden.addItem(gou);
        garden.addItem(pingguo);


        // create the rooms
//        outside = new Room("outside the main entrance of the university");
//        theater = new Room("in a lecture theater");
//        pub = new Room("in the campus pub");
//        lab = new Room("in a computing lab");
//        office = new Room("in the computing admin office");

        // initialise room exits
//        outside.setExit("east", theater);
//        outside.setExit("south", lab);
//        outside.setExit("west", pub);
//
//        theater.setExit("west", outside);
//
//        pub.setExit("east", outside);
//
//        lab.setExit("north", outside);
//        lab.setExit("east", office);
//
//        office.setExit("west", lab);

//        currentRoom = outside;  // start game outside
    }

    //向房间中添加物品
    public void addItemToRoom(Item item, Room room) {
        room.addItem(item);
    }

    public void play()
    {
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            if(command == null) {
                System.out.println("I don't understand...");
            } else {
                finished = command.execute(this);
            }
        }

        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room){
        this.currentRoom = room;
    }

    public ArrayList<Room> getRooms(){
        return this.rooms;
    }

    public Room teleportToRandomRoom(Room currentRoom) {
        // 当前房间是传输房间，随机传输到另一个房间
        ArrayList<Room> availableRooms = new ArrayList<>();
        for(Room room:rooms){
            if(!room.IsTeleportRoom())
                availableRooms.add(room);
        }
        int randomIndex = (int) (Math.random() * availableRooms.size());
        Room nextRoom = availableRooms.get(randomIndex);

        // 如果下一个房间是传输房间，则递归调用传输方法
        if (nextRoom.IsTeleportRoom()) {
            nextRoom = teleportToRandomRoom(nextRoom);
        }

        return nextRoom;
    }

}