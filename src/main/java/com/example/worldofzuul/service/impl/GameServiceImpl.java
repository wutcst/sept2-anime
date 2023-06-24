package com.example.worldofzuul.service.impl;

import com.example.worldofzuul.common.Game;
import com.example.worldofzuul.domain.Room;
import com.example.worldofzuul.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName GameServiceImpl
 * @Description TODO
 * @Author Ducking
 * @DATE 2023/6/18 14:37
 * @Version 1.0
 */
@Service
public class GameServiceImpl implements GameService {
    @Autowired
    private Game game;

    @Override
    public Game initGame(List<Room> roomList) {
        // 游戏初始化
        game.setRoomList(roomList);
        if (game.createRooms() && game.initCurrentRoomId()) {
            System.out.println("game init success...");
        } else {
            System.out.println("Game init fail...");
        }

        System.out.println("Game: " + game);
        System.out.println("this.currentRoomId: " + game.getCurrentRoomId());
        return game;
    }
}
