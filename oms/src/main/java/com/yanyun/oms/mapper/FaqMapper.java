package com.yanyun.oms.mapper;

import com.yanyun.oms.entity.faq.Faq;



import java.util.List;

/**
 * Mapper - 常见问题
 *
 * @author Demon
 * @since 2018-03-30
 */
public interface FaqMapper {

    /**
     * 新建常见问题
     *
     * @param faq 常见问题
     */
    void insert(Faq faq);

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
    int delete(Integer id);

    /**
     * 删除常见问题
     *
     * @param ids 编号数组
     * @return 删除数量
     */
    int deleteByIds(Integer[] ids);

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
     * @return 常见问题集合
     */
    List<Faq> findAll();

}