package com.yanyun.oms.controller;
import com.ydd.framework.core.common.Pagination;
import com.ydd.framework.core.common.dto.ResponseDTO;
import com.ydd.framework.core.entity.enums.StatusEnum;
import com.ydd.oms.controller.OmsController;
import com.yanyun.oms.entity.DeviceKeyLog;
import com.yanyun.oms.service.DeviceKeyLogService;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Controller - 设备ID使用记录
 *
 * @author zhaoziyu
 * @since 2018-05-18
 */
@RestController
public class DeviceKeyLogController extends OmsController {

	private final Logger logger = LoggerFactory.getLogger(DeviceKeyLogController.class);
	
	@Resource
	private DeviceKeyLogService deviceKeyLogService;

	/**
	 * 分页查询设备ID使用记录
	 */
	@RequestMapping(value = "/device/key/logs", method = RequestMethod.GET)
	public ResponseDTO findPage(Pagination pagination,@Param("deviceKeyId") Integer deviceKeyId) {
		return ResponseDTO.ok()
				.setPagination(deviceKeyLogService.findPage(pagination,deviceKeyId));
	}

	/**
	 * 查询设备ID使用记录信息
	 */
	@RequestMapping(value = "/device/key/log/{id}", method = RequestMethod.GET)
	public ResponseDTO findById(@PathVariable("id") Integer id) {
		return ResponseDTO.ok()
				.addAttribute("deviceKeyLog", deviceKeyLogService.findById(id));
	}

	/**
	 * 保存设备ID使用记录
	 */
	@RequestMapping(value = "/device/key/log", method = RequestMethod.POST)
	public ResponseDTO save(DeviceKeyLog deviceKeyLog) {
		deviceKeyLogService.save(deviceKeyLog);
		return ResponseDTO.ok("保存成功");
	}

	/**
	 * 删除设备ID使用记录
	 */
	@RequestMapping(value = "/device/key/log/delete", method = RequestMethod.POST)
	public ResponseDTO delete(@RequestParam("id[]") Integer[] ids) {
		deviceKeyLogService.deleteByIds(ids);
		return ResponseDTO.ok("删除成功");
	}

	/**
	 * 变更设备ID使用记录状态
	 */
	@RequestMapping(value = "/device/key/log/status", method = RequestMethod.POST)
	public ResponseDTO updateStatus(@RequestParam("id[]") Integer[] ids, Byte status) {
		deviceKeyLogService.updateStatus(ids, status);
		String operationName = (StatusEnum.ENABLE.value.equals(status) ? "启用" : "禁用") + "成功";
		return ResponseDTO.ok(operationName);
	}

}
