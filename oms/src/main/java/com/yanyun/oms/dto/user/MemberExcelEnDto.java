package com.yanyun.oms.dto.user;

import com.yanyun.oms.entity.ExcelColumn;
import com.yanyun.oms.entity.member.Member;
import com.yanyun.oms.enums.MemberFromEnEnum;
import com.yanyun.oms.enums.MemberStatusEnEnum;

import java.util.Date;

public class MemberExcelEnDto {

    @ExcelColumn(colName = "mobile")
    private String mobile;
    @ExcelColumn(colName = "email")
    private String email;
    @ExcelColumn(colName = "status")
    private String statusStr;
    @ExcelColumn(colName = "country")
    private String country;
    @ExcelColumn(colName = "language")
    private String language;
    @ExcelColumn(colName = "nickname")
    private String nickname;
    @ExcelColumn(colName = "from")
    private String  fromStr;
    @ExcelColumn(colName = "createdTime")
    private Date createdTime;

    public MemberExcelEnDto(Member member) {
        this.mobile = member.getMobile();
        this.email = member.getEmail();
        if(member.getStatus() == null){
            this.statusStr = "";
        }else{
            if(member.getStatus() == MemberStatusEnEnum.INVALID.value.intValue()){
                this.statusStr = MemberStatusEnEnum.INVALID.name;
            }else if(member.getStatus() == MemberStatusEnEnum.LIMIT.value.intValue()){
                this.statusStr = MemberStatusEnEnum.LIMIT.name;
            }else if(member.getStatus() == MemberStatusEnEnum.VALID.value.intValue()){
                this.statusStr = MemberStatusEnEnum.VALID.name;
            }else{
                this.statusStr = "";
            }
        }

        if(member.getFrom() == null){
            this.fromStr = "";
        }else{
            if(member.getFrom() == MemberFromEnEnum.message.value.intValue()){
                this.fromStr = MemberFromEnEnum.message.name;
            }else if(member.getFrom() == MemberFromEnEnum.phone.value.intValue()){
                this.fromStr = MemberFromEnEnum.phone.name;
            }else if(member.getFrom() == MemberFromEnEnum.wechat.value.intValue()){
                this.fromStr = MemberFromEnEnum.wechat.name;
            }else if(member.getFrom() == MemberFromEnEnum.qq.value.intValue()){
                this.fromStr = MemberFromEnEnum.qq.name;
            }else if(member.getFrom() == MemberFromEnEnum.email.value.intValue()){
                this.fromStr = MemberFromEnEnum.email.name;
            }else if(member.getFrom() == MemberFromEnEnum.facebook.value.intValue()){
                this.fromStr = MemberFromEnEnum.facebook.name;
            }else if(member.getFrom() == MemberFromEnEnum.google.value.intValue()){
                this.fromStr = MemberFromEnEnum.google.name;
            }else{
                this.fromStr = "";
            }
        }
        this.country = member.getCountry();
        this.language = member.getLanguage();
        this.nickname = member.getNickname();
        this.createdTime = member.getCreatedTime();
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
