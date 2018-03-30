package com.yanyun.oms.enums;

public enum DeviceKeyStatusEnum {

    noUsered(0, "未使用"),
    usered(1, "已使用")
    ;
    public Integer value;
    public String name;

    DeviceKeyStatusEnum(Integer value, String name) {
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
