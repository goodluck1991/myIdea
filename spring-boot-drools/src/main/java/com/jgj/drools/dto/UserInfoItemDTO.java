package com.jgj.drools.dto;

import com.jgj.drools.domain.UserInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

@Data
public class UserInfoItemDTO implements Serializable {

    /**
     * 人员信息
     */
    private UserInfo userInfo;

    /**
     * 需要计算历史均值的三级科目
     */
    private Set<String> histSubThrPsEnums;

    /**
     * 三级科目计算服务映射关系
     */
    private Map<String, Set<Long>> serviceIdMap;

}
