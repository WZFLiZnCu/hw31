package com.hw31;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hw31.pojo.Goods;
import com.hw31.service.BrandService;
import com.hw31.service.ClassifyService;
import com.hw31.service.GoodsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Hw31ApplicationTests {
    @Autowired
    private GoodsService gs;
    @Autowired
    private ClassifyService cs;
    @Autowired
    private BrandService bs;
    @Test
    void contextLoads() {
       List<Goods> list = gs.getGoodsByLike(1,0,"e");
       list.forEach(System.out::println);
    }
    @Test
    void contextLoads2() {
        IPage<Goods> page =gs.getGoods(0,0,null,2,"number",1);



    }
}
