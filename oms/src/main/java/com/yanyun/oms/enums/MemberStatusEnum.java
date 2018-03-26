package com.yanyun.oms.enums;

public enum MemberStatusEnum {


    INVALID(-2, "封号"), LIMIT(-1, "24小时限制"), VALID(0, "正常")
    ;
    public Integer value;
    public String name;

    MemberStatusEnum(Integer value, String name) {
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
