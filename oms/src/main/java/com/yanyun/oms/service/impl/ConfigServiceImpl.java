package com.yanyun.oms.service.impl;
import com.github.pagehelper.PageHelper;
import com.ydd.framework.core.common.Pagination;
import com.ydd.framework.core.service.impl.BaseServiceImpl;

import com.yanyun.oms.entity.Config;
import com.yanyun.oms.mapper.ConfigMapper;
import com.yanyun.oms.service.ConfigService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Service - 系统参数
 *
 * @author zhaoziyu
 * @since 2018-04-27
 */
@Service
@Transactional(readOnly = true)
public class ConfigServiceImpl extends BaseServiceImpl implements ConfigService {

	private final Logger logger = LoggerFactory.getLogger(ConfigServiceImpl.class);

	@Resource
	private ConfigMapper configMapper;

	/**
	 * 创建系统参数
	 *
	 * @param config 系统参数
	 */
	@Override
	@Transactional
    public void save(Config config) {
		if (config.getId() != null && config.getId() > 0) {
			// 更新
			configMapper.update(config);
		} else {
			// 新建
			configMapper.insert(config);
		}
	}

	/**
	 * 更新系统参数
 	 *
	 * @param config 系统参数
	 */
	@Override
	@Transactional
    public void update(Config config) {
		configMapper.update(config);
	}

	/**
	 * 删除系统参数
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
		return configMapper.delete(id);
	}

	/**
	 * 删除系统参数
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
		return configMapper.deleteByIds(ids);
	}

	/**
	 * 查询系统参数
	 *
	 * @param id 编号
	 * @return 系统参数
	 */
	public Config findById(Integer id) {
		return configMapper.findById(id);
	}

	/**
	 * 查询系统参数
	 *
	 * @param pagination 分页信息
	 * @return 分页结果
	 */
	@Override
	public Pagination findPage(Pagination pagination) {
		PageHelper.startPage(pagination.getPage(), pagination.getPageSize());
		PageHelper.orderBy("id desc");
		pagination.setQueryResult(configMapper.findAll());
		return pagination;
	}

	/**
	 * 获取设备异常时间阈值
	 * @return
	 */
	@Override
	public Long findDeviceErrorTime() {
		return Long.parseLong(configMapper.findByKey("device_error_time").getValue());
	}
}

