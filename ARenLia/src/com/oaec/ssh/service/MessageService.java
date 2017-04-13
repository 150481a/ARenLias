package com.oaec.ssh.service;

import com.oaec.ssh.domain.Message;
import com.oaec.ssh.domain.PageBean;

/**
 *消息管理业务层的接口
 */
public interface MessageService {

	void register(Message message);//保存消息

	boolean exists(String accept);//判断接受者是否存在！！

	PageBean<Message> findByPage(int currPage);//进行分页查询

	PageBean<Message> findByPages(int currPage, String username);//通过genre进行分页查询
	
	PageBean<Message> findByPaget(int currPage, String username);

	Message query(Integer id);//信息查看

	void delete(int id);//删除

	void deletes(String delValue);
	

}
