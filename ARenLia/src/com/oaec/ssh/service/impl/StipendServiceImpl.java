package com.oaec.ssh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oaec.ssh.dao.StipendDao;
import com.oaec.ssh.domain.Message;
import com.oaec.ssh.domain.PageBean;
import com.oaec.ssh.domain.Stipend;
import com.oaec.ssh.service.StipendService;

@Component("stipendServiceImpl")
public class StipendServiceImpl implements StipendService {
	private StipendDao stipendDao;

	public StipendDao getStipendDao() {
		return stipendDao;
	}
    @Resource(name="stipendDaoImpl")
	public void setStipendDao(StipendDao stipendDao) {
		this.stipendDao = stipendDao;
	}
	@Override
	public boolean exists(String username) {
		 return stipendDao.exists(username);
	}
	@Override
	public void register(Stipend stipend) {
		stipendDao.save(stipend);
	}
	@Override
	public PageBean<Stipend> findByPage(int currPage) {
		PageBean<Stipend> pageBean=new PageBean<>();
		//封装当前页数
		pageBean.setCurrPage(currPage);
		//封装每页显示记录数
		int pageSize=4;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount=stipendDao.fingCount();//根据判断，确定是收信还是发信
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc=totalCount;
		Double numDouble=Math.ceil(tc/pageSize);//向上取整
		pageBean.setTotalPage(numDouble.intValue());//转为int存入
		//封装每页显示数据
		int begin=(currPage-1)*pageSize+2;//从哪里开始
		pageSize=begin + pageSize-1;
		List<Stipend> list=stipendDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	@Override
	public Stipend query(int id) {
		 return stipendDao.query(id);
	}
	@Override
	public void edits(Stipend stipend) {
		stipendDao.edits(stipend);
	}
	@Override
	public void delete(int id) {
		stipendDao.delete(id);
	}
	@Override
	public void deletes(String delValues) {
		stipendDao.deletes(delValues);
	}

}
