package com.oaec.ssh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oaec.ssh.dao.InstitutionDao;
import com.oaec.ssh.domain.Educate;
import com.oaec.ssh.domain.Institution;
import com.oaec.ssh.domain.PageBean;
import com.oaec.ssh.service.InstitutionService;

@Component("institutionServiceImpl")
public class InstitutionServiceImpl implements InstitutionService {

	private InstitutionDao institutionDao;

	public InstitutionDao getInstitutionDao() {
		return institutionDao;
	}
    @Resource(name="institutionDaoImpl")
	public void setInstitutionDao(InstitutionDao institutionDao) {
		this.institutionDao = institutionDao;
	}
	@Override
	public boolean exists(String username) {
		return institutionDao.exists(username);
	}
	@Override
	public void register(Institution institution) {
		institutionDao.save(institution);
	}
	@Override
	public PageBean<Institution> findByPage(int currPage) {
		PageBean<Institution> pageBean=new PageBean<>();
		//封装当前页数
		pageBean.setCurrPage(currPage);
		//封装每页显示记录数
		int pageSize=4;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount=institutionDao.fingCount();//根据判断，确定是收信还是发信
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc=totalCount;
		Double numDouble=Math.ceil(tc/pageSize);//向上取整
		pageBean.setTotalPage(numDouble.intValue());//转为int存入
		//封装每页显示数据
		int begin=(currPage-1)*pageSize+2;//从哪里开始
		pageSize=begin + pageSize-1;
		List<Institution> list=institutionDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	@Override
	public Institution query(int id) {
		return institutionDao.query(id);
	}
	@Override
	public void edit(Institution einstitution) {
		institutionDao.update(einstitution);
	}
	@Override
	public void deletes(String delValues) {
		institutionDao.deletes(delValues);
	}
	
}
