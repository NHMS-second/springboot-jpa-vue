package com.yanyun.oms.enums;

public enum MessageTypeZhEnum {


    system(1, "系统消息"),
    personal(2, "个人消息")
    ;
    public Integer value;
    public String name;

    MessageTypeZhEnum(Integer value, String name) {
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
