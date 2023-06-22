package com.example.worldofzuul.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.worldofzuul.domain.RoomInfo;
import com.example.worldofzuul.mapper.RoomInfoMapper;
import com.example.worldofzuul.service.RoomInfoService;
import org.springframework.stereotype.Service;

/**
 * @ClassName RoomServiceImpl
 * @Description
 * @Author Ducking
 * @DATE 2023/6/17 17:01
 * @Version 1.0
 */

@Service
public class RoomInfoServiceImpl extends ServiceImpl<RoomInfoMapper, RoomInfo> implements RoomInfoService {
}
