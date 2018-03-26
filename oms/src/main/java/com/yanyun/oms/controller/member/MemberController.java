package com.yanyun.oms.controller.member;
import com.yanyun.oms.service.MemberService;
import com.ydd.framework.core.common.Pagination;
import com.ydd.framework.core.common.dto.ResponseDTO;
import com.ydd.framework.core.entity.enums.StatusEnum;
import com.ydd.oms.controller.OmsController;
import com.yanyun.oms.entity.member.Member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Controller - 会员
 *
 * @author Demon
 * @since 2018-03-26
 */
@RestController
public class MemberController extends OmsController {

	private final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Resource
	private MemberService memberService;

	/**
	 * 分页查询会员
	 */
	@RequestMapping(value = "/members", method = RequestMethod.GET)
	public ResponseDTO findPage(Pagination pagination) {
		return ResponseDTO.ok()
				.setPagination(memberService.findPage(pagination));
	}

	/**
	 * 查询会员信息
	 */
	@RequestMapping(value = "/member/{id}", method = RequestMethod.GET)
	public ResponseDTO findById(@PathVariable("id") Integer id) {
		return ResponseDTO.ok()
				.addAttribute("member", memberService.findById(id));
	}

	/**
	 * 保存会员
	 */
	@RequestMapping(value = "/member", method = RequestMethod.POST)
	public ResponseDTO save(Member member) {
		memberService.save(member);
		return ResponseDTO.ok("保存成功");
	}

	/**
	 * 删除会员
	 */
	@RequestMapping(value = "/member/delete", method = RequestMethod.POST)
	public ResponseDTO delete(@RequestParam("id[]") Integer[] ids) {
		memberService.deleteByIds(ids);
		return ResponseDTO.ok("删除成功");
	}

	/**
	 * 变更会员状态
	 */
	@RequestMapping(value = "/member/status", method = RequestMethod.POST)
	public ResponseDTO updateStatus(@RequestParam("id[]") Integer[] ids, Integer status) {
		memberService.updateStatus(ids, status);
		String operationName = "成功";
		return ResponseDTO.ok(operationName);
	}

}
