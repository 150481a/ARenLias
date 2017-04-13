package com.oaec.ssh.dao;

import java.util.List;

import com.oaec.ssh.domain.Job;

/**
 *招聘管理的dao层的接口
 */

public interface JobDao {

	boolean exists(String username);//通过用户名判断是否有权限

	void save(Job addjob);//进行存储

	int fingCount();//查询条数
	
	int fingCount(int isstock);//查询入库的信息

	List<Job> findByPage(int begin, int pageSize);//进行分页查询
	
	List<Job> findByPage(int begin, int pageSize,int isstock);//进行入库信息分页

	Job query(int id);//通过id查信息

	void edits(Job editjob);//修改

	void delete(int parseInt);//删除

	void deletes(String delValues);//多项删除

}
