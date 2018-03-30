package com.yanyun.oms.service;
import com.ydd.framework.core.common.Pagination;
import com.ydd.framework.core.service.BaseService;

import com.yanyun.oms.entity.faq.Faq;


/**
 * Service - 常见问题
 *
 * @author Demon
 * @since 2018-03-30
 */
public interface FaqService extends BaseService {

    /**
     * 保存常见问题
     *
     * @param faq 常见问题
     */
    void save(Faq faq);

    /**
     * 更新常见问题
     *
     * @param faq 常见问题
     */
    void update(Faq faq);

    /**
     * 删除常见问题
     *
     * @param id 编号
     * @return 删除数量
     */
    Integer delete(Integer id);

    /**
     * 删除常见问题
     *
     * @param ids 编号数组
     * @return 删除数量
     */
    Integer deleteByIds(Integer[] ids);

    /**
     * 查询常见问题
     *
     * @param id 编号
     * @return 常见问题
     */
    Faq findById(Integer id);

    /**
     * 查询常见问题
     *
     * @param pagination 分页信息
     * @return 分页结果
     */
    Pagination findPage(Pagination pagination);

}

