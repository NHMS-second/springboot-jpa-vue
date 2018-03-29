package com.yanyun.oms.enums;

public enum MessageTypeEnEnum {


    system(1, "system"),
    personal(2, "personal")
    ;
    public Integer value;
    public String name;

    MessageTypeEnEnum(Integer value, String name) {
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
