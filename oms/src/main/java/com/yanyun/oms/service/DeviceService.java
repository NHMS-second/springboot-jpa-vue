package com.yanyun.oms.service;

import com.ydd.framework.core.common.Pagination;
import com.ydd.framework.core.service.BaseService;

import com.yanyun.oms.entity.device.Device;


/**
 * Service - 设备
 *
 * @author Demon
 * @since 2018-03-30
 */
public interface DeviceService extends BaseService {

    /**
     * 保存设备
     *
     * @param device 设备
     */
    void save(Device device);

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
    Integer delete(Integer id);

    /**
     * 删除设备
     *
     * @param ids 编号数组
     * @return 删除数量
     */
    Integer deleteByIds(Integer[] ids);

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
     * @param pagination 分页信息
     * @return 分页结果
     */
    Pagination findPage(Pagination pagination);

    /**
     * 更新状态
     *
     * @param ids 编号
     * @param status 状态
     * @return 更新数量
     */
    Integer updateStatus(Integer[] ids, Byte status);

}

