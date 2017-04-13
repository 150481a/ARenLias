package com.oaec.ssh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import oracle.net.aso.r;

import org.springframework.stereotype.Component;

import com.oaec.ssh.dao.UsersDao;
import com.oaec.ssh.domain.PageBean;
import com.oaec.ssh.domain.Users;
import com.oaec.ssh.service.UsersService;
import com.opensymphony.xwork2.ActionContext;

/**
 *用户登录及用户管理的业务层的实现类
 */
@Component("userserviceimpl")
public class UsersServiceImpl implements UsersService {
	private UsersDao userdao;
	
	public UsersDao getUserdao() {
		return userdao;
	}
	//Spring注入
	@Resource(name="userDaoImpl")
	public void setUserdao(UsersDao userdao) {
		this.userdao = userdao;
	}
	/**
	 *@return boolean
	 *@param username,userpwd
	 *跳转到userdao进行查询用户是否存在，
	 */
	@Override
	public boolean exists(String username,String userpwd) {
		return userdao.exists(username,userpwd);
	}
	@Override
	public boolean addexists(String username) {
		return userdao.addexists(username);
	}
	@Override
	public void register(Users user) {
		userdao.save(user);
	}
	@Override
	public long getnum() {
		return userdao.num();
	}
	@Override
	public List<Users> getpaglist(int startNum,int endNum,String name) {
		return userdao.getpaglist(startNum, endNum,name);
	}
	@Override
	public List<Users> getRenList() {
		return userdao.getRenList();
	}
	@Override
	public List<Users> getQuanList(int id, String username) {
		return userdao.getQuanList(id, username);
	}
	/**
	 *分页查询的方法
	 */
	@Override
	public PageBean<Users> findByPage(int currPage) {
		PageBean<Users> pageBean=new PageBean<>();
		//封装当前页数
		pageBean.setCurrPage(currPage);
		//封装每页显示记录数
		int pageSize=4;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount=userdao.fingCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc=totalCount;
		Double numDouble=Math.ceil(tc/pageSize);//向上取整
		pageBean.setTotalPage(numDouble.intValue());//转为int存入
		//封装每页显示数据
		int begin=(currPage-1)*pageSize+2;//从哪里开始
		pageSize=begin + pageSize-1;
		List<Users> list=userdao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	@Override
	public Users See(Integer xu_id) {
		return userdao.See(xu_id);
	}
	@Override
	public void edit(Users user) {
		userdao.saveedit(user);
	}
	@Override
	public void delete(Integer id) {
		userdao.delete(id);
	}
	@Override
	public void deletes(String values) {
		userdao.deletes(values);
	}

}
