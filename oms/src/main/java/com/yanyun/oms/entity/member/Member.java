package com.yanyun.oms.entity.member;

import com.yanyun.oms.enums.MemberFromEnum;
import com.yanyun.oms.enums.MemberStatusEnum;

import java.io.Serializable;
import java.util.Date;

/**
 * Entity - 会员
 *
 * @author Demon
 * @since 2018-03-26
 */
public class Member implements Serializable {


    /**
     * 
     */
    private Integer id;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码
     */
    private String password;

    /**
     * 密码盐
     */
    private String salt;

    /**
     * 第三方登录ID
     */
    private String authId;

    /**
     * 用户状态
     *
     * @see com.ydd.framework.core.entity.enums.StatusEnum
     */
    private Integer status;


    private String statusStr;

    /**
     * 
     */
    private String country;

    /**
     * 
     */
    private String language;

    /**
     * 
     */
    private String avatar;

    /**
     * 
     */
    private String nickname;

    /**
     * 别名ID
     */
    private String aliasId;

    /**
     * 指纹
     */
    private String fingerprint;

    /**
     * 注册方式
     */
    private Integer from;

    private String fromStr;

    /**
     * 设备登录密码
     */
    private String devicePwd;

    /**
     * 创建者编号
     */
    private Integer createdId;

    /**
     * 更新者编号
     */
    private Integer modifiedId;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date modifiedTime;

    /**
     * 删除标识位
     *
     * @see com.ydd.framework.core.entity.enums.DeletedEnum
     */
    private Integer deleted;


    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public String getFromStr() {
        return fromStr;
    }

    public void setFromStr(String fromStr) {
        this.fromStr = fromStr;
    }

    /**
     * 设置
     *
     * @param id 
     */
    public void setId(Integer id){
        this.id = id;
    }

    /**
     * 获取
     *
     * @return 
     */
    public Integer getId(){
        return id;
    }


    /**
     * 设置手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile){
        this.mobile = mobile;
    }

    /**
     * 获取手机号
     *
     * @return 手机号
     */
    public String getMobile(){
        return mobile;
    }


    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email){
        this.email = email;
    }

    /**
     * 获取邮箱
     *
     * @return 邮箱
     */
    public String getEmail(){
        return email;
    }


    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password){
        this.password = password;
    }

    /**
     * 获取密码
     *
     * @return 密码
     */
    public String getPassword(){
        return password;
    }


    /**
     * 设置密码盐
     *
     * @param salt 密码盐
     */
    public void setSalt(String salt){
        this.salt = salt;
    }

    /**
     * 获取密码盐
     *
     * @return 密码盐
     */
    public String getSalt(){
        return salt;
    }


    /**
     * 设置第三方登录ID
     *
     * @param authId 第三方登录ID
     */
    public void setAuthId(String authId){
        this.authId = authId;
    }

    /**
     * 获取第三方登录ID
     *
     * @return 第三方登录ID
     */
    public String getAuthId(){
        return authId;
    }


    /**
     * 设置用户状态
     *
     *
     * @param status 用户状态
     */
    public void setStatus(Integer status){
        if(status == null){
            this.statusStr = "";
        }else{
            if(MemberStatusEnum.INVALID.value == status.intValue()){
                this.statusStr = MemberStatusEnum.INVALID.name;
            }else if(MemberStatusEnum.LIMIT.value == status.intValue()){
                this.statusStr = MemberStatusEnum.LIMIT.name;
            }else{
                this.statusStr = MemberStatusEnum.VALID.name;
            }
        }

        this.status = status;
    }

    /**
     * 获取用户状态
     *
     *
     * @return 用户状态
     */
    public Integer getStatus(){

        return status;
    }


    /**
     * 设置
     *
     * @param country 
     */
    public void setCountry(String country){
        this.country = country;
    }

    /**
     * 获取
     *
     * @return 
     */
    public String getCountry(){
        return country;
    }


    /**
     * 设置
     *
     * @param language 
     */
    public void setLanguage(String language){
        this.language = language;
    }

    /**
     * 获取
     *
     * @return 
     */
    public String getLanguage(){
        return language;
    }


    /**
     * 设置
     *
     * @param avatar 
     */
    public void setAvatar(String avatar){
        this.avatar = avatar;
    }

    /**
     * 获取
     *
     * @return 
     */
    public String getAvatar(){
        return avatar;
    }


    /**
     * 设置
     *
     * @param nickname 
     */
    public void setNickname(String nickname){
        this.nickname = nickname;
    }

    /**
     * 获取
     *
     * @return 
     */
    public String getNickname(){
        return nickname;
    }


    /**
     * 设置别名ID
     *
     * @param aliasId 别名ID
     */
    public void setAliasId(String aliasId){
        this.aliasId = aliasId;
    }

    /**
     * 获取别名ID
     *
     * @return 别名ID
     */
    public String getAliasId(){
        return aliasId;
    }


    /**
     * 设置指纹
     *
     * @param fingerprint 指纹
     */
    public void setFingerprint(String fingerprint){
        this.fingerprint = fingerprint;
    }

    /**
     * 获取指纹
     *
     * @return 指纹
     */
    public String getFingerprint(){
        return fingerprint;
    }


    /**
     * 设置注册方式
     *
     * @param from 注册方式
     */
    public void setFrom(Integer from){
        if(from == null){
            this.fromStr = "-";
        }else {
            if(MemberFromEnum.message.value == from.intValue()){
                this.fromStr = MemberFromEnum.message.name;
            }else if(MemberFromEnum.phone.value == from.intValue()){
                this.fromStr = MemberFromEnum.phone.name;
            }else if(MemberFromEnum.wechat.value == from.intValue()){
                this.fromStr = MemberFromEnum.wechat.name;
            }else if(MemberFromEnum.qq.value == from.intValue()){
                this.fromStr = MemberFromEnum.qq.name;
            }else if(MemberFromEnum.email.value == from.intValue()){
                this.fromStr = MemberFromEnum.email.name;
            }else if(MemberFromEnum.facebook.value == from.intValue()){
                this.fromStr = MemberFromEnum.facebook.name;
            }else if(MemberFromEnum.google.value == from.intValue()){
                this.fromStr = MemberFromEnum.google.name;
            }else{
                this.fromStr = "-";
            }
        }
        this.from = from;
    }

    /**
     * 获取注册方式
     *
     * @return 注册方式
     */
    public Integer getFrom(){
        return from;
    }


    /**
     * 设置设备登录密码
     *
     * @param devicePwd 设备登录密码
     */
    public void setDevicePwd(String devicePwd){
        this.devicePwd = devicePwd;
    }

    /**
     * 获取设备登录密码
     *
     * @return 设备登录密码
     */
    public String getDevicePwd(){
        return devicePwd;
    }


    /**
     * 设置创建者编号
     *
     * @param createdId 创建者编号
     */
    public void setCreatedId(Integer createdId){
        this.createdId = createdId;
    }

    /**
     * 获取创建者编号
     *
     * @return 创建者编号
     */
    public Integer getCreatedId(){
        return createdId;
    }


    /**
     * 设置更新者编号
     *
     * @param modifiedId 更新者编号
     */
    public void setModifiedId(Integer modifiedId){
        this.modifiedId = modifiedId;
    }

    /**
     * 获取更新者编号
     *
     * @return 更新者编号
     */
    public Integer getModifiedId(){
        return modifiedId;
    }


    /**
     * 设置创建时间
     *
     * @param createdTime 创建时间
     */
    public void setCreatedTime(Date createdTime){
        this.createdTime = createdTime;
    }

    /**
     * 获取创建时间
     *
     * @return 创建时间
     */
    public Date getCreatedTime(){
        return createdTime;
    }


    /**
     * 设置更新时间
     *
     * @param modifiedTime 更新时间
     */
    public void setModifiedTime(Date modifiedTime){
        this.modifiedTime = modifiedTime;
    }

    /**
     * 获取更新时间
     *
     * @return 更新时间
     */
    public Date getModifiedTime(){
        return modifiedTime;
    }


    /**
     * 设置删除标识位
     *
     * @see com.ydd.framework.core.entity.enums.DeletedEnum
     * @param deleted 删除标识位
     */
    public void setDeleted(Integer deleted){
        this.deleted = deleted;
    }

    /**
     * 获取删除标识位
     *
     * @see com.ydd.framework.core.entity.enums.DeletedEnum
     * @return 删除标识位
     */
    public Integer getDeleted(){
        return deleted;
    }

}