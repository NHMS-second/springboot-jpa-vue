package com.yanyun.oms.service;

import com.ydd.framework.core.common.Pagination;
import com.ydd.framework.core.service.BaseService;

import com.yanyun.oms.entity.member.Member;

import java.io.File;
import java.util.List;


/**
 * Service - 会员
 *
 * @author Demon
 * @since 2018-03-26
 */
public interface MemberService extends BaseService {

    /**
     * 保存会员
     *
     * @param member 会员
     */
    void save(Member member);

    /**
     * 更新会员
     *
     * @param member 会员
     */
    void update(Member member);

    /**
     * 删除会员
     *
     * @param id 编号
     * @return 删除数量
     */
    Integer delete(Integer id);

    /**
     * 删除会员
     *
     * @param ids 编号数组
     * @return 删除数量
     */
    Integer deleteByIds(Integer[] ids);

    /**
     * 查询会员
     *
     * @param id 编号
     * @return 会员
     */
    Member findById(Integer id);


    File exportExcel(String language);

    /**
     * 查询会员
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
    Integer updateStatus(Integer[] ids, Integer status);

}

