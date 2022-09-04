package com.hw31.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hw31.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {

    public List<Goods> getAllGoods();
    public List<Goods> getAllGoodsByPage(@Param("index")int startIndex, @Param("count")int count);
}
