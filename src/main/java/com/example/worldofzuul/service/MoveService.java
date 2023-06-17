package com.example.worldofzuul.service;

/**
 * @ClassName GoService
 * @Description 移动服务接口
 * @Author Ducking
 * @DATE 2023/6/15 20:56
 * @Version 1.0
 */
public interface MoveService {

    public boolean goEast();

    public boolean goSouth();

    public boolean goWest();

    public boolean goNorth();

    public boolean back();

}
