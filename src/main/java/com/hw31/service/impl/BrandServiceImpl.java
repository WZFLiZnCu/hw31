package com.hw31.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hw31.mapper.BrandMapper;
import com.hw31.pojo.Brand;
import com.hw31.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper bm;
    @Override
    public List<Brand> getallb(Integer classid) {
        QueryWrapper<Brand> qw = new QueryWrapper<>();
        if(classid != null && classid !=0){
            qw.eq("classid",classid);
        }
        return bm.selectList(qw);
    }
}
