package com.yanyun.oms.controller.deviceKey;
import com.yanyun.oms.enums.DeviceKeyStatusEnum;
import com.yanyun.oms.service.DeviceKeyService;
import com.ydd.framework.core.common.Pagination;
import com.ydd.framework.core.common.dto.ResponseDTO;
import com.ydd.framework.core.entity.enums.StatusEnum;
import com.ydd.oms.controller.OmsController;
import com.yanyun.oms.entity.deviceKey.DeviceKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Controller - 设备唯一序列号
 *
 * @author Demon
 * @since 2018-03-30
 */
@RestController
public class DeviceKeyController extends OmsController {

	private final Logger logger = LoggerFactory.getLogger(DeviceKeyController.class);
	
	@Resource
	private DeviceKeyService deviceKeyService;

	/**
	 * 分页查询设备唯一序列号
	 */
	@RequestMapping(value = "/device/keys", method = RequestMethod.GET)
	public ResponseDTO findPage(Pagination pagination) {
		return ResponseDTO.ok()
				.setPagination(deviceKeyService.findPage(pagination));
	}

	/**
	 * 查询设备唯一序列号信息
	 */
	@RequestMapping(value = "/device/key/{id}", method = RequestMethod.GET)
	public ResponseDTO findById(@PathVariable("id") Integer id) {
		return ResponseDTO.ok()
				.addAttribute("deviceKey", deviceKeyService.findById(id));
	}

	/**
	 * 保存设备唯一序列号
	 */
	@RequestMapping(value = "/device/key", method = RequestMethod.POST)
	public ResponseDTO save(DeviceKey deviceKey) {
		return deviceKeyService.save(deviceKey);
	}

	/**
	 * 删除设备唯一序列号
	 */
	@RequestMapping(value = "/device/key/delete", method = RequestMethod.POST)
	public ResponseDTO delete(@RequestParam("id[]") Integer[] ids) {
		deviceKeyService.deleteByIds(ids);
		return ResponseDTO.ok("删除成功");
	}

	/**
	 * 变更设备唯一序列号状态
	 */
	/*@RequestMapping(value = "/device/key/status", method = RequestMethod.POST)
	public ResponseDTO updateStatus(@RequestParam("id[]") Integer[] ids, Byte status) {
		deviceKeyService.updateStatus(ids, status);
		String operationName = (StatusEnum.ENABLE.value.equals(status) ? "启用" : "禁用") + "成功";
		return ResponseDTO.ok(operationName);
	}*/

}
