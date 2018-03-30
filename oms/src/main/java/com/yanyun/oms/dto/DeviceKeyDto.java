package com.yanyun.oms.dto;

import com.yanyun.oms.entity.device.Device;
import com.yanyun.oms.entity.deviceKey.DeviceKey;

import java.io.Serializable;
import java.util.List;

/**
 * 问卷调查问题
 */
public class DeviceKeyDto extends DeviceKey implements Serializable{

    private Device device;

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
}
