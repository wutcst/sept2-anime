package com.example.worldofzuul.service;

import com.example.worldofzuul.common.Game;
import com.example.worldofzuul.domain.Room;

import java.util.List;

/**
 * @ClassName GameService
 * @Description TODO
 * @Author Ducking
 * @DATE 2023/6/18 14:37
 * @Version 1.0
 */
public interface GameService {
    public Game initGame(List<Room> rooms);
}
