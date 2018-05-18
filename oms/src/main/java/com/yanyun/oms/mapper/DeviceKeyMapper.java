package com.yanyun.oms.mapper;

import com.yanyun.oms.entity.deviceKey.DeviceKey;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * Mapper - 设备唯一序列号
 *
 * @author Demon
 * @since 2018-03-30
 */
public interface DeviceKeyMapper {

    /**
     * 新建设备唯一序列号
     *
     * @param deviceKey 设备唯一序列号
     */
    void insert(DeviceKey deviceKey);

    /**
     * 更新设备唯一序列号
     *
     * @param deviceKey 设备唯一序列号
     */
    void update(DeviceKey deviceKey);

    /**
     * 删除设备唯一序列号
     *
     * @param id 编号
     * @return 删除数量
     */
    int delete(Integer id);

    /**
     * 删除设备唯一序列号
     *
     * @param ids 编号数组
     * @return 删除数量
     */
    int deleteByIds(Integer[] ids);

    /**
     * 查询设备唯一序列号
     *
     * @param id 编号
     * @return 设备唯一序列号
     */
    DeviceKey findById(Integer id);

    /**
     *
     * @param qniqueId
     * @return
     */
    DeviceKey findByQniqueId(String qniqueId);


    /**
     *
     * @param key
     * @return
     */
    DeviceKey findByKey(String key);

    /**
     * 查询设备唯一序列号
     *
     * @return 设备唯一序列号集合
     */
    List<DeviceKey> findAll();

    /**
     * 更新状态
     *
     * @param ids 编号
     * @param status 状态
     * @return 更新数量
     */
    int updateStatus(@Param("ids") Integer[] ids, @Param("status") Byte status);

    Integer countByStatus(@Param("status") Integer status);

    Integer countByDeviceKeyIdStatus(@Param("status") Integer status,@Param("deviceKeyId") Integer deviceKeyId);
}