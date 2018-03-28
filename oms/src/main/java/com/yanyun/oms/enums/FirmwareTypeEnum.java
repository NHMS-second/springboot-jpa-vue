package com.yanyun.oms.enums;

public enum FirmwareTypeEnum {


    noForce(0, "不强制"),
    force(1, "强制")
    ;
    public Integer value;
    public String name;

    FirmwareTypeEnum(Integer value, String name) {
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
