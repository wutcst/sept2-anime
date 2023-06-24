package com.example.worldofzuul.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.worldofzuul.domain.Goods;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName GoodsMapper
 * @Description TODO
 * @Author Ducking
 * @DATE 2023/6/17 17:21
 * @Version 1.0
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {
}
