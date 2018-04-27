package com.yanyun.oms.controller;
import com.ydd.framework.core.common.Pagination;
import com.ydd.framework.core.common.dto.ResponseDTO;
import com.ydd.oms.controller.OmsController;
import com.yanyun.oms.entity.DeviceStatusLog;
import com.yanyun.oms.service.DeviceStatusLogService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Controller - 设备上下线记录
 *
 * @author zhaoziyu
 * @since 2018-04-27
 */
@RestController
public class DeviceStatusLogController extends OmsController {

	private final Logger logger = LoggerFactory.getLogger(DeviceStatusLogController.class);
	
	@Resource
	private DeviceStatusLogService deviceStatusLogService;

	/**
	 * 分页查询设备上下线记录
	 */
	@RequestMapping(value = "/device/status/logs", method = RequestMethod.GET)
	public ResponseDTO findPage(Pagination pagination,@RequestParam("deviceId") Integer deviceId) {
		return ResponseDTO.ok()
				.setPagination(deviceStatusLogService.findPage(pagination,deviceId));
	}

}
