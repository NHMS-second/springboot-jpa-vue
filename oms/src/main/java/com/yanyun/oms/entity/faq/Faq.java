package com.yanyun.oms.entity.faq;

import java.io.Serializable;
import java.util.Date;

/**
 * Entity - 常见问题
 *
 * @author Demon
 * @since 2018-03-30
 */
public class Faq implements Serializable {


    /**
     * 
     */
    private Integer id;

    /**
     * 问题标题
     */
    private String title;

    /**
     * 问题答案
     */
    private String content;

    /**
     * 排序（越大越靠前）
     */
    private Integer sort;

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
     * 设置问题标题
     *
     * @param title 问题标题
     */
    public void setTitle(String title){
        this.title = title;
    }

    /**
     * 获取问题标题
     *
     * @return 问题标题
     */
    public String getTitle(){
        return title;
    }


    /**
     * 设置问题答案
     *
     * @param content 问题答案
     */
    public void setContent(String content){
        this.content = content;
    }

    /**
     * 获取问题答案
     *
     * @return 问题答案
     */
    public String getContent(){
        return content;
    }


    /**
     * 设置排序（越大越靠前）
     *
     * @param sort 排序（越大越靠前）
     */
    public void setSort(Integer sort){
        this.sort = sort;
    }

    /**
     * 获取排序（越大越靠前）
     *
     * @return 排序（越大越靠前）
     */
    public Integer getSort(){
        return sort;
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