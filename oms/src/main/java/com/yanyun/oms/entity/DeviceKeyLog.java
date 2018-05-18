package com.yanyun.oms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Entity - 设备ID使用记录
 *
 * @author zhaoziyu
 * @since 2018-05-18
 */
public class DeviceKeyLog implements Serializable {


    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer deviceKeyId;

    /**
     * 状态
     *
     * @see com.ydd.framework.core.entity.enums.StatusEnum
     */
    private Integer status;

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
     * 设置
     *
     * @param deviceKeyId 
     */
    public void setDeviceKeyId(Integer deviceKeyId){
        this.deviceKeyId = deviceKeyId;
    }

    /**
     * 获取
     *
     * @return 
     */
    public Integer getDeviceKeyId(){
        return deviceKeyId;
    }


    /**
     * 设置状态
     *
     * @see com.ydd.framework.core.entity.enums.StatusEnum
     * @param status 状态
     */
    public void setStatus(Integer status){
        this.status = status;
    }

    /**
     * 获取状态
     *
     * @see com.ydd.framework.core.entity.enums.StatusEnum
     * @return 状态
     */
    public Integer getStatus(){
        return status;
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

}