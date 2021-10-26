package com.jgj.drools.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HistSubEnum {
    item01("01", "01"),
    item02("02", "02"),
    ;

    private String code;
    private String desc;
}
