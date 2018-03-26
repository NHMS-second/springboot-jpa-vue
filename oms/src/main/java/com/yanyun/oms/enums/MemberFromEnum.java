package com.yanyun.oms.enums;

public enum MemberFromEnum {

    message(1, "手机短信"),
    phone(2, "手机注册"),
    wechat(3, "微信"),
    qq(4, "QQ"),
    email(5, "邮箱"),
    facebook(6, "Facebook"),
    google(7, "Google")
    ;
    public Integer value;
    public String name;

    MemberFromEnum(Integer value, String name) {
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
