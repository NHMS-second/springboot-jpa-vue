package com.yanyun.oms.entity.message;

import java.io.Serializable;
import java.util.Date;

/**
 * Entity - 系统消息
 *
 * @author Demon
 * @since 2018-03-29
 */
public class Message implements Serializable {


    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String content;

    /**
     * 
     */
    private String title;

    /**
     * 
     */
    private String img;

    /**
     * 消息类型 1系统消息 2个人消息
     *
     */
    private Integer type;

    /**
     * 创建者编号
     */
    private Integer createdId;

    /**
     * 创建者编号
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
     * @param content 
     */
    public void setContent(String content){
        this.content = content;
    }

    /**
     * 获取
     *
     * @return 
     */
    public String getContent(){
        return content;
    }


    /**
     * 设置
     *
     * @param title 
     */
    public void setTitle(String title){
        this.title = title;
    }

    /**
     * 获取
     *
     * @return 
     */
    public String getTitle(){
        return title;
    }


    /**
     * 设置
     *
     * @param img 
     */
    public void setImg(String img){
        this.img = img;
    }

    /**
     * 获取
     *
     * @return 
     */
    public String getImg(){
        return img;
    }


    /**
     * 设置消息类型 1系统消息 2个人消息
     *
     * @param type 消息类型 1系统消息 2个人消息
     */
    public void setType(Integer type){
        this.type = type;
    }

    /**
     * 获取消息类型 1系统消息 2个人消息
     *
     * @return 消息类型 1系统消息 2个人消息
     */
    public Integer getType(){
        return type;
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
     * 设置创建者编号
     *
     * @param modifiedId 创建者编号
     */
    public void setModifiedId(Integer modifiedId){
        this.modifiedId = modifiedId;
    }

    /**
     * 获取创建者编号
     *
     * @return 创建者编号
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