package com.example.worldofzuul.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.worldofzuul.domain.Goods;
import com.example.worldofzuul.mapper.GoodsMapper;
import com.example.worldofzuul.service.GoodsService;
import org.springframework.stereotype.Service;

/**
 * @ClassName GoodsServiceImpl
 * @Description
 * @Author Ducking
 * @DATE 2023/6/17 17:07
 * @Version 1.0
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
}
