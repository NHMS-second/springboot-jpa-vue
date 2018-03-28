package com.ydd.oms.service;

import com.google.common.collect.Maps;
import com.yanyun.oms.mapper.MemberMapper;
import com.ydd.framework.core.common.dto.ResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class UploadService {

	@Resource
	private MemberMapper memberMapper;


	// 查询当前时间
	public Date getCurrentTime() {
		return  memberMapper.findNow().getNow();
	}


	public ResponseDTO uploadFile(MultipartFile fileData) {
		ResponseDTO rsp = new ResponseDTO();
		Map<String, Object> result = Maps.newHashMap();
		result.put("status", "ok");
		try {
			if (fileData != null ) {
				// 循环获取file数组中得文件
				MultipartFile file = fileData;
				String fileName = file.getOriginalFilename();
				String fName = "";
				if(fileName.contains(".")){
					fName = fileName.split("\\.")[0];
				}
				File f = new File("/opt/"+fileName);
				//File f = new File("D:\\sssss\\"+fileName);
				if(f.exists()){
					f.delete();
				}
				inputstreamtofile(file.getInputStream(),f);
				rsp.addAttribute("fileName",fileName);
				rsp.addAttribute("name",fName);
				rsp.addAttribute("bytes",file.getSize());
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", "error");
		}
		return rsp;
	}


	private void inputstreamtofile(InputStream ins, File file) throws Exception{
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
