package com.yanyun.oms.service.impl;

import com.github.pagehelper.PageHelper;
import com.yanyun.oms.dto.StatisticsNewDeviceDTO;
import com.yanyun.oms.entity.device.Device;
import com.yanyun.oms.mapper.DeviceMapper;
import com.yanyun.oms.service.DeviceService;
import com.ydd.framework.core.common.Pagination;
import com.ydd.framework.core.entity.enums.StatusEnum;
import com.ydd.framework.core.service.impl.BaseServiceImpl;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

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
	/**
	 * 每日设备新增统计
	 * @return
	 */
	@Override
	public LinkedHashMap<String, Integer> statisticsNewDeviceEveryDay(Date date){
		if(date == null){
			//默认显示当月
			date = getCurrentDate();
		}
		Calendar endDay = Calendar.getInstance();
		endDay.setTime(date);
		//将日期变成下个月
		endDay.set(Calendar.MONTH,endDay.get(Calendar.MONTH)+1);
		//将日期变成下个月 1号
		endDay.set(Calendar.DAY_OF_MONTH,1);
		//将日期减一天 自动变成上月最后一天
		endDay.add(Calendar.DAY_OF_MONTH,-1);
		List<String> dates = new ArrayList<>();
		List<String> datesKey = new ArrayList<>();
		int days = endDay.get(Calendar.DAY_OF_MONTH);
		for(int i = 1; i <= days;i++){
			endDay.set(Calendar.DAY_OF_MONTH,i);
			dates.add(DateFormatUtils.format(endDay.getTime(),"yyyy-MM-dd"));
			datesKey.add(DateFormatUtils.format(endDay.getTime(),"MM-dd"));
		}
		List<StatisticsNewDeviceDTO> deviceNumList =  deviceMapper.statisticsNewDeviceEveryDay(dates);
		Map<String,Integer> deviceNumMapTmp = new HashMap<>();
		for(StatisticsNewDeviceDTO deviceNum : deviceNumList){
			deviceNumMapTmp.put(deviceNum.getDate(),deviceNum.getDeviceNum());
		}
		LinkedHashMap<String,Integer> deviceNumMap = new LinkedHashMap<>();
		for(String d : datesKey){
			if(deviceNumMapTmp.get(d) != null){
				deviceNumMap.put(d,deviceNumMapTmp.get(d));
			}else{
				deviceNumMap.put(d,0);
			}
		}

		return deviceNumMap;
	}

	/**
	 * 获取所有离线设备
	 * @return
	 */
	@Override
	public List<Device> findAllOfflineDevice() {
		return deviceMapper.findByStatus(2);
	}

	@Override
	public Integer findAllDeviceNum() {
		return deviceMapper.countByStatus(null);
	}

	@Override
	public Integer findOfflineDeviceNum() {
		return deviceMapper.countByStatus(2);
	}

	@Override
	public Integer findOnlineDeviceNum() {
		return deviceMapper.countByStatus(1);
	}

	@Override
	public Integer findErrorDeviceNum() {
		return deviceMapper.countByStatus(3);
	}
}

