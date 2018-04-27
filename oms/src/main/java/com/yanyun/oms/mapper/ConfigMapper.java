package com.yanyun.oms.mapper;
import com.yanyun.oms.entity.Config;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * Mapper - 系统参数
 *
 * @author zhaoziyu
 * @since 2018-04-27
 */
public interface ConfigMapper {

    /**
     * 新建系统参数
     *
     * @param config 系统参数
     */
    void insert(Config config);

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
    int delete(Integer id);

    /**
     * 删除系统参数
     *
     * @param ids 编号数组
     * @return 删除数量
     */
    int deleteByIds(Integer[] ids);

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
     * @return 系统参数集合
     */
    List<Config> findAll();

    Config findByKey(@Param("key") String key);

}