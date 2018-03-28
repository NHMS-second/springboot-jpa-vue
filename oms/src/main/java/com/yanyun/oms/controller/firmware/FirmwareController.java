package com.yanyun.oms.controller.firmware;
import com.yanyun.oms.service.FirmwareService;
import com.ydd.framework.core.common.Pagination;
import com.ydd.framework.core.common.dto.ResponseDTO;
import com.ydd.oms.controller.OmsController;
import com.yanyun.oms.entity.firmware.Firmware;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Controller - 设备固件
 *
 * @author Demon
 * @since 2018-03-27
 */
@RestController
public class FirmwareController extends OmsController {

	private final Logger logger = LoggerFactory.getLogger(FirmwareController.class);
	
	@Resource
	private FirmwareService firmwareService;

	/**
	 * 分页查询设备固件
	 */
	@RequestMapping(value = "/firmwares", method = RequestMethod.GET)
	public ResponseDTO findPage(Pagination pagination) {
		return ResponseDTO.ok()
				.setPagination(firmwareService.findPage(pagination));
	}

	/**
	 * 查询设备固件信息
	 */
	@RequestMapping(value = "/firmware/{id}", method = RequestMethod.GET)
	public ResponseDTO findById(@PathVariable("id") Integer id) {
		return ResponseDTO.ok()
				.addAttribute("firmware", firmwareService.findById(id));
	}

	/**
	 * 保存设备固件
	 */
	@RequestMapping(value = "/firmware", method = RequestMethod.POST)
	public ResponseDTO save(Firmware firmware) {
		firmwareService.save(firmware);
		return ResponseDTO.ok("保存成功");
	}

	/**
	 * 删除设备固件
	 */
	@RequestMapping(value = "/firmware/delete", method = RequestMethod.POST)
	public ResponseDTO delete(@RequestParam("id[]") Integer[] ids) {
		firmwareService.deleteByIds(ids);
		return ResponseDTO.ok("删除成功");
	}

}
