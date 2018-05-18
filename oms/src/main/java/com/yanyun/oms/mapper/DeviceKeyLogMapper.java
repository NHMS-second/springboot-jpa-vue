package com.yanyun.oms.mapper;
import com.yanyun.oms.entity.DeviceKeyLog;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * Mapper - 设备ID使用记录
 *
 * @author zhaoziyu
 * @since 2018-05-18
 */
public interface DeviceKeyLogMapper {

    /**
     * 新建设备ID使用记录
     *
     * @param deviceKeyLog 设备ID使用记录
     */
    void insert(DeviceKeyLog deviceKeyLog);

    /**
     * 更新设备ID使用记录
     *
     * @param deviceKeyLog 设备ID使用记录
     */
    void update(DeviceKeyLog deviceKeyLog);

    /**
     * 删除设备ID使用记录
     *
     * @param id 编号
     * @return 删除数量
     */
    int delete(Integer id);

    /**
     * 删除设备ID使用记录
     *
     * @param ids 编号数组
     * @return 删除数量
     */
    int deleteByIds(Integer[] ids);

    /**
     * 查询设备ID使用记录
     *
     * @param id 编号
     * @return 设备ID使用记录
     */
    DeviceKeyLog findById(Integer id);

    /**
     * 查询设备ID使用记录
     *
     * @return 设备ID使用记录集合
     */
    List<DeviceKeyLog> findAll(@Param("deviceKeyId") Integer deviceKeyId);

    /**
     * 更新状态
     *
     * @param ids 编号
     * @param status 状态
     * @return 更新数量
     */
    int updateStatus(@Param("ids") Integer[] ids, @Param("status") Byte status);

}