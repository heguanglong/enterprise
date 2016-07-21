package com.qiye.dao.impl;

import org.springframework.stereotype.Component;

import com.qiye.dao.MessageDao;
import com.qiye.entity.Message;
@Component("messageDao")
public class MessageDaoImpl extends BaseDaoImpl<Message, Integer> implements MessageDao{
	
}
