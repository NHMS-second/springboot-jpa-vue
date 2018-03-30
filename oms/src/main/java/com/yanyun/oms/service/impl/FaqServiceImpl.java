package com.yanyun.oms.service.impl;

import com.github.pagehelper.PageHelper;
import com.yanyun.oms.mapper.FaqMapper;
import com.yanyun.oms.service.FaqService;
import com.ydd.framework.core.common.Pagination;
import com.ydd.framework.core.service.impl.BaseServiceImpl;

import com.yanyun.oms.entity.faq.Faq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Service - 常见问题
 *
 * @author Demon
 * @since 2018-03-30
 */
@Service
@Transactional(readOnly = true)
public class FaqServiceImpl extends BaseServiceImpl implements FaqService {

	private final Logger logger = LoggerFactory.getLogger(FaqServiceImpl.class);

	@Resource
	private FaqMapper faqMapper;

	/**
	 * 创建常见问题
	 *
	 * @param faq 常见问题
	 */
	@Override
	@Transactional
    public void save(Faq faq) {
		if (faq.getId() != null && faq.getId() > 0) {
			// 更新
			faqMapper.update(faq);
		} else {
			// 新建
			faqMapper.insert(faq);
		}
	}

	/**
	 * 更新常见问题
 	 *
	 * @param faq 常见问题
	 */
	@Override
	@Transactional
    public void update(Faq faq) {
		faqMapper.update(faq);
	}

	/**
	 * 删除常见问题
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
		return faqMapper.delete(id);
	}

	/**
	 * 删除常见问题
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
		return faqMapper.deleteByIds(ids);
	}

	/**
	 * 查询常见问题
	 *
	 * @param id 编号
	 * @return 常见问题
	 */
	public Faq findById(Integer id) {
		return faqMapper.findById(id);
	}

	/**
	 * 查询常见问题
	 *
	 * @param pagination 分页信息
	 * @return 分页结果
	 */
	@Override
	public Pagination findPage(Pagination pagination) {
		PageHelper.startPage(pagination.getPage(), pagination.getPageSize());
		PageHelper.orderBy("sort desc");
		pagination.setQueryResult(faqMapper.findAll());
		return pagination;
	}

}

