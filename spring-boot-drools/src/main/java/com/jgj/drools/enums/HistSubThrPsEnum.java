package com.jgj.drools.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HistSubThrPsEnum {
    ITEM01("ITEM01", "ITEM01"),
    ITEM02("ITEM02", "ITEM02"),
    ;

    private String code;

    private String desc;
}
