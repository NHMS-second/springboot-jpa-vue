package com.yanyun.oms.mapper;

import com.yanyun.oms.dto.CommonDto;
import com.yanyun.oms.dto.user.MemberExportDto;
import com.yanyun.oms.entity.member.Member;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * Mapper - 会员
 *
 * @author Demon
 * @since 2018-03-26
 */
public interface MemberMapper {

    /**
     * 新建会员
     *
     * @param member 会员
     */
    void insert(Member member);

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
    int delete(Integer id);

    /**
     * 删除会员
     *
     * @param ids 编号数组
     * @return 删除数量
     */
    int deleteByIds(Integer[] ids);

    /**
     * 查询会员
     *
     * @param id 编号
     * @return 会员
     */
    Member findById(Integer id);

    CommonDto findNow();



    List<Member> findAll(@Param("searchKey") String searchKey);

    /**
     * 更新状态
     *
     * @param ids 编号
     * @param status 状态
     * @return 更新数量
     */
    int updateStatus(@Param("ids") Integer[] ids, @Param("status") Integer status);

}