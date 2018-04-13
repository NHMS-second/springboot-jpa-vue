package com.ydd.oms.controller;

import com.ydd.framework.core.common.dto.ResponseDTO;
import com.ydd.oms.service.UploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * Controller - oms基类
 *
 * @author xingkong1221
 * @since 2017-09-27
 */
@RestController
public class UploadController {

    private Logger logger = LoggerFactory.getLogger(UploadController.class);


    @Resource
    private UploadService uploadService;
    /**
     * 上传文件
     * @param fileData
     * @return
     */
    @RequestMapping(value = "/uploadFiles", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO uploadFiles(@RequestParam("file") MultipartFile fileData) {
       return uploadService.uploadFile(fileData);
    }


    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO importExcel(@RequestParam("file") MultipartFile fileData) {
        return uploadService.uploadExcel(fileData);
    }

}
