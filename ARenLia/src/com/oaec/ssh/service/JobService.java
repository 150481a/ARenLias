package com.oaec.ssh.service;

import com.oaec.ssh.domain.Job;
import com.oaec.ssh.domain.PageBean;
import com.oaec.ssh.domain.Users;

/**
 *招聘管理的逻辑层的接口
 */
public interface JobService {

	boolean exists(String username);//通过用户名判断是否有权限

	void register(Job addjob);//进行信息存储

	PageBean<Job> findByPage(int currPage);//进行分页查询
	
	PageBean<Job> findByPage(int currPage,int isstock);//通过是否入库来查询

	Job query(int id);//通过id查询数据

	void edits(Job editjob);//修改

	void delete(int parseInt);//删除

	void deletes(String delValues);//多项删除

}
