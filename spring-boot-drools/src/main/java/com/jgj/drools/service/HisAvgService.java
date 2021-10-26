package com.jgj.drools.service;

import com.jgj.drools.domain.UserInfo;

public interface HisAvgService {

    /**
     * 历史均值计算
     * @param UserInfo
     */
    void calculate(UserInfo UserInfo);
}
