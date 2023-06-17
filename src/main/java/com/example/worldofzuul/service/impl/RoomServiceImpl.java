package com.example.worldofzuul.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.worldofzuul.domain.Room;
import com.example.worldofzuul.mapper.RoomMapper;
import com.example.worldofzuul.service.RoomService;
import org.springframework.stereotype.Service;

/**
 * @ClassName RoomServiceImpl
 * @Description
 * @Author Ducking
 * @DATE 2023/6/17 17:01
 * @Version 1.0
 */

@Service
public class RoomServiceImpl extends ServiceImpl<RoomMapper, Room> implements RoomService {
}
