package com.ydd.oms.controller;

import com.yanyun.oms.service.CommonService;
import com.yanyun.oms.service.JxlsExcelView;
import com.ydd.framework.core.controller.BaseController;
import com.ydd.oms.config.shiro.ShiroAdmin;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

/**
 * Controller - oms基类
 *
 * @author xingkong1221
 * @since 2017-09-27
 */
public class OmsController extends BaseController {

    @Resource
    private CommonService commonService;


    protected JxlsExcelView jxlsExcelView;

    @Resource
    public void setJxlsExcelView(JxlsExcelView jxlsExcelView) {
        this.jxlsExcelView = jxlsExcelView;
    }


    /**
     * 获取登录管理员
     *
     * @return 管理员
     */
    public ShiroAdmin getLoginAdmin() {
        return (ShiroAdmin) SecurityUtils.getSubject().getPrincipal();
    }

    /**
     * 获取导出Excel视图
     *
     * @param request
     * @return
     * @throws Exception
     */
    protected ModelAndView getExcelView(HttpServletRequest request) throws Exception {
        String fileName = request.getParameter("fileName");
        return  getExcelView(request, fileName, ".xlsx");
    }


    /**
     * 获取导出Excel视图
     *
     * @param request
     * @return
     * @throws Exception
     */
    protected ModelAndView getExcelView(HttpServletRequest request, String filename, String extension) throws Exception {

        ModelAndView mav = new ModelAndView();
        String filePath = request.getParameter("fileName");
        String location = "static/models/" + filePath;
        String exportPageNum = request.getParameter("exportPageNum");
        jxlsExcelView.setExtension(extension);
        if (null == exportPageNum || "".equals(exportPageNum)) {
            String now = new SimpleDateFormat("yyyyMMddHHmm").format(commonService.getCurrentTime());
            jxlsExcelView.setFileName(filename + "_" + now + extension);
        } else {
            jxlsExcelView.setFileName(filename + "_" + exportPageNum + extension);
        }
        jxlsExcelView.setLocation(location);
        mav.setView(jxlsExcelView);
        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");
        DecimalFormat df = new DecimalFormat("##0.00");
        mav.addObject("decimalFormat", df);
        mav.addObject("timeFormat", timeFormat);
        mav.addObject("dateFormat", dateFormat);

        return mav;
    }

}
