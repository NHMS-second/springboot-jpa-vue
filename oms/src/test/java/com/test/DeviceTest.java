package com.test;

import com.yanyun.oms.service.DeviceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.NONE)
public class DeviceTest {

    @Resource
    private DeviceService deviceService;

    @Test
    public void test(){
        //deviceService.statisticsNewDeviceEveryDay(null,null);
    }
}
