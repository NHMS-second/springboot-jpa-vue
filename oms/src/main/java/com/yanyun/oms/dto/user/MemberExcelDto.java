package com.yanyun.oms.dto.user;

import com.yanyun.oms.entity.ExcelColumn;
import com.yanyun.oms.entity.member.Member;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.math.BigDecimal;
import java.util.Date;

public class MemberExcelDto {

    @ExcelColumn(colName = "手机号")
    private String mobile;
    @ExcelColumn(colName = "邮箱")
    private String email;
    @ExcelColumn(colName = "状态")
    private String statusStr;
    @ExcelColumn(colName = "国家")
    private String country;
    @ExcelColumn(colName = "语言")
    private String language;
    @ExcelColumn(colName = "昵称")
    private String nickname;
    @ExcelColumn(colName = "注册方式")
    private String  fromStr;
    @ExcelColumn(colName = "创建时间")
    private Date createdTime;

    public MemberExcelDto(Member order) {
        this.mobile = order.getMobile();
        this.email = order.getEmail();
        this.statusStr = order.getStatusStr();
        this.country = order.getCountry();
        this.language = order.getLanguage();
        this.nickname = order.getNickname();
        this.fromStr = order.getFromStr();
        this.createdTime = order.getCreatedTime();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFromStr() {
        return fromStr;
    }

    public void setFromStr(String fromStr) {
        this.fromStr = fromStr;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}
