package com.yanyun.oms.service.impl;
import com.github.pagehelper.PageHelper;
import com.ydd.framework.core.common.Pagination;
import com.ydd.framework.core.entity.enums.StatusEnum;
import com.ydd.framework.core.service.impl.BaseServiceImpl;

import com.yanyun.oms.entity.DeviceKeyLog;
import com.yanyun.oms.mapper.DeviceKeyLogMapper;
import com.yanyun.oms.service.DeviceKeyLogService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Service - 设备ID使用记录
 *
 * @author zhaoziyu
 * @since 2018-05-18
 */
@Service
@Transactional(readOnly = true)
public class DeviceKeyLogServiceImpl extends BaseServiceImpl implements DeviceKeyLogService {

	private final Logger logger = LoggerFactory.getLogger(DeviceKeyLogServiceImpl.class);

	@Resource
	private DeviceKeyLogMapper deviceKeyLogMapper;

	/**
	 * 创建设备ID使用记录
	 *
	 * @param deviceKeyLog 设备ID使用记录
	 */
	@Override
	@Transactional
    public void save(DeviceKeyLog deviceKeyLog) {
		if (deviceKeyLog.getId() != null && deviceKeyLog.getId() > 0) {
			// 更新
			deviceKeyLogMapper.update(deviceKeyLog);
		} else {
			// 新建
			deviceKeyLogMapper.insert(deviceKeyLog);
		}
	}

	/**
	 * 更新设备ID使用记录
 	 *
	 * @param deviceKeyLog 设备ID使用记录
	 */
	@Override
	@Transactional
    public void update(DeviceKeyLog deviceKeyLog) {
		deviceKeyLogMapper.update(deviceKeyLog);
	}

	/**
	 * 删除设备ID使用记录
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
		return deviceKeyLogMapper.delete(id);
	}

	/**
	 * 删除设备ID使用记录
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
		return deviceKeyLogMapper.deleteByIds(ids);
	}

	/**
	 * 查询设备ID使用记录
	 *
	 * @param id 编号
	 * @return 设备ID使用记录
	 */
	public DeviceKeyLog findById(Integer id) {
		return deviceKeyLogMapper.findById(id);
	}

	/**
	 * 查询设备ID使用记录
	 *
	 * @param pagination 分页信息
	 * @return 分页结果
	 */
	@Override
	public Pagination findPage(Pagination pagination,Integer deviceKeyId) {
		PageHelper.startPage(pagination.getPage(), pagination.getPageSize());
		PageHelper.orderBy("id desc");
		pagination.setQueryResult(deviceKeyLogMapper.findAll(deviceKeyId));
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
	public Integer updateStatus(Integer[] ids, Byte status) {
		if (ids == null) {
			return 0;
		}
		if (status == null) {
			status = StatusEnum.DISABLE.value;
		}

		return deviceKeyLogMapper.updateStatus(ids, status);
	}

}

