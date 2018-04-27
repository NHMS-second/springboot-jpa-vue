
package com.yanyun.oms.service;
import com.ydd.framework.core.common.Pagination;
import com.ydd.framework.core.service.BaseService;

import com.yanyun.oms.entity.DeviceStatusLog;


/**
 * Service - 设备上下线记录
 *
 * @author zhaoziyu
 * @since 2018-04-27
 */
public interface DeviceStatusLogService extends BaseService {

    /**
     * 保存设备上下线记录
     *
     * @param deviceStatusLog 设备上下线记录
     */
    void save(DeviceStatusLog deviceStatusLog);

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
    Integer delete(Integer id);

    /**
     * 删除设备上下线记录
     *
     * @param ids 编号数组
     * @return 删除数量
     */
    Integer deleteByIds(Integer[] ids);

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
     * @param pagination 分页信息
     * @return 分页结果
     */
    Pagination findPage(Pagination pagination,Integer deviceId);

}

