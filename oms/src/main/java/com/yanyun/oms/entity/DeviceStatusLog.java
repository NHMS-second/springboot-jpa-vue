package com.yanyun.oms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Entity - 设备上下线记录
 *
 * @author zhaoziyu
 * @since 2018-04-27
 */
public class DeviceStatusLog implements Serializable {


    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer deviceId;

    /**
     * 事件
     */
    private Integer type;

    /**
     * 设备上下线时间
     */
    private Date time;

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
     * 设置
     *
     * @param deviceId 
     */
    public void setDeviceId(Integer deviceId){
        this.deviceId = deviceId;
    }

    /**
     * 获取
     *
     * @return 
     */
    public Integer getDeviceId(){
        return deviceId;
    }


    /**
     * 设置事件
     *
     * @param type 事件
     */
    public void setType(Integer type){
        this.type = type;
    }

    /**
     * 获取事件
     *
     * @return 事件
     */
    public Integer getType(){
        return type;
    }


    /**
     * 设置设备上下线时间
     *
     * @param time 设备上下线时间
     */
    public void setTime(Date time){
        this.time = time;
    }

    /**
     * 获取设备上下线时间
     *
     * @return 设备上下线时间
     */
    public Date getTime(){
        return time;
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