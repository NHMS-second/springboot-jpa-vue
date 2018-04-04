package com.yanyun.oms.controller.member;
import com.yanyun.oms.service.CommonService;
import com.yanyun.oms.service.MemberService;
import com.ydd.framework.core.common.Pagination;
import com.ydd.framework.core.common.dto.ResponseDTO;
import com.ydd.framework.core.entity.enums.StatusEnum;
import com.ydd.oms.controller.OmsController;
import com.yanyun.oms.entity.member.Member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

	@Resource
	private CommonService commonService;

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


	/**
	 * 导出
	 * @return
	 */
	@RequestMapping(value = "/member/exportTest", method = RequestMethod.GET)
	public ModelAndView exportTest(HttpServletRequest request) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String now = sdf.format(new Date());
			request.setAttribute("fileName","Member");
			request.setAttribute("now",now);
			ModelAndView model = getExcelView(request);
			//List<Member> members = memberService.findAll(null);
			//model.addObject("result", members);
			return model;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 导出
	 * @return
	 */
	@RequestMapping(value = "/member/export", method = RequestMethod.GET)
	public void exportTest(HttpServletRequest request, HttpServletResponse response) {
	    //en:英文  cn:中文
	    String language = request.getParameter("language");
		File file = memberService.exportExcel(language);
		response.setContentLength((int) file.length());
		response.setHeader("Content-Disposition", "attachment;filename="
				+ "users.xlsx");// 设置在下载框默认显示的文件名
		response.setContentType("application/octet-stream");// 指明response的返回对象是文件流
		// 读出文件到response
		// 这里是先需要把要把文件内容先读到缓冲区
		// 再把缓冲区的内容写到response的输出流供用户下载
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(
                    fileInputStream);
            byte[] b = new byte[bufferedInputStream.available()];
            bufferedInputStream.read(b);
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(b);
            bufferedInputStream.close();
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

	}


}
