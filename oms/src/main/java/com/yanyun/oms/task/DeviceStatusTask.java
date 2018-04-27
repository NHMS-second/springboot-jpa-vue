package com.yanyun.oms.task;

import com.yanyun.oms.entity.device.Device;
import com.yanyun.oms.service.ConfigService;
import com.yanyun.oms.service.DeviceService;
import com.yanyun.oms.service.impl.DeviceServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 检测设备离线时间
 */
@Component
public class DeviceStatusTask {

    private final Logger logger = LoggerFactory.getLogger(DeviceStatusTask.class);

    @Resource
    private DeviceService deviceService;

    @Resource
    private ConfigService configService;

    /**
     * 10秒执行一次
     */
    @Scheduled(fixedDelay = 10000)
    public void execute(){
        logger.info("开始检测设备离线时间");
        Long time = configService.findDeviceErrorTime();
        Date now = new Date();
        List<Device> devices = deviceService.findAllOfflineDevice();
        List<Integer> errorDeviceIds = new ArrayList<>();
        if(devices != null && devices.size() > 0){
            for(Device device : devices){
                if(device.getOfflineTime() == null)
                    continue;
                //设备已经离线的秒数
                long offlineTime =  (now.getTime() - device.getOfflineTime().getTime()/1000);
                if(offlineTime > time){
                    //超过离线时间阈值 将设备变成异常状态
                    errorDeviceIds.add(device.getId());
                }
            }
        }
        if(errorDeviceIds.size() > 0)
            deviceService.updateStatus(errorDeviceIds.toArray(new Integer[errorDeviceIds.size()]),(byte)3);
    }
}
