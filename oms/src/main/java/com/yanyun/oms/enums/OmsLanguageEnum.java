package com.yanyun.oms.enums;

public enum OmsLanguageEnum {


    en(1, "en"), cn(2, "cn")
    ;
    public Integer value;
    public String name;

    OmsLanguageEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
