package com.yanyun.oms.task;

import com.yanyun.oms.service.DeviceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 统计设备在线时间
 */
@Component
public class DeviceOnlineTimeTask {

    @Resource
    private DeviceService deviceService;

    private final Logger logger = LoggerFactory.getLogger(DeviceStatusTask.class);


    /**
     * 60秒执行一次
     */
    @Scheduled(fixedDelay = 60000)
    public void execute() {
        logger.info("累加设备在线时间");
        List<Integer> ids = deviceService.findAllOnlineDevice();
        //为在线的设备累计60秒在线时间
        if (ids != null && ids.size() > 0)
            deviceService.addOnlineTime(60, ids);
    }
}
