package com.example.worldofzuul.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.worldofzuul.common.Game;
import com.example.worldofzuul.common.Result;
import com.example.worldofzuul.domain.Goods;
import com.example.worldofzuul.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName BagController
 * @Description 货物相关请求控制器
 * @Author Ducking
 * @DATE 2023/6/18 16:38
 * @Version 1.0
 */
@RestController
@RequestMapping("/bag")
public class BagController {
    @Autowired
    private Game game;
    @Autowired
    private GoodsMapper goodsMapper;

    @GetMapping("/look")
    public Result look() {
        // 判断游戏是否初始化
        if (!game.checkIsInit()) {
            return new Result(false, "游戏未初始化");
        }

        // 1、获取当前房间的id
        Integer currentRoomId = game.getCurrentRoomId();

        // 2、查找当前房间的物品
        LambdaQueryWrapper<Goods> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Goods::getRoomId, currentRoomId);
        List<Goods> goodsList = goodsMapper.selectList(lqw);

        if (goodsList == null) {
            return new Result(false);
        }
        return new Result(true, "成功", goodsList);
    }
}
