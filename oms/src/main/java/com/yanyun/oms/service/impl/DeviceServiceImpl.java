package com.yanyun.oms.service.impl;
import com.github.pagehelper.PageHelper;
import com.yanyun.oms.mapper.DeviceMapper;
import com.yanyun.oms.service.DeviceService;
import com.ydd.framework.core.common.Pagination;
import com.ydd.framework.core.entity.enums.StatusEnum;
import com.ydd.framework.core.service.impl.BaseServiceImpl;

import com.yanyun.oms.entity.device.Device;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Service - 设备
 *
 * @author Demon
 * @since 2018-03-30
 */
@Service
@Transactional(readOnly = true)
public class DeviceServiceImpl extends BaseServiceImpl implements DeviceService {

	private final Logger logger = LoggerFactory.getLogger(DeviceServiceImpl.class);

	@Resource
	private DeviceMapper deviceMapper;

	/**
	 * 创建设备
	 *
	 * @param device 设备
	 */
	@Override
	@Transactional
    public void save(Device device) {
		if (device.getId() != null && device.getId() > 0) {
			// 更新
			deviceMapper.update(device);
		} else {
			// 新建
			deviceMapper.insert(device);
		}
	}

	/**
	 * 更新设备
 	 *
	 * @param device 设备
	 */
	@Override
	@Transactional
    public void update(Device device) {
		deviceMapper.update(device);
	}

	/**
	 * 删除设备
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
		return deviceMapper.delete(id);
	}

	/**
	 * 删除设备
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
		return deviceMapper.deleteByIds(ids);
	}

	/**
	 * 查询设备
	 *
	 * @param id 编号
	 * @return 设备
	 */
	public Device findById(Integer id) {
		return deviceMapper.findById(id);
	}

	/**
	 * 查询设备
	 *
	 * @param pagination 分页信息
	 * @return 分页结果
	 */
	@Override
	public Pagination findPage(Pagination pagination) {
		PageHelper.startPage(pagination.getPage(), pagination.getPageSize());
		PageHelper.orderBy("id desc");
		pagination.setQueryResult(deviceMapper.findAll());
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

		return deviceMapper.updateStatus(ids, status);
	}

}

