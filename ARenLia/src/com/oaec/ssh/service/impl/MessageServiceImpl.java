package com.oaec.ssh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oaec.ssh.dao.MessageDao;
import com.oaec.ssh.domain.Message;
import com.oaec.ssh.domain.PageBean;
import com.oaec.ssh.domain.Users;
import com.oaec.ssh.service.MessageService;

/**
 *消息管理业务层的实现类
 */
@Component("messageServiceImpl")
public class MessageServiceImpl implements MessageService {
	 private MessageDao messageDao;
	 
    @Resource(name="messageDaoImpl")
	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}
    /**
     *存储信息
     */
	@Override
	public void register(Message message) {
		messageDao.save(message);
	}
	@Override
	public boolean exists(String accept) {
		return messageDao.exists(accept);
	}
	@Override
	public PageBean<Message> findByPage(int currPage) {
		PageBean<Message> pageBean=new PageBean<>();
		//封装当前页数
		pageBean.setCurrPage(currPage);
		//封装每页显示记录数
		int pageSize=4;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount=messageDao.fingCount();//根据判断，确定是收信还是发信
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc=totalCount;
		Double numDouble=Math.ceil(tc/pageSize);//向上取整
		pageBean.setTotalPage(numDouble.intValue());//转为int存入
		//封装每页显示数据
		int begin=(currPage-1)*pageSize+2;//从哪里开始
		pageSize=begin + pageSize-1;
		List<Message> list=messageDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	@Override
	public PageBean<Message> findByPages(int currPage, String username) {
		PageBean<Message> pageBean=new PageBean<>();
		//封装当前页数
		pageBean.setCurrPage(currPage);
		//封装每页显示记录数
		int pageSize=4;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount=messageDao.fingCounts(username);//根据判断，确定是收信还是发信
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc=totalCount;
		Double numDouble=Math.ceil(tc/pageSize);//向上取整
		pageBean.setTotalPage(numDouble.intValue());//转为int存入
		//封装每页显示数据
		int begin=(currPage-1)*pageSize+2;//从哪里开始
		pageSize=begin + pageSize-1;
		List<Message> list=messageDao.findByPages(begin,pageSize,username);
		pageBean.setList(list);
		return pageBean;
	}
	@Override
	public PageBean<Message> findByPaget(int currPage, String username) {
		PageBean<Message> pageBean=new PageBean<>();
		//封装当前页数
		pageBean.setCurrPage(currPage);
		//封装每页显示记录数
		int pageSize=4;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount=messageDao.fingCounts(username);//根据判断，确定是收信还是发信
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc=totalCount;
		Double numDouble=Math.ceil(tc/pageSize);//向上取整
		pageBean.setTotalPage(numDouble.intValue());//转为int存入
		//封装每页显示数据
		int begin=(currPage-1)*pageSize+2;//从哪里开始
		pageSize=begin + pageSize-1;
		List<Message> list=messageDao.findByPaget(begin,pageSize,username);
		pageBean.setList(list);
		return pageBean;
	}
	@Override
	public Message query(Integer id) {
		return messageDao.query(id);
	}
	@Override
	public void delete(int id) {
		messageDao.delete(id);
	}
	@Override
	public void deletes(String delValue) {
		messageDao.deletes(delValue);
	}
}
