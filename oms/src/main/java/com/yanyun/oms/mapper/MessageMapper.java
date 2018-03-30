package com.yanyun.oms.mapper;

import com.yanyun.oms.entity.message.Message;



import java.util.List;

/**
 * Mapper - 系统消息
 *
 * @author Demon
 * @since 2018-03-29
 */
public interface MessageMapper {

    /**
     * 新建系统消息
     *
     * @param message 系统消息
     */
    void insert(Message message);

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
    int delete(Integer id);

    /**
     * 删除系统消息
     *
     * @param ids 编号数组
     * @return 删除数量
     */
    int deleteByIds(Integer[] ids);

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
     * @return 系统消息集合
     */
    List<Message> findAll();

}