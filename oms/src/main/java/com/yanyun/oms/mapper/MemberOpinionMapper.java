package com.yanyun.oms.mapper;
import com.yanyun.oms.entity.MemberOpinion;



import java.util.List;

/**
 * Mapper - 用户反馈
 *
 * @author zhaoziyu
 * @since 2018-04-28
 */
public interface MemberOpinionMapper {

    /**
     * 新建用户反馈
     *
     * @param memberOpinion 用户反馈
     */
    void insert(MemberOpinion memberOpinion);

    /**
     * 更新用户反馈
     *
     * @param memberOpinion 用户反馈
     */
    void update(MemberOpinion memberOpinion);

    /**
     * 删除用户反馈
     *
     * @param id 编号
     * @return 删除数量
     */
    int delete(Integer id);

    /**
     * 删除用户反馈
     *
     * @param ids 编号数组
     * @return 删除数量
     */
    int deleteByIds(Integer[] ids);

    /**
     * 查询用户反馈
     *
     * @param id 编号
     * @return 用户反馈
     */
    MemberOpinion findById(Integer id);

    /**
     * 查询用户反馈
     *
     * @return 用户反馈集合
     */
    List<MemberOpinion> findAll();

}