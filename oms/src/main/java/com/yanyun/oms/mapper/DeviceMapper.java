package com.yanyun.oms.mapper;

import com.yanyun.oms.dto.StatisticsNewDeviceDTO;
import com.yanyun.oms.entity.device.Device;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;


import java.util.LinkedHashMap;
import java.util.List;

/**
 * Mapper - 设备
 *
 * @author Demon
 * @since 2018-03-30
 */
public interface DeviceMapper {

    /**
     * 新建设备
     *
     * @param device 设备
     */
    void insert(Device device);

    /**
     * 更新设备
     *
     * @param device 设备
     */
    void update(Device device);

    /**
     * 删除设备
     *
     * @param id 编号
     * @return 删除数量
     */
    int delete(Integer id);

    /**
     * 删除设备
     *
     * @param ids 编号数组
     * @return 删除数量
     */
    int deleteByIds(Integer[] ids);

    /**
     * 查询设备
     *
     * @param id 编号
     * @return 设备
     */
    Device findById(Integer id);

    /**
     * 查询设备
     *
     * @return 设备集合
     */
    List<Device> findAll();

    /**
     * 更新状态
     *
     * @param ids 编号
     * @param status 状态
     * @return 更新数量
     */
    int updateStatus(@Param("ids") Integer[] ids, @Param("status") Byte status);

    List<StatisticsNewDeviceDTO> statisticsNewDeviceEveryDay(@Param("dates") List<String> dates);
}