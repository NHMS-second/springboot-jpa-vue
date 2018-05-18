
package com.yanyun.oms.service;
import com.ydd.framework.core.common.Pagination;
import com.ydd.framework.core.service.BaseService;

import com.yanyun.oms.entity.DeviceKeyLog;


/**
 * Service - 设备ID使用记录
 *
 * @author zhaoziyu
 * @since 2018-05-18
 */
public interface DeviceKeyLogService extends BaseService {

    /**
     * 保存设备ID使用记录
     *
     * @param deviceKeyLog 设备ID使用记录
     */
    void save(DeviceKeyLog deviceKeyLog);

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
    Integer delete(Integer id);

    /**
     * 删除设备ID使用记录
     *
     * @param ids 编号数组
     * @return 删除数量
     */
    Integer deleteByIds(Integer[] ids);

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
     * @param pagination 分页信息
     * @return 分页结果
     */
    Pagination findPage(Pagination pagination,Integer deviceKeyId);

    /**
     * 更新状态
     *
     * @param ids 编号
     * @param status 状态
     * @return 更新数量
     */
    Integer updateStatus(Integer[] ids, Byte status);

}

