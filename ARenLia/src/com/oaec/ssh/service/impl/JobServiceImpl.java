package com.oaec.ssh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oaec.ssh.dao.JobDao;
import com.oaec.ssh.domain.Job;
import com.oaec.ssh.domain.Message;
import com.oaec.ssh.domain.PageBean;
import com.oaec.ssh.service.JobService;

/**
 *招聘管理的逻辑层的实现类
 */
@Component("jobServiceImpl")
public class JobServiceImpl implements JobService {
	private JobDao jobDao;

	@Resource(name="jobDaoImpl")
	public void setJobDao(JobDao jobDao) {
		this.jobDao = jobDao;
	}

	@Override
	public boolean exists(String username) {
		return jobDao.exists(username);
	}

	@Override
	public void register(Job addjob) {
		jobDao.save(addjob);
	}

	@Override
	public PageBean<Job> findByPage(int currPage) {
		PageBean<Job> pageBean=new PageBean<>();
		//封装当前页数
		pageBean.setCurrPage(currPage);
		//封装每页显示记录数
		int pageSize=4;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount=jobDao.fingCount();//
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc=totalCount;
		Double numDouble=Math.ceil(tc/pageSize);//向上取整
		pageBean.setTotalPage(numDouble.intValue());//转为int存入
		//封装每页显示数据
		int begin=(currPage-1)*pageSize+2;//从哪里开始
		pageSize=begin + pageSize-1;
		List<Job> list=jobDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public PageBean<Job> findByPage(int currPage, int isstock) {
		PageBean<Job> pageBean=new PageBean<>();
		//封装当前页数
		pageBean.setCurrPage(currPage);
		//封装每页显示记录数
		int pageSize=4;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount=jobDao.fingCount(isstock);//根据判断，确定是收信还是发信
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc=totalCount;
		Double numDouble=Math.ceil(tc/pageSize);//向上取整
		pageBean.setTotalPage(numDouble.intValue());//转为int存入
		//封装每页显示数据
		int begin=(currPage-1)*pageSize+2;//从哪里开始
		pageSize=begin + pageSize-1;
		List<Job> list=jobDao.findByPage(begin,pageSize,isstock);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public Job query(int id) {
		return jobDao.query(id);
	}

	@Override
	public void edits(Job editjob) {
		jobDao.edits(editjob);
	}

	@Override
	public void delete(int parseInt) {
		jobDao.delete(parseInt);
	}

	@Override
	public void deletes(String delValues) {
		jobDao.deletes(delValues);
	}
	

}
