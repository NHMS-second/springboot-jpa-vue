package com.yanyun.oms.enums;

public enum MemberFromEnEnum {

    message(1, "message"),
    phone(2, "phone"),
    wechat(3, "wechat"),
    qq(4, "qq"),
    email(5, "email"),
    facebook(6, "Facebook"),
    google(7, "Google")
    ;
    public Integer value;
    public String name;

    MemberFromEnEnum(Integer value, String name) {
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
