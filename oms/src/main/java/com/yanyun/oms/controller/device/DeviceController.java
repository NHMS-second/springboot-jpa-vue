package com.yanyun.oms.controller.device;
import com.yanyun.oms.service.DeviceService;
import com.ydd.framework.core.common.Pagination;
import com.ydd.framework.core.common.dto.ResponseDTO;
import com.ydd.framework.core.entity.enums.StatusEnum;
import com.ydd.oms.controller.OmsController;
import com.yanyun.oms.entity.device.Device;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Controller - 设备
 *
 * @author Demon
 * @since 2018-03-30
 */
@RestController
public class DeviceController extends OmsController {

	private final Logger logger = LoggerFactory.getLogger(DeviceController.class);
	
	@Resource
	private DeviceService deviceService;

	/**
	 * 分页查询设备
	 */
	@RequestMapping(value = "/devices", method = RequestMethod.GET)
	public ResponseDTO findPage(Pagination pagination) {
		return ResponseDTO.ok()
				.setPagination(deviceService.findPage(pagination));
	}

	/**
	 * 查询设备信息
	 */
	@RequestMapping(value = "/device/{id}", method = RequestMethod.GET)
	public ResponseDTO findById(@PathVariable("id") Integer id) {
		return ResponseDTO.ok()
				.addAttribute("device", deviceService.findById(id));
	}

	/**
	 * 保存设备
	 */
	@RequestMapping(value = "/device", method = RequestMethod.POST)
	public ResponseDTO save(Device device) {
		deviceService.save(device);
		return ResponseDTO.ok("保存成功");
	}

	/**
	 * 删除设备
	 */
	@RequestMapping(value = "/device/delete", method = RequestMethod.POST)
	public ResponseDTO delete(@RequestParam("id[]") Integer[] ids) {
		deviceService.deleteByIds(ids);
		return ResponseDTO.ok("删除成功");
	}

	/**
	 * 变更设备状态
	 */
	@RequestMapping(value = "/device/status", method = RequestMethod.POST)
	public ResponseDTO updateStatus(@RequestParam("id[]") Integer[] ids, Byte status) {
		deviceService.updateStatus(ids, status);
		String operationName = (StatusEnum.ENABLE.value.equals(status) ? "启用" : "禁用") + "成功";
		return ResponseDTO.ok(operationName);
	}

}
