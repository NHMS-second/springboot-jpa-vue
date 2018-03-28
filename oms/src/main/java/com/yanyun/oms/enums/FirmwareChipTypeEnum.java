package com.yanyun.oms.enums;

public enum FirmwareChipTypeEnum {


    muc(1, "muc"),
    dsp(2, "dsp")
    ;
    public Integer value;
    public String name;

    FirmwareChipTypeEnum(Integer value, String name) {
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
