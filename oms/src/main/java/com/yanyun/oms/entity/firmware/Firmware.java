package com.yanyun.oms.entity.firmware;

import com.yanyun.oms.enums.FirmwareChipTypeEnum;
import com.yanyun.oms.enums.FirmwareTypeEnum;

import java.io.Serializable;
import java.util.Date;

/**
 * Entity - 设备固件
 *
 * @author Demon
 * @since 2018-03-27
 */
public class Firmware implements Serializable {


    /**
     * 
     */
    private Integer id;

    /**
     * 版本号
     */
    private String revision;

    /**
     * 文本名称
     */
    private String name;

    /**
     * 文件的真实名称（带后缀）
     */
    private String fileName;

    /**
     * 设备类型
     * @see com.yanyun.oms.enums.FirmwareChipTypeEnum
     */
    //private Integer chipType;


    //private String chipTypeStr;


    /**
     * 文件大小
     */
    private Integer bytes;

    /**
     * 升级状态
     * @see com.yanyun.oms.enums.FirmwareTypeEnum
     */
    private Integer type;


    private String typeStr;

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


   /* public String getChipTypeStr() {
        return chipTypeStr;
    }

    public void setChipTypeStr(String chipTypeStr) {
        this.chipTypeStr = chipTypeStr;
    }*/

    public String getTypeStr() {
        return typeStr;
    }

    public void setTypeStr(String typeStr) {
        this.typeStr = typeStr;
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
     * 设置版本号
     *
     * @param revision 版本号
     */
    public void setRevision(String revision){
        this.revision = revision;
    }

    /**
     * 获取版本号
     *
     * @return 版本号
     */
    public String getRevision(){
        return revision;
    }


    /**
     * 设置文本名称
     *
     * @param name 文本名称
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * 获取文本名称
     *
     * @return 文本名称
     */
    public String getName(){
        return name;
    }


    /**
     * 设置文件的真实名称（带后缀）
     *
     * @param fileName 文件的真实名称（带后缀）
     */
    public void setFileName(String fileName){
        this.fileName = fileName;
    }

    /**
     * 获取文件的真实名称（带后缀）
     *
     * @return 文件的真实名称（带后缀）
     */
    public String getFileName(){
        return fileName;
    }


    /**
     * 设置设备类型
     *
     * @param chipType 设备类型
     */
    /*public void setChipType(Integer chipType){
        if(chipType == null){
            this.chipTypeStr = "";
        }else {
            if(FirmwareChipTypeEnum.muc.value.intValue() == chipType.intValue()){
                this.chipTypeStr = FirmwareChipTypeEnum.muc.name;
            }else if(FirmwareChipTypeEnum.dsp.value.intValue() == chipType.intValue()){
                this.chipTypeStr = FirmwareChipTypeEnum.dsp.name;
            }else{
                this.chipTypeStr = "";
            }
        }
        this.chipType = chipType;
    }*/

    /**
     * 获取设备类型
     *
     * @return 设备类型
     */
    /*public Integer getChipType(){
        return chipType;
    }*/


    /**
     * 设置文件大小
     *
     * @param bytes 文件大小
     */
    public void setBytes(Integer bytes){
        this.bytes = bytes;
    }

    /**
     * 获取文件大小
     *
     * @return 文件大小
     */
    public Integer getBytes(){
        return bytes;
    }


    /**
     * 设置升级状态
     *
     * @param type 升级状态
     */
    public void setType(Integer type){
        if(type == null){
            this.typeStr = "";
        }else {
            if(FirmwareTypeEnum.force.value.intValue() == type.intValue()){
                this.typeStr = FirmwareTypeEnum.force.name;
            }else if(FirmwareTypeEnum.noForce.value.intValue() == type.intValue()){
                this.typeStr = FirmwareTypeEnum.noForce.name;
            }else{
                this.typeStr = "";
            }
        }

        this.type = type;
    }

    /**
     * 获取升级状态
     *
     * @return 升级状态
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