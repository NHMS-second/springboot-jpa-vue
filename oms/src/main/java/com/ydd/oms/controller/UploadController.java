package com.ydd.oms.controller;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.google.common.collect.Maps;
import com.yanyun.oms.entity.firmware.Firmware;
import com.yanyun.oms.service.FirmwareService;
import com.ydd.framework.core.common.dto.ResponseDTO;
import com.ydd.framework.core.controller.BaseController;
import com.ydd.oms.config.shiro.ShiroAdmin;
import com.ydd.oms.service.UploadService;
import com.ydd.oms.util.S3Sample;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import static com.ydd.oms.util.S3Sample.getAmazon;

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

}
