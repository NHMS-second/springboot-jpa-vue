package com.ydd.oms.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.yanyun.oms.entity.device.Device;
import com.yanyun.oms.entity.deviceKey.DeviceKey;
import com.yanyun.oms.enums.DeviceKeyStatusEnum;
import com.yanyun.oms.mapper.DeviceKeyMapper;
import com.yanyun.oms.mapper.MemberMapper;
import com.ydd.framework.core.common.dto.ResponseDTO;
import com.ydd.oms.enums.ExceptionCode;
import com.ydd.oms.util.ExcelUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
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
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Service
@Transactional(readOnly = true)
public class UploadService {

	@Resource
	private MemberMapper memberMapper;


	@Resource
	private DeviceKeyMapper deviceKeyMapper;


	// 查询当前时间
	public Date getCurrentTime() {
		return  memberMapper.findNow().getNow();
	}


	@Transactional
	public ResponseDTO uploadExcel(MultipartFile fileData) {
		try {
			if (fileData != null ) {
				// 循环获取file数组中得文件
					MultipartFile file = fileData;

					List<Row> list = new ExcelUtils().parseExcelToRows(file.getInputStream());
					List<DeviceKey> lists = Lists.newArrayList();
					for(int j=0;j < list.size();j++){
						Row row = list.get(j);
						
						//设备唯一ID ,假设在第二列
						Cell qniqueCell = row.getCell(1);
						Cell keyCell = row.getCell(3);
						if(qniqueCell == null || keyCell ==null){
							continue;
						}
						if(qniqueCell.getCellType()==3 && keyCell.getCellType()==3){
							continue;
						}else {
							if(qniqueCell.getCellType()!=1){
								return new ResponseDTO(ExceptionCode.excel_qnique_id_error.errorCode,ExceptionCode.excel_qnique_id_error.errorMsg);
							}

							//设备唯一KEY ,假设在第三列
							if(keyCell.getCellType()!=1){
								return new ResponseDTO(ExceptionCode.excel_device_key_error.errorCode,ExceptionCode.excel_device_key_error.errorMsg);
							}
						}


						String qnique_id = qniqueCell.getStringCellValue().trim();
						String device_key = keyCell.getStringCellValue().trim();


//						if(qnique!=null){
//							return new ResponseDTO(ExceptionCode.qnique_id_exist.errorCode,
//									qnique_id+":"+ExceptionCode.qnique_id_exist.errorMsg);
//						}
//						if(key!=null){
//							return new ResponseDTO(ExceptionCode.device_key_exist.errorCode,
//									device_key+":"+ExceptionCode.device_key_exist.errorMsg);
//						}

						DeviceKey device = new DeviceKey();
						device.setDeviceUniqueId(qnique_id);
						device.setDeviceKey(device_key);
						lists.add(device);
					}

					for(DeviceKey d : lists){
						DeviceKey qnique = deviceKeyMapper.findByQniqueId(d.getDeviceUniqueId());
						if(qnique != null)
							continue;
						d.setStatus(DeviceKeyStatusEnum.noUsered.value);
						deviceKeyMapper.insert(d);
					}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseDTO(ExceptionCode.EXCEL_FILE_STREAM_ERROR.errorCode,ExceptionCode.EXCEL_FILE_STREAM_ERROR.errorMsg);
		}
		return new ResponseDTO();
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
				//File f = new File("C:\\Users\\Administrator\\Desktop\\"+fileName);
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
