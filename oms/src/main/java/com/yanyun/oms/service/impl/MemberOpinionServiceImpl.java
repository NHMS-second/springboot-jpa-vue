package com.yanyun.oms.service.impl;
import com.github.pagehelper.PageHelper;
import com.ydd.framework.core.common.Pagination;
import com.ydd.framework.core.service.impl.BaseServiceImpl;

import com.yanyun.oms.entity.MemberOpinion;
import com.yanyun.oms.mapper.MemberOpinionMapper;
import com.yanyun.oms.service.MemberOpinionService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Service - 用户反馈
 *
 * @author zhaoziyu
 * @since 2018-04-28
 */
@Service
@Transactional(readOnly = true)
public class MemberOpinionServiceImpl extends BaseServiceImpl implements MemberOpinionService {

	private final Logger logger = LoggerFactory.getLogger(MemberOpinionServiceImpl.class);

	@Resource
	private MemberOpinionMapper memberOpinionMapper;

	/**
	 * 创建用户反馈
	 *
	 * @param memberOpinion 用户反馈
	 */
	@Override
	@Transactional
    public void save(MemberOpinion memberOpinion) {
		if (memberOpinion.getId() != null && memberOpinion.getId() > 0) {
			// 更新
			memberOpinionMapper.update(memberOpinion);
		} else {
			// 新建
			memberOpinionMapper.insert(memberOpinion);
		}
	}

	/**
	 * 更新用户反馈
 	 *
	 * @param memberOpinion 用户反馈
	 */
	@Override
	@Transactional
    public void update(MemberOpinion memberOpinion) {
		memberOpinionMapper.update(memberOpinion);
	}

	/**
	 * 删除用户反馈
	 *
	 * @param id 编号
   	 * @return 删除数量
	 */
	@Override
	@Transactional
    public Integer delete(Integer id) {
		if (id == null || id <= 0) {
			return 0;
		}
		return memberOpinionMapper.delete(id);
	}

	/**
	 * 删除用户反馈
	 *
	 * @param ids 编号数组
	 * @return 删除数量
	 */
	@Override
	@Transactional
    public Integer deleteByIds(Integer[] ids) {
		if (ids == null || ids.length == 0) {
			return 0;
		}
		return memberOpinionMapper.deleteByIds(ids);
	}

	/**
	 * 查询用户反馈
	 *
	 * @param id 编号
	 * @return 用户反馈
	 */
	public MemberOpinion findById(Integer id) {
		return memberOpinionMapper.findById(id);
	}

	/**
	 * 查询用户反馈
	 *
	 * @param pagination 分页信息
	 * @return 分页结果
	 */
	@Override
	public Pagination findPage(Pagination pagination) {
		PageHelper.startPage(pagination.getPage(), pagination.getPageSize());
		PageHelper.orderBy("id desc");
		pagination.setQueryResult(memberOpinionMapper.findAll());
		return pagination;
	}

}

