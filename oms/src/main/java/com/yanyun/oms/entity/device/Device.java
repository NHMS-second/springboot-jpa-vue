package com.yanyun.oms.entity.device;

import java.io.Serializable;
import java.util.Date;

/**
 * Entity - 设备
 *
 * @author Demon
 * @since 2018-03-30
 */
public class Device implements Serializable {


    /**
     * 
     */
    private Integer id;

    /**
     * 设备昵称
     */
    private String nickname;

    /**
     * 设备编号
     */
    private String deviceSn;

    /**
     * 设备状态
     *
     * @see com.ydd.framework.core.entity.enums.StatusEnum
     */
    private Integer status;

    /**
     * 固件型号 
     */
    private Integer chipType;

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
     * 设置设备昵称
     *
     * @param nickname 设备昵称
     */
    public void setNickname(String nickname){
        this.nickname = nickname;
    }

    /**
     * 获取设备昵称
     *
     * @return 设备昵称
     */
    public String getNickname(){
        return nickname;
    }


    /**
     * 设置设备编号
     *
     * @param deviceSn 设备编号
     */
    public void setDeviceSn(String deviceSn){
        this.deviceSn = deviceSn;
    }

    /**
     * 获取设备编号
     *
     * @return 设备编号
     */
    public String getDeviceSn(){
        return deviceSn;
    }


    /**
     * 设置设备状态
     *
     * @see com.ydd.framework.core.entity.enums.StatusEnum
     * @param status 设备状态
     */
    public void setStatus(Integer status){
        this.status = status;
    }

    /**
     * 获取设备状态
     *
     * @see com.ydd.framework.core.entity.enums.StatusEnum
     * @return 设备状态
     */
    public Integer getStatus(){
        return status;
    }


    /**
     * 设置固件型号 
     *
     * @param chipType 固件型号 
     */
    public void setChipType(Integer chipType){
        this.chipType = chipType;
    }

    /**
     * 获取固件型号 
     *
     * @return 固件型号 
     */
    public Integer getChipType(){
        return chipType;
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