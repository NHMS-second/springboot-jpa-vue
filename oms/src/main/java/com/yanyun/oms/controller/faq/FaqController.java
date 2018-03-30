package com.yanyun.oms.controller.faq;
import com.yanyun.oms.service.FaqService;
import com.ydd.framework.core.common.Pagination;
import com.ydd.framework.core.common.dto.ResponseDTO;
import com.ydd.oms.controller.OmsController;
import com.yanyun.oms.entity.faq.Faq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Controller - 常见问题
 *
 * @author Demon
 * @since 2018-03-30
 */
@RestController
public class FaqController extends OmsController {

	private final Logger logger = LoggerFactory.getLogger(FaqController.class);
	
	@Resource
	private FaqService faqService;

	/**
	 * 分页查询常见问题
	 */
	@RequestMapping(value = "/faqs", method = RequestMethod.GET)
	public ResponseDTO findPage(Pagination pagination) {
		return ResponseDTO.ok()
				.setPagination(faqService.findPage(pagination));
	}

	/**
	 * 查询常见问题信息
	 */
	@RequestMapping(value = "/faq/{id}", method = RequestMethod.GET)
	public ResponseDTO findById(@PathVariable("id") Integer id) {
		return ResponseDTO.ok()
				.addAttribute("faq", faqService.findById(id));
	}

	/**
	 * 保存常见问题
	 */
	@RequestMapping(value = "/faq", method = RequestMethod.POST)
	public ResponseDTO save(Faq faq) {
		faqService.save(faq);
		return ResponseDTO.ok("保存成功");
	}

	/**
	 * 删除常见问题
	 */
	@RequestMapping(value = "/faq/delete", method = RequestMethod.POST)
	public ResponseDTO delete(@RequestParam("id[]") Integer[] ids) {
		faqService.deleteByIds(ids);
		return ResponseDTO.ok("删除成功");
	}

}
