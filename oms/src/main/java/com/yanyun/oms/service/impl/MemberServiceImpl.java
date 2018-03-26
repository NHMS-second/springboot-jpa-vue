package com.yanyun.oms.service.impl;
import com.github.pagehelper.PageHelper;
import com.yanyun.oms.enums.MemberStatusEnum;
import com.yanyun.oms.mapper.MemberMapper;
import com.yanyun.oms.service.MemberService;
import com.ydd.framework.core.common.Pagination;
import com.ydd.framework.core.entity.enums.StatusEnum;
import com.ydd.framework.core.service.impl.BaseServiceImpl;

import com.yanyun.oms.entity.member.Member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Service - 会员
 *
 * @author Demon
 * @since 2018-03-26
 */
@Service
@Transactional(readOnly = true)
public class MemberServiceImpl extends BaseServiceImpl implements MemberService {

	private final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

	@Resource
	private MemberMapper memberMapper;

	/**
	 * 创建会员
	 *
	 * @param member 会员
	 */
	@Override
	@Transactional
    public void save(Member member) {
		if (member.getId() != null && member.getId() > 0) {
			// 更新
			memberMapper.update(member);
		} else {
			// 新建
			memberMapper.insert(member);
		}
	}

	/**
	 * 更新会员
 	 *
	 * @param member 会员
	 */
	@Override
	@Transactional
    public void update(Member member) {
		memberMapper.update(member);
	}

	/**
	 * 删除会员
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
		return memberMapper.delete(id);
	}

	/**
	 * 删除会员
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
		return memberMapper.deleteByIds(ids);
	}

	/**
	 * 查询会员
	 *
	 * @param id 编号
	 * @return 会员
	 */
	public Member findById(Integer id) {
		return memberMapper.findById(id);
	}

	/**
	 * 查询会员
	 *
	 * @param pagination 分页信息
	 * @return 分页结果
	 */
	@Override
	public Pagination findPage(Pagination pagination) {
		PageHelper.startPage(pagination.getPage(), pagination.getPageSize());
		PageHelper.orderBy("id desc");
		pagination.setQueryResult(memberMapper.findAll());
		return pagination;
	}

	/**
	 * 更新状态
	 *
	 * @param ids 编号
	 * @param status 状态
	 * @return 更新数量
	 */
	@Override
	@Transactional
	public Integer updateStatus(Integer[] ids, Integer status) {
		if (ids == null) {
			return 0;
		}
		if (status == null) {
			status = MemberStatusEnum.INVALID.value;
		}

		return memberMapper.updateStatus(ids, status);
	}

}

