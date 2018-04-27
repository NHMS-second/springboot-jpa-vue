package com.yanyun.oms.service.impl;
import com.github.pagehelper.PageHelper;
import com.ydd.framework.core.common.Pagination;
import com.ydd.framework.core.service.impl.BaseServiceImpl;

import com.yanyun.oms.entity.DeviceStatusLog;
import com.yanyun.oms.mapper.DeviceStatusLogMapper;
import com.yanyun.oms.service.DeviceStatusLogService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Service - 设备上下线记录
 *
 * @author zhaoziyu
 * @since 2018-04-27
 */
@Service
@Transactional(readOnly = true)
public class DeviceStatusLogServiceImpl extends BaseServiceImpl implements DeviceStatusLogService {

	private final Logger logger = LoggerFactory.getLogger(DeviceStatusLogServiceImpl.class);

	@Resource
	private DeviceStatusLogMapper deviceStatusLogMapper;

	/**
	 * 创建设备上下线记录
	 *
	 * @param deviceStatusLog 设备上下线记录
	 */
	@Override
	@Transactional
    public void save(DeviceStatusLog deviceStatusLog) {
		if (deviceStatusLog.getId() != null && deviceStatusLog.getId() > 0) {
			// 更新
			deviceStatusLogMapper.update(deviceStatusLog);
		} else {
			// 新建
			deviceStatusLogMapper.insert(deviceStatusLog);
		}
	}

	/**
	 * 更新设备上下线记录
 	 *
	 * @param deviceStatusLog 设备上下线记录
	 */
	@Override
	@Transactional
    public void update(DeviceStatusLog deviceStatusLog) {
		deviceStatusLogMapper.update(deviceStatusLog);
	}

	/**
	 * 删除设备上下线记录
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
		return deviceStatusLogMapper.delete(id);
	}

	/**
	 * 删除设备上下线记录
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
		return deviceStatusLogMapper.deleteByIds(ids);
	}

	/**
	 * 查询设备上下线记录
	 *
	 * @param id 编号
	 * @return 设备上下线记录
	 */
	public DeviceStatusLog findById(Integer id) {
		return deviceStatusLogMapper.findById(id);
	}

	/**
	 * 查询设备上下线记录
	 *
	 * @param pagination 分页信息
	 * @return 分页结果
	 */
	@Override
	public Pagination findPage(Pagination pagination,Integer deviceId) {
		PageHelper.startPage(pagination.getPage(), pagination.getPageSize());
		PageHelper.orderBy("id desc");
		pagination.setQueryResult(deviceStatusLogMapper.findAll(deviceId));
		return pagination;
	}

}

