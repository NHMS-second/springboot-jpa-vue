package com.yanyun.oms.controller;
import com.ydd.framework.core.common.Pagination;
import com.ydd.framework.core.common.dto.ResponseDTO;
import com.ydd.oms.controller.OmsController;
import com.yanyun.oms.entity.MemberOpinion;
import com.yanyun.oms.service.MemberOpinionService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Controller - 用户反馈
 *
 * @author zhaoziyu
 * @since 2018-04-28
 */
@RestController
public class MemberOpinionController extends OmsController {

	private final Logger logger = LoggerFactory.getLogger(MemberOpinionController.class);
	
	@Resource
	private MemberOpinionService memberOpinionService;

	/**
	 * 分页查询用户反馈
	 */
	@RequestMapping(value = "/member/opinions", method = RequestMethod.GET)
	public ResponseDTO findPage(Pagination pagination) {
		return ResponseDTO.ok()
				.setPagination(memberOpinionService.findPage(pagination));
	}

	/**
	 * 查询用户反馈信息
	 */
	@RequestMapping(value = "/member/opinion/{id}", method = RequestMethod.GET)
	public ResponseDTO findById(@PathVariable("id") Integer id) {
		return ResponseDTO.ok()
				.addAttribute("memberOpinion", memberOpinionService.findById(id));
	}

	/**
	 * 保存用户反馈
	 */
	@RequestMapping(value = "/member/opinion", method = RequestMethod.POST)
	public ResponseDTO save(MemberOpinion memberOpinion) {
		memberOpinionService.save(memberOpinion);
		return ResponseDTO.ok("保存成功");
	}

	/**
	 * 删除用户反馈
	 */
	@RequestMapping(value = "/member/opinion/delete", method = RequestMethod.POST)
	public ResponseDTO delete(@RequestParam("id[]") Integer[] ids) {
		memberOpinionService.deleteByIds(ids);
		return ResponseDTO.ok("删除成功");
	}

}
