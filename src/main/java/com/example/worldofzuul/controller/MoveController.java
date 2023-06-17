package com.example.worldofzuul.controller;

import com.example.worldofzuul.common.Params;
import com.example.worldofzuul.service.Game;
import com.example.worldofzuul.service.MoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName CommandConreoller
 * @Description 移动控制
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
    public String move(@RequestBody Params params) {
        Integer room = params.getRoom();
        Integer type = params.getType();


        System.out.println(params);
        return "move";
    }
}
