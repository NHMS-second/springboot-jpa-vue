package com.yanyun.oms.dto;

import com.yanyun.oms.entity.device.Device;
import com.yanyun.oms.entity.member.Member;

public class DeviceDto extends Device{

    private Member member;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
