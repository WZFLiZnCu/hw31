package com.hw31.service.impl;

import com.hw31.mapper.ClassifyMapper;
import com.hw31.pojo.Classify;
import com.hw31.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassifyServiceImpl implements ClassifyService {
    @Autowired
    private ClassifyMapper cm;
    @Override
    public List<Classify> getallc() {
        return cm.selectList(null);
    }
}
