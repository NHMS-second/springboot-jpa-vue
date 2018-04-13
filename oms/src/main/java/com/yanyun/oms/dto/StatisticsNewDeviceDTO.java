package com.yanyun.oms.dto;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;
import java.util.LinkedHashMap;

/**
 * 每日新增设备数量
 */
public class StatisticsNewDeviceDTO {
    private Date date;
    private Integer deviceNum;

    public Integer getDeviceNum() {
        return deviceNum;
    }

    public void setDeviceNum(Integer deviceNum) {
        this.deviceNum = deviceNum;
    }

    public String getDate() {
        return DateFormatUtils.format(date,"MM-dd");
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
