package com.example.worldofzuul.service.impl;

import com.example.worldofzuul.service.MoveService;
import org.springframework.stereotype.Service;

/**
 * @ClassName GoServiceImpl
 * @Description TODO
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
    public boolean goSouth() {
        return false;
    }

    @Override
    public boolean goWest() {
        return false;
    }

    @Override
    public boolean goNorth() {
        return false;
    }
}
