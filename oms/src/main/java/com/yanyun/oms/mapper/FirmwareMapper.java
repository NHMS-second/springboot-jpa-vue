package com.yanyun.oms.mapper;

import com.yanyun.oms.entity.firmware.Firmware;



import java.util.List;

/**
 * Mapper - 设备固件
 *
 * @author Demon
 * @since 2018-03-27
 */
public interface FirmwareMapper {

    /**
     * 新建设备固件
     *
     * @param firmware 设备固件
     */
    void insert(Firmware firmware);

    /**
     * 更新设备固件
     *
     * @param firmware 设备固件
     */
    void update(Firmware firmware);

    /**
     * 删除设备固件
     *
     * @param id 编号
     * @return 删除数量
     */
    int delete(Integer id);

    /**
     * 删除设备固件
     *
     * @param ids 编号数组
     * @return 删除数量
     */
    int deleteByIds(Integer[] ids);

    /**
     * 查询设备固件
     *
     * @param id 编号
     * @return 设备固件
     */
    Firmware findById(Integer id);

    /**
     * 查询设备固件
     *
     * @return 设备固件集合
     */
    List<Firmware> findAll();

}