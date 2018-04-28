
package com.yanyun.oms.service;
import com.ydd.framework.core.common.Pagination;
import com.ydd.framework.core.service.BaseService;

import com.yanyun.oms.entity.MemberOpinion;


/**
 * Service - 用户反馈
 *
 * @author zhaoziyu
 * @since 2018-04-28
 */
public interface MemberOpinionService extends BaseService {

    /**
     * 保存用户反馈
     *
     * @param memberOpinion 用户反馈
     */
    void save(MemberOpinion memberOpinion);

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
    Integer delete(Integer id);

    /**
     * 删除用户反馈
     *
     * @param ids 编号数组
     * @return 删除数量
     */
    Integer deleteByIds(Integer[] ids);

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
     * @param pagination 分页信息
     * @return 分页结果
     */
    Pagination findPage(Pagination pagination);

}

