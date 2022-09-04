package com.hw31.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hw31.mapper.BrandMapper;
import com.hw31.mapper.ClassifyMapper;
import com.hw31.mapper.GoodsMapper;
import com.hw31.pojo.Goods;
import com.hw31.pojo.MyPage;
import com.hw31.service.GoodsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper gm;
    @Autowired
    private BrandMapper bm;
    @Autowired
    private ClassifyMapper cm;

    @Override
    public List<Goods> getAll() {
        return gm.getAllGoods();
    }

    @Override
    public Goods getOneByGid(Integer gid) {
        return gm.selectById(gid);
    }

    @Override
    public List<Goods> getGoodsByLike(@Param("wbid") Integer wbid, @Param("wcid") Integer wcid, @Param("what") String what) {
        QueryWrapper qw = new QueryWrapper();
        if (wbid != 0) {
            String mwbid = String.valueOf(wbid);
            qw.eq("bid", mwbid);
        }
        if (wcid != 0) {
            String mwcid = String.valueOf(wcid);
            qw.eq("cid", mwcid);
        }
        qw.like("gname", what);
        qw.or();
        qw.like("number", what);
        return gm.selectList(qw);
    }

    @Override
    public int saveGoods(Goods goods) {
        if (gm.selectById(goods.getGid()) == null) {
            return gm.insert(goods);
        } else {
            return 0;
        }

    }

    @Override
    public int delGoods(Integer gid) {
        return gm.deleteById(gid);
    }

    @Override
    public int updateGoods(Goods goods) {
        return gm.updateById(goods);
    }

    @Override
    public IPage<Goods> getAllByPage(Integer pageno) {
        int no = pageno != null ? pageno : 1;
        IPage<Goods> iPage = new Page<>(no, 5);
        IPage<Goods> info = gm.selectPage(iPage, null);
        List<Goods> list = info.getRecords();
        for (Goods g : list) {
            g.setBrand(bm.selectById(g.getBid()));
            g.setClassify(cm.selectById(g.getCid()));
        }
        return info;
    }

    @Override
    public MyPage<Goods> getAllGoodsByPage(Integer pageno, Integer pagesize) {
        int pno = pageno != null ? pageno : 1;
        int psize = pagesize != null ? pagesize : 10;
        MyPage<Goods> mypage = new MyPage<>();
        mypage.setCurrent(pno);
        mypage.setSize(psize);
        mypage.setTotal(gm.selectCount(null));
        List<Goods> list = gm.getAllGoodsByPage((pno - 1) * psize, psize);
        mypage.setList(list);
        return mypage;

    }

    @Override
    public IPage<Goods> getGoods(@Param("cid")int cid,@Param("bid") int bid,@Param("keyword") String keyword,@Param("pageno") Integer pageno,@Param("ordercol") String ordercol,@Param("order")int order) {
        QueryWrapper<Goods> qw = new QueryWrapper<>();
        if (cid != 0) {
            qw.eq("cid", cid);
        }
        if (bid != 0) {
            qw.eq("bid", bid);
        }
        if (keyword != null) {
            qw.or(wrapper -> wrapper.like("gname", keyword)
                    .or()
                    .like("number", keyword)
            );
        }
        if(ordercol !=null){
            if(order == 0){
                qw.orderByAsc(ordercol);
            }else {
                qw.orderByDesc(ordercol);
            }
        }
        int pno = pageno ==null ? 1:pageno;
        IPage<Goods> page = new Page<>(pno,5);
        return  gm.selectPage(page,qw);

    }

    @Override
    public IPage<Goods> getGoods2(int cid, int bid, String keyword, Integer pageno, String ordercol, int order) {
    QueryWrapper<Goods> qw = new QueryWrapper();
    if(bid!=0){
        qw.eq("bid",bid);
    }
    if(cid!=0){
        qw.eq("cid",cid);
    }
    if(keyword != null){
       qw.and(w->w.like("gname",keyword)
               .or()
               .like("number",keyword)
        );
    }
    int pno = pageno !=null ? pageno : 1 ;
    if(ordercol!=null){
        if(order==0){
            qw.orderByAsc(ordercol);
        }else {
            qw.orderByDesc(ordercol);
        }
    }
    IPage<Goods> page = new Page<>(pno,7);
        return gm.selectPage(page,qw);
    }

}
