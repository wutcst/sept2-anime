package com.example.worldofzuul.controller;

import com.example.worldofzuul.common.Game;
import com.example.worldofzuul.common.Result;
import com.example.worldofzuul.domain.Room;
import com.example.worldofzuul.domain.RoomInfo;
import com.example.worldofzuul.service.GameService;
import com.example.worldofzuul.service.RoomInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName GameController
 * @Description 游戏初始化控制器
 * @Author Ducking
 * @DATE 2023/6/18 14:41
 * @Version 1.0
 */
@RestController
@RequestMapping("/initGame")
public class GameController {
    @Autowired
    private GameService gameService;
    @Autowired
    private RoomInfoService roomInfoService;

    @GetMapping
    public Result initGame() {
        // 1、从数据库查询房间信息
        List<RoomInfo> roomInfoList = roomInfoService.list();
        if (roomInfoList == null) {
            return new Result(false, "房间信息查询失败");
        }

        // 2、构造房间列表
        List<Room> roomList = new ArrayList<>();
        for (RoomInfo roomInfo : roomInfoList) {
            roomList.add(new Room(roomInfo));
        }

        // 3、初始化游戏
        Game game = gameService.initGame(roomList);
        return new Result(true);
    }
}
