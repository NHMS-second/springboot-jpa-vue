package com.ydd.oms.controller;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.google.common.collect.Maps;
import com.ydd.framework.core.common.dto.ResponseDTO;
import com.ydd.framework.core.controller.BaseController;
import com.ydd.oms.config.shiro.ShiroAdmin;
import com.ydd.oms.util.S3Sample;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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


    @RequestMapping(value = "/uploadFiles", method = RequestMethod.GET)
    public Map getaa(){
        return  null;
    }

    /**
     * 上传文件(多张图片)
     * @param fileData
     * @return
     */
    @RequestMapping(value = "/uploadFiles", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO uploadImgAndCheckSize(@RequestParam("file") MultipartFile[] fileData) {
        ResponseDTO rsp = new ResponseDTO();
        Map<String, Object> result = Maps.newHashMap();
        result.put("status", "ok");
        try {
            if (fileData != null && fileData.length > 0) {
                // 循环获取file数组中得文件
                for (int i = 0; i < fileData.length; i++) {
                    MultipartFile file = fileData[i];
                    long size = file.getSize();
                    /*if(size > 1024*1024L){//上传图片不能大于1M
                        result.put("status", "-1");
                        return result;
                    }*/

                    String fileName = file.getOriginalFilename();
                    String fName = "";
                    if(fileName.contains(".")){
                        fName = fileName.split("\\.")[0];
                    }
                    //File f = new File("/opt/"+fileName);
                    File f = new File("D:\\sssss\\"+fileName);
                    inputstreamtofile(file.getInputStream(),f);

                    /*String bucketName = "yanyun";
                    String key = "b6.png";
                    AmazonS3 amazon = S3Sample.getAmazon();
                    ObjectMetadata bb = new ObjectMetadata();
                    bb.setContentLength(file.getSize());
                    amazon.putObject(bucketName,key,file.getInputStream(),bb);


                    amazon.getObject(new GetObjectRequest(bucketName, key));
                    //获取一个request
                    GeneratePresignedUrlRequest urlRequest = new GeneratePresignedUrlRequest(
                            bucketName, key);
                    Date expirationDate = null;
                    try {
                        expirationDate = new SimpleDateFormat("yyyy-MM-dd").parse("2018-03-29");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //设置过期时间
                    urlRequest.setExpiration(expirationDate);
                    //生成公用的url
                    URL url = amazon.generatePresignedUrl(urlRequest);
                    System.out.println("=========URL=================" + url + "============URL=============");
                    if (url == null) {
                        throw new RuntimeException("can't get s3 file url!");
                    }
                    logger.info(url.toString());*/

                    //result.put("fileName", file.getOriginalFilename());
                    rsp.addAttribute("fileName",fName);
                    //result.put("url", ret);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("status", "error");
        }
        return rsp;
    }


    public void inputstreamtofile(InputStream ins, File file) throws Exception{
        OutputStream os = new FileOutputStream(file);
        int bytesRead = 0;
        byte[] buffer = new byte[8192];
        while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
            os.write(buffer, 0, bytesRead);
        }
        os.close();
        ins.close();
    }

}
