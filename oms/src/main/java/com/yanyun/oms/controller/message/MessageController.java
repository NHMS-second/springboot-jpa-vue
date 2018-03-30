package com.yanyun.oms.controller.message;
import com.yanyun.oms.enums.MessageTypeEnEnum;
import com.yanyun.oms.service.MessageService;
import com.ydd.framework.core.common.Pagination;
import com.ydd.framework.core.common.dto.ResponseDTO;
import com.ydd.oms.controller.OmsController;
import com.yanyun.oms.entity.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Controller - 系统消息
 *
 * @author Demon
 * @since 2018-03-29
 */
@RestController
public class MessageController extends OmsController {

	private final Logger logger = LoggerFactory.getLogger(MessageController.class);
	
	@Resource
	private MessageService messageService;

	/**
	 * 分页查询系统消息
	 */
	@RequestMapping(value = "/messages", method = RequestMethod.GET)
	public ResponseDTO findPage(Pagination pagination) {
		return ResponseDTO.ok()
				.setPagination(messageService.findPage(pagination));
	}

	/**
	 * 查询系统消息信息
	 */
	@RequestMapping(value = "/message/{id}", method = RequestMethod.GET)
	public ResponseDTO findById(@PathVariable("id") Integer id) {
		return ResponseDTO.ok()
				.addAttribute("message", messageService.findById(id));
	}

	/**
	 * 保存系统消息
	 */
	@RequestMapping(value = "/message", method = RequestMethod.POST)
	public ResponseDTO save(Message message) {
		message.setType(MessageTypeEnEnum.system.value);
		messageService.save(message);
		return ResponseDTO.ok("保存成功");
	}

	/**
	 * 删除系统消息
	 */
	@RequestMapping(value = "/message/delete", method = RequestMethod.POST)
	public ResponseDTO delete(@RequestParam("id[]") Integer[] ids) {
		messageService.deleteByIds(ids);
		return ResponseDTO.ok("删除成功");
	}

}
