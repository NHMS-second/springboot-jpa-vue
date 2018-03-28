package com.yanyun.oms.service;

import com.yanyun.oms.mapper.MemberMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;
import java.util.Date;

@Service
@Transactional(readOnly = true)
public class CommonService {

	@Resource
	private MemberMapper memberMapper;


	// 查询当前时间
	public Date getCurrentTime() {
		return  memberMapper.findNow().getNow();
	}


}
