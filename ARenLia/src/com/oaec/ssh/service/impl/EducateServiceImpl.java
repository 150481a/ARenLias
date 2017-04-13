package com.oaec.ssh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oaec.ssh.dao.EducateDao;
import com.oaec.ssh.domain.Educate;
import com.oaec.ssh.domain.Job;
import com.oaec.ssh.domain.PageBean;
import com.oaec.ssh.service.EducateService;


@Component("educateServiceImpl")
public class EducateServiceImpl  implements EducateService{
	private EducateDao educateDao;

	public EducateDao getEducateDao() {
		return educateDao;
	}
    @Resource(name="educateDaoImpl")
	public void setEducateDao(EducateDao educateDao) {
		this.educateDao = educateDao;
	}
	@Override
	public PageBean<Educate> findByPage(int currPage) {
		PageBean<Educate> pageBean=new PageBean<>();
		//封装当前页数
		pageBean.setCurrPage(currPage);
		//封装每页显示记录数
		int pageSize=4;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount=educateDao.fingCount();//根据判断，确定是收信还是发信
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc=totalCount;
		Double numDouble=Math.ceil(tc/pageSize);//向上取整
		pageBean.setTotalPage(numDouble.intValue());//转为int存入
		//封装每页显示数据
		int begin=(currPage-1)*pageSize+2;//从哪里开始
		pageSize=begin + pageSize-1;
		List<Educate> list=educateDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	@Override
	public boolean exists(String username) {
		 return educateDao.exists(username);
	}
	@Override
	public void register(Educate educates) {
		educateDao.save(educates);
	}
	@Override
	public Educate query(int id) {
		return educateDao.query(id);
	}
	@Override
	public void edit(Educate educateedit) {
		educateDao.update(educateedit);
		
	}
	@Override
	public void delete(int id) {
		educateDao.delete(id);
	}
	@Override
	public void deletes(String delValues) {
		educateDao.deletes(delValues);
	}
	

}
