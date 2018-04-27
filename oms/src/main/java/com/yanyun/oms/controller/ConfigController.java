package com.yanyun.oms.controller;
import com.ydd.framework.core.common.Pagination;
import com.ydd.framework.core.common.dto.ResponseDTO;
import com.ydd.oms.controller.OmsController;
import com.yanyun.oms.entity.Config;
import com.yanyun.oms.service.ConfigService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Controller - 系统参数
 *
 * @author zhaoziyu
 * @since 2018-04-27
 */
@RestController
public class ConfigController extends OmsController {

	private final Logger logger = LoggerFactory.getLogger(ConfigController.class);
	
	@Resource
	private ConfigService configService;

	/**
	 * 分页查询系统参数
	 */
	@RequestMapping(value = "/configs", method = RequestMethod.GET)
	public ResponseDTO findPage(Pagination pagination) {
		return ResponseDTO.ok()
				.setPagination(configService.findPage(pagination));
	}

	/**
	 * 查询系统参数信息
	 */
	@RequestMapping(value = "/config/{id}", method = RequestMethod.GET)
	public ResponseDTO findById(@PathVariable("id") Integer id) {
		return ResponseDTO.ok()
				.addAttribute("config", configService.findById(id));
	}

	/**
	 * 保存系统参数
	 */
	@RequestMapping(value = "/config", method = RequestMethod.POST)
	public ResponseDTO save(Config config) {
		configService.save(config);
		return ResponseDTO.ok("保存成功");
	}

	/**
	 * 删除系统参数
	 */
	@RequestMapping(value = "/config/delete", method = RequestMethod.POST)
	public ResponseDTO delete(@RequestParam("id[]") Integer[] ids) {
		configService.deleteByIds(ids);
		return ResponseDTO.ok("删除成功");
	}

}
