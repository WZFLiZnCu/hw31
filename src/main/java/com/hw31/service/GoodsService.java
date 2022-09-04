package com.hw31.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hw31.pojo.Goods;
import com.hw31.pojo.MyPage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsService {
        public List<Goods> getAll();
        public Goods getOneByGid(Integer gid);
        public List<Goods> getGoodsByLike(@Param("wbid")Integer wbid,@Param("wcid") Integer wcid,@Param("what") String what);
        public int saveGoods(Goods goods);
        public int delGoods(Integer gid);
        public int updateGoods(Goods goods);
        public IPage<Goods> getAllByPage(Integer pageno);
        public MyPage<Goods> getAllGoodsByPage(Integer pageno, Integer pagesize);
        public IPage<Goods> getGoods(@Param("cid") int cid,@Param("bid")int bid,@Param("keyword")String keyword,@Param("pageno")Integer pageno,@Param("ordercol")String ordercol,@Param("order")int order);
        public IPage<Goods> getGoods2(@Param("cid") int cid,@Param("bid") int bid, @Param("keyword") String keyword,@Param("pageno")Integer pageno,@Param("ordercol")String ordercol,@Param("order")int order);
}
