package com.jgj.drools.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CostItemSumDTO {
    /**
     * 业务主键
     */
    private String bizId;

    /**
     * 业务日期
     */
    private String bizDay;

    /**
     * 业务类型
     */
    private String bizType;

    /**
     * 人资机构编码
     */
    private String psCode;

    /**
     * 人资机构编码全路径
     */
    private String fullPsCode;

    /**
     * 用工性质
     */
    private String Nature;

    /**
     * 职级编码
     */
    private String levelCode;

    /**
     * 岗位名称
     */
    private String positionCode;

    /**
     * 岗位编码
     */
    private String positionName;

    /**
     * 结算主体编码
     */
    private String settleCompanyCode;

    /**
     * 计算版本号
     */
    private String calculateVersion;

    /**
     * 成本项编码
     */
    private String itemCode;

    /**
     * 成本项金额
     */
    private BigDecimal itemSum;
}
