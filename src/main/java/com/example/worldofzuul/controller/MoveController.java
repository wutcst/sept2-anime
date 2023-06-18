package com.example.worldofzuul.controller;

import com.example.worldofzuul.common.Game;
import com.example.worldofzuul.common.Params;
import com.example.worldofzuul.common.Result;
import com.example.worldofzuul.domain.Room;
import com.example.worldofzuul.service.MoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName CommandConreoller
 * @Description 移动相关控制器
 * @Author Ducking
 * @DATE 2023/6/15 20:43
 * @Version 1.0
 */

@RestController
@RequestMapping("/move")
public class MoveController {
    @Autowired
    private MoveService moveService;
    @Autowired
    private Game game;

    @PostMapping
    public Result move(@RequestBody Params params) {
        // 1、获取参数
        int type = params.getType();

        // 2、判断游戏是否初始化
        if (!game.checkIsInit()) {
            return new Result(false, "游戏未初始化");
        }

        // 3、获取下一个房间的roomId
        Room currentRoom = game.getCurrentRoom();
        int nextRoomId = currentRoom.getExit(type);
        if (nextRoomId == -1) {
            return new Result(false, "该方向上无房间");
        }

        // 4、移动
        if (!game.goNextRoom()) {
            return new Result(false, "移动失败");
        }
        game.setCurrentRoomId(nextRoomId);
        return new Result(true, "移动成功", nextRoomId);
    }

    @GetMapping
    public Result back() {
        // 判断游戏是否初始化
        if (!game.checkIsInit()) {
            return new Result(false, "游戏未初始化");
        }

        // 获取上一个房间的id
        int preRoomId = game.backPreRoom();
        if (preRoomId == -1) {
            return new Result(false, "已返回至起点");
        }
        game.setCurrentRoomId(preRoomId);
        return new Result(true, "成功", preRoomId);

    }
}
