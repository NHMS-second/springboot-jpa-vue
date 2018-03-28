package com.yanyun.oms.service;
import com.ydd.framework.core.common.Pagination;
import com.ydd.framework.core.service.BaseService;

import com.yanyun.oms.entity.firmware.Firmware;


/**
 * Service - 设备固件
 *
 * @author Demon
 * @since 2018-03-27
 */
public interface FirmwareService extends BaseService {

    /**
     * 保存设备固件
     *
     * @param firmware 设备固件
     */
    void save(Firmware firmware);

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
    Integer delete(Integer id);

    /**
     * 删除设备固件
     *
     * @param ids 编号数组
     * @return 删除数量
     */
    Integer deleteByIds(Integer[] ids);

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
     * @param pagination 分页信息
     * @return 分页结果
     */
    Pagination findPage(Pagination pagination);

}

