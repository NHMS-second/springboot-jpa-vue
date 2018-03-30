package com.yanyun.oms.service;

import com.ydd.framework.core.common.Pagination;
import com.ydd.framework.core.service.BaseService;

import com.yanyun.oms.entity.message.Message;


/**
 * Service - 系统消息
 *
 * @author Demon
 * @since 2018-03-29
 */
public interface MessageService extends BaseService {

    /**
     * 保存系统消息
     *
     * @param message 系统消息
     */
    void save(Message message);

    /**
     * 更新系统消息
     *
     * @param message 系统消息
     */
    void update(Message message);

    /**
     * 删除系统消息
     *
     * @param id 编号
     * @return 删除数量
     */
    Integer delete(Integer id);

    /**
     * 删除系统消息
     *
     * @param ids 编号数组
     * @return 删除数量
     */
    Integer deleteByIds(Integer[] ids);

    /**
     * 查询系统消息
     *
     * @param id 编号
     * @return 系统消息
     */
    Message findById(Integer id);

    /**
     * 查询系统消息
     *
     * @param pagination 分页信息
     * @return 分页结果
     */
    Pagination findPage(Pagination pagination);

}

