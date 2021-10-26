package com.jgj.drools.service.impl;

import com.jgj.drools.domain.UserInfo;
import com.jgj.drools.service.HisAvgService;
import org.springframework.stereotype.Service;

@Service
public class HisAvgRule02ServiceImpl implements HisAvgService {
    @Override
    public void calculate(UserInfo UserInfo) {
        System.out.println("获取历史均值规则02生效。。。");
    }
}
