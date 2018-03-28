package com.yanyun.oms.service.impl;

import com.github.pagehelper.PageHelper;
import com.yanyun.oms.mapper.FirmwareMapper;
import com.yanyun.oms.service.FirmwareService;
import com.ydd.framework.core.common.Pagination;
import com.ydd.framework.core.service.impl.BaseServiceImpl;

import com.yanyun.oms.entity.firmware.Firmware;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Service - 设备固件
 *
 * @author Demon
 * @since 2018-03-27
 */
@Service
@Transactional(readOnly = true)
public class FirmwareServiceImpl extends BaseServiceImpl implements FirmwareService {

	private final Logger logger = LoggerFactory.getLogger(FirmwareServiceImpl.class);

	@Resource
	private FirmwareMapper firmwareMapper;

	/**
	 * 创建设备固件
	 *
	 * @param firmware 设备固件
	 */
	@Override
	@Transactional
    public void save(Firmware firmware) {
		if (firmware.getId() != null && firmware.getId() > 0) {
			// 更新
			firmwareMapper.update(firmware);
		} else {
			// 新建
			firmwareMapper.insert(firmware);
		}
	}

	/**
	 * 更新设备固件
 	 *
	 * @param firmware 设备固件
	 */
	@Override
	@Transactional
    public void update(Firmware firmware) {
		firmwareMapper.update(firmware);
	}

	/**
	 * 删除设备固件
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
		return firmwareMapper.delete(id);
	}

	/**
	 * 删除设备固件
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
		return firmwareMapper.deleteByIds(ids);
	}

	/**
	 * 查询设备固件
	 *
	 * @param id 编号
	 * @return 设备固件
	 */
	public Firmware findById(Integer id) {
		return firmwareMapper.findById(id);
	}

	/**
	 * 查询设备固件
	 *
	 * @param pagination 分页信息
	 * @return 分页结果
	 */
	@Override
	public Pagination findPage(Pagination pagination) {
		PageHelper.startPage(pagination.getPage(), pagination.getPageSize());
		PageHelper.orderBy("id desc");
		pagination.setQueryResult(firmwareMapper.findAll());
		return pagination;
	}

}

