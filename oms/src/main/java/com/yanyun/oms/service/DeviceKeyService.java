package com.yanyun.oms.service;
import com.ydd.framework.core.common.Pagination;
import com.ydd.framework.core.common.dto.ResponseDTO;
import com.ydd.framework.core.service.BaseService;

import com.yanyun.oms.entity.deviceKey.DeviceKey;


/**
 * Service - 设备唯一序列号
 *
 * @author Demon
 * @since 2018-03-30
 */
public interface DeviceKeyService extends BaseService {

    /**
     * 保存设备唯一序列号
     *
     * @param deviceKey 设备唯一序列号
     */
    ResponseDTO save(DeviceKey deviceKey);

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
    Integer delete(Integer id);

    /**
     * 删除设备唯一序列号
     *
     * @param ids 编号数组
     * @return 删除数量
     */
    Integer deleteByIds(Integer[] ids);

    /**
     * 查询设备唯一序列号
     *
     * @param id 编号
     * @return 设备唯一序列号
     */
    DeviceKey findById(Integer id);

    /**
     * 查询设备唯一序列号
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

    Integer getDeviceKeyTotalNum();

    Integer getDeviceKeyUsedNum();

    Integer getDeviceKeyNotUsedNum();
}

