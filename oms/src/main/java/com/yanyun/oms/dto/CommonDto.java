package com.yanyun.oms.dto;

import java.util.Date;

public class CommonDto {

    /**
     * 创建时间
     */
    private Date now;

    /**
     * 更新时间
     */
    private Date today;


    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }

    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
    }
}
