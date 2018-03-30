package com.yanyun.oms.service.impl;

import com.github.pagehelper.PageHelper;
import com.yanyun.oms.mapper.MessageMapper;
import com.yanyun.oms.service.MessageService;
import com.ydd.framework.core.common.Pagination;
import com.ydd.framework.core.service.impl.BaseServiceImpl;

import com.yanyun.oms.entity.message.Message;

import com.ydd.oms.service.PushService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Service - 系统消息
 *
 * @author Demon
 * @since 2018-03-29
 */
@Service
@Transactional(readOnly = true)
public class MessageServiceImpl extends BaseServiceImpl implements MessageService {

	private final Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);

	@Resource
	private MessageMapper messageMapper;

	@Resource
	private PushService pushService;

	/**
	 * 创建系统消息
	 *
	 * @param message 系统消息
	 */
	@Override
	@Transactional
    public void save(Message message) {
		//推送消息
		this.pushSystemMes();
		if (message.getId() != null && message.getId() > 0) {
			// 更新
			messageMapper.update(message);
		} else {
			// 新建
			messageMapper.insert(message);
		}
	}

	private void pushSystemMes(){

		try {
			//分别推送android和ios消息
			pushService.sendAndroidBroadcast();
			pushService.sendIOSBroadcast();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 更新系统消息
 	 *
	 * @param message 系统消息
	 */
	@Override
	@Transactional
    public void update(Message message) {
		messageMapper.update(message);
	}

	/**
	 * 删除系统消息
	 *
	 * @param id 编号
   	 * @return 删除数量
	 */
	@Override
	@Transactional
    public Integer delete(Integer id) {
		if (id == null || id <= 0) {
			return 0;
		}
		return messageMapper.delete(id);
	}

	/**
	 * 删除系统消息
	 *
	 * @param ids 编号数组
	 * @return 删除数量
	 */
	@Override
	@Transactional
    public Integer deleteByIds(Integer[] ids) {
		if (ids == null || ids.length == 0) {
			return 0;
		}
		return messageMapper.deleteByIds(ids);
	}

	/**
	 * 查询系统消息
	 *
	 * @param id 编号
	 * @return 系统消息
	 */
	public Message findById(Integer id) {
		return messageMapper.findById(id);
	}

	/**
	 * 查询系统消息
	 *
	 * @param pagination 分页信息
	 * @return 分页结果
	 */
	@Override
	public Pagination findPage(Pagination pagination) {
		PageHelper.startPage(pagination.getPage(), pagination.getPageSize());
		PageHelper.orderBy("id desc");
		pagination.setQueryResult(messageMapper.findAll());
		return pagination;
	}

}

