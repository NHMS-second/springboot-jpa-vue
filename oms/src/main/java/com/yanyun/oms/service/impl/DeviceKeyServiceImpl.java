package com.yanyun.oms.service.impl;
import com.github.pagehelper.PageHelper;
import com.yanyun.oms.entity.firmware.Firmware;
import com.yanyun.oms.enums.DeviceKeyStatusEnum;
import com.yanyun.oms.mapper.DeviceKeyMapper;
import com.yanyun.oms.service.DeviceKeyService;
import com.ydd.framework.core.common.Pagination;
import com.ydd.framework.core.common.dto.ResponseDTO;
import com.ydd.framework.core.entity.enums.StatusEnum;
import com.ydd.framework.core.service.impl.BaseServiceImpl;

import com.yanyun.oms.entity.deviceKey.DeviceKey;

import com.ydd.oms.enums.ExceptionCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Service - 设备唯一序列号
 *
 * @author Demon
 * @since 2018-03-30
 */
@Service
@Transactional(readOnly = true)
public class DeviceKeyServiceImpl extends BaseServiceImpl implements DeviceKeyService {

	private final Logger logger = LoggerFactory.getLogger(DeviceKeyServiceImpl.class);

	@Resource
	private DeviceKeyMapper deviceKeyMapper;

	/**
	 * 创建设备唯一序列号
	 *
	 * @param deviceKey 设备唯一序列号
	 */
	@Override
	@Transactional
    public ResponseDTO save(DeviceKey deviceKey) {
		synchronized (this){
			DeviceKey qnique = deviceKeyMapper.findByQniqueId(deviceKey.getDeviceUniqueId());
			DeviceKey key = deviceKeyMapper.findByKey(deviceKey.getDeviceKey());

			if(qnique!=null && deviceKey.getId() !=null &&
					qnique.getId().intValue()!=deviceKey.getId().intValue()){
				return new ResponseDTO(ExceptionCode.qnique_id_exist.errorCode,ExceptionCode.qnique_id_exist.errorMsg);
			}
			if(qnique!=null && deviceKey.getId() ==null){
				return new ResponseDTO(ExceptionCode.qnique_id_exist.errorCode,ExceptionCode.qnique_id_exist.errorMsg);
			}

			if(key!=null && deviceKey.getId() !=null &&
					key.getId().intValue()!=deviceKey.getId().intValue()){
				return new ResponseDTO(ExceptionCode.device_key_exist.errorCode,ExceptionCode.device_key_exist.errorMsg);
			}
			if(key!=null && deviceKey.getId() ==null){
				return new ResponseDTO(ExceptionCode.device_key_exist.errorCode,ExceptionCode.device_key_exist.errorMsg);
			}
		}

		if (deviceKey.getId() != null && deviceKey.getId() > 0) {
			// 更新
			deviceKeyMapper.update(deviceKey);
		} else {
			// 新建
			deviceKey.setStatus(DeviceKeyStatusEnum.noUsered.value);
			deviceKeyMapper.insert(deviceKey);
		}
		return new ResponseDTO();
	}

	/**
	 * 更新设备唯一序列号
 	 *
	 * @param deviceKey 设备唯一序列号
	 */
	@Override
	@Transactional
    public void update(DeviceKey deviceKey) {
		deviceKeyMapper.update(deviceKey);
	}

	/**
	 * 删除设备唯一序列号
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
		return deviceKeyMapper.delete(id);
	}

	/**
	 * 删除设备唯一序列号
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
		return deviceKeyMapper.deleteByIds(ids);
	}

	/**
	 * 查询设备唯一序列号
	 *
	 * @param id 编号
	 * @return 设备唯一序列号
	 */
	public DeviceKey findById(Integer id) {
		return deviceKeyMapper.findById(id);
	}

	/**
	 * 查询设备唯一序列号
	 *
	 * @param pagination 分页信息
	 * @return 分页结果
	 */
	@Override
	public Pagination findPage(Pagination pagination) {
		PageHelper.startPage(pagination.getPage(), pagination.getPageSize());
		PageHelper.orderBy("id desc");
		pagination.setQueryResult(deviceKeyMapper.findAll());
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

		return deviceKeyMapper.updateStatus(ids, status);
	}

}

