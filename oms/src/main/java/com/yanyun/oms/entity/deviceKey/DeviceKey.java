package com.yanyun.oms.entity.deviceKey;

import java.io.Serializable;
import java.util.Date;

/**
 * Entity - 设备唯一序列号
 *
 * @author Demon
 * @since 2018-03-30
 */
public class DeviceKey implements Serializable {


    /**
     * 
     */
    private Integer id;

    /**
     * 设备唯一ID
     */
    private String deviceUniqueId;

    /**
     * 设备唯一KEY
     */
    private String deviceKey;

    /**
     * 使用状态
     *
     * @see com.yanyun.oms.enums.DeviceKeyStatusEnum
     */
    private Integer status;

    /**
     * 设备ID
     */
    private Integer deviceId;

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
     * 设置设备唯一KEY
     *
     * @param deviceKey 设备唯一KEY
     */
    public void setDeviceKey(String deviceKey){
        this.deviceKey = deviceKey;
    }

    /**
     * 获取设备唯一KEY
     *
     * @return 设备唯一KEY
     */
    public String getDeviceKey(){
        return deviceKey;
    }


    /**
     * 设置使用状态
     *
     * @param status 使用状态
     */
    public void setStatus(Integer status){
        this.status = status;
    }

    /**
     * 获取使用状态
     *
     * @return 使用状态
     */
    public Integer getStatus(){
        return status;
    }


    /**
     * 设置设备ID
     *
     * @param deviceId 设备ID
     */
    public void setDeviceId(Integer deviceId){
        this.deviceId = deviceId;
    }

    /**
     * 获取设备ID
     *
     * @return 设备ID
     */
    public Integer getDeviceId(){
        return deviceId;
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


    public String getDeviceUniqueId() {
        return deviceUniqueId;
    }

    public void setDeviceUniqueId(String deviceUniqueId) {
        this.deviceUniqueId = deviceUniqueId;
    }
}