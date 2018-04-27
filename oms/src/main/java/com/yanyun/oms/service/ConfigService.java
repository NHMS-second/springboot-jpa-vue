
package com.yanyun.oms.service;
import com.ydd.framework.core.common.Pagination;
import com.ydd.framework.core.service.BaseService;

import com.yanyun.oms.entity.Config;


/**
 * Service - 系统参数
 *
 * @author zhaoziyu
 * @since 2018-04-27
 */
public interface ConfigService extends BaseService {

    /**
     * 保存系统参数
     *
     * @param config 系统参数
     */
    void save(Config config);

    /**
     * 更新系统参数
     *
     * @param config 系统参数
     */
    void update(Config config);

    /**
     * 删除系统参数
     *
     * @param id 编号
     * @return 删除数量
     */
    Integer delete(Integer id);

    /**
     * 删除系统参数
     *
     * @param ids 编号数组
     * @return 删除数量
     */
    Integer deleteByIds(Integer[] ids);

    /**
     * 查询系统参数
     *
     * @param id 编号
     * @return 系统参数
     */
    Config findById(Integer id);

    /**
     * 查询系统参数
     *
     * @param pagination 分页信息
     * @return 分页结果
     */
    Pagination findPage(Pagination pagination);


    Long findDeviceErrorTime();

}

