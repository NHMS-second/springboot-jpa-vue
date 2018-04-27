package com.yanyun.oms.controller;

import com.yanyun.oms.service.DeviceKeyService;
import com.yanyun.oms.service.DeviceService;
import com.yanyun.oms.service.MemberService;
import com.ydd.framework.core.common.dto.ResponseDTO;
import com.ydd.oms.controller.OmsController;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Date;

@RestController
public class DashboardController extends OmsController {

    @Resource
    private DeviceKeyService deviceKeyService;

    @Resource
    private MemberService memberService;

    @Resource
    private DeviceService deviceService;

    @RequestMapping(value = "/dashboard",method = RequestMethod.GET)
    public ResponseDTO dashboard(){
        ResponseDTO res = ResponseDTO.ok();
        Integer totalDeviceKeyNum = deviceKeyService.getDeviceKeyTotalNum();
        Integer usedDeviceKeyNum = deviceKeyService.getDeviceKeyUsedNum();
        Integer notUsedDeviceKeyNum = deviceKeyService.getDeviceKeyNotUsedNum();
        Integer todayMemberCount = memberService.getNewMemberToday();
        res.addAttribute("totalDeviceKeyNum",totalDeviceKeyNum);
        res.addAttribute("usedDeviceKeyNum",usedDeviceKeyNum);
        res.addAttribute("notUsedDeviceKeyNum",notUsedDeviceKeyNum);
        res.addAttribute("todayMemberCount",todayMemberCount);

        res.addAttribute("allDeviceNum",deviceService.findAllDeviceNum());
        res.addAttribute("onlineDeviceNum",deviceService.findOnlineDeviceNum());
        res.addAttribute("offlineDeviceNum",deviceService.findOfflineDeviceNum());
        res.addAttribute("errorDeviceNum",deviceService.findErrorDeviceNum());

        return res;
    }

    /**
     * 服务器时间
     * @return
     */
    @RequestMapping(value = "/current",method = RequestMethod.GET)
    public ResponseDTO currentTime(){
        ResponseDTO res = ResponseDTO.ok();
        res.addAttribute("time", DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
        return res;
    }

    /**
     * 某月每日新增设备数量
     * @param month
     * @return
     */
    @RequestMapping(value = "/statistics/device",method = RequestMethod.GET)
    public ResponseDTO newDeviceNum(@RequestParam(value = "month",required = false)String month){
        ResponseDTO res = ResponseDTO.ok();
        Date date = null;
        if(!StringUtils.isEmpty(month)){
            try {
                date = DateUtils.parseDate(month,"yyyy-MM-dd");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        res.addAttribute("data",deviceService.statisticsNewDeviceEveryDay(date));
        return res;
    }

}
