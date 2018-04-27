package com.yanyun.oms.mapper;
import com.yanyun.oms.entity.DeviceStatusLog;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * Mapper - 设备上下线记录
 *
 * @author zhaoziyu
 * @since 2018-04-27
 */
public interface DeviceStatusLogMapper {

    /**
     * 新建设备上下线记录
     *
     * @param deviceStatusLog 设备上下线记录
     */
    void insert(DeviceStatusLog deviceStatusLog);

    /**
     * 更新设备上下线记录
     *
     * @param deviceStatusLog 设备上下线记录
     */
    void update(DeviceStatusLog deviceStatusLog);

    /**
     * 删除设备上下线记录
     *
     * @param id 编号
     * @return 删除数量
     */
    int delete(Integer id);

    /**
     * 删除设备上下线记录
     *
     * @param ids 编号数组
     * @return 删除数量
     */
    int deleteByIds(Integer[] ids);

    /**
     * 查询设备上下线记录
     *
     * @param id 编号
     * @return 设备上下线记录
     */
    DeviceStatusLog findById(Integer id);

    /**
     * 查询设备上下线记录
     *
     * @return 设备上下线记录集合
     */
    List<DeviceStatusLog> findAll(@Param("deviceId") Integer deviceId);

}