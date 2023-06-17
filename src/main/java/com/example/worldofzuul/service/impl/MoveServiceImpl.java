package com.example.worldofzuul.service.impl;

import com.example.worldofzuul.service.MoveService;
import org.springframework.stereotype.Service;

/**
 * @ClassName GoServiceImpl
 * @Description 移动服务实现类
 * goEast(): 向东移动
 * goWest(): 向西移动
 * goSouth(): 向南移动
 * goNorth(): 向北移动
 * back(): 返回上一个房间
 * @Author Ducking
 * @DATE 2023/6/15 21:01
 * @Version 1.0
 */
@Service
public class MoveServiceImpl implements MoveService {

    @Override
    public boolean goEast() {
        return false;
    }

    @Override
    public boolean goWest() {
        return false;
    }

    @Override
    public boolean goSouth() {
        return false;
    }

    @Override
    public boolean goNorth() {
        return false;
    }

    @Override
    public boolean back() {
        return false;
    }


}
