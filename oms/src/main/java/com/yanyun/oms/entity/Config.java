package com.yanyun.oms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Entity - 系统参数
 *
 * @author zhaoziyu
 * @since 2018-04-27
 */
public class Config implements Serializable {


    /**
     * 编号
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 键
     */
    private String key;

    /**
     * 值
     */
    private String value;

    /**
     * 
     */
    private String enValue;

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
     * 设置编号
     *
     * @param id 编号
     */
    public void setId(Integer id){
        this.id = id;
    }

    /**
     * 获取编号
     *
     * @return 编号
     */
    public Integer getId(){
        return id;
    }


    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * 获取名称
     *
     * @return 名称
     */
    public String getName(){
        return name;
    }


    /**
     * 设置键
     *
     * @param key 键
     */
    public void setKey(String key){
        this.key = key;
    }

    /**
     * 获取键
     *
     * @return 键
     */
    public String getKey(){
        return key;
    }


    /**
     * 设置值
     *
     * @param value 值
     */
    public void setValue(String value){
        this.value = value;
    }

    /**
     * 获取值
     *
     * @return 值
     */
    public String getValue(){
        return value;
    }


    /**
     * 设置
     *
     * @param enValue 
     */
    public void setEnValue(String enValue){
        this.enValue = enValue;
    }

    /**
     * 获取
     *
     * @return 
     */
    public String getEnValue(){
        return enValue;
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