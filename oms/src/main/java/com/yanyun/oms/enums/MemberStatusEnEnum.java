package com.yanyun.oms.enums;

public enum MemberStatusEnEnum {


    INVALID(-2, "invalid"), LIMIT(-1, "limit for 24 hours"), VALID(0, "valid")
    ;
    public Integer value;
    public String name;

    MemberStatusEnEnum(Integer value, String name) {
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
