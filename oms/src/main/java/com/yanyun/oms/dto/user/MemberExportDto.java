package com.yanyun.oms.dto.user;


import com.yanyun.oms.entity.member.Member;

public class MemberExportDto extends Member {
    private String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
