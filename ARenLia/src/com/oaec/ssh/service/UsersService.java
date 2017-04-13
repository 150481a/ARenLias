package com.oaec.ssh.service;

import java.util.List;

import com.oaec.ssh.domain.PageBean;
import com.oaec.ssh.domain.Users;

/**
 *用户登录及用户管理的业务层的接口
 */
public interface UsersService {
	boolean exists(String username,String userpwd);
	
	boolean addexists(String username);
	
	void register(Users user);
	
	long getnum();//直接查询表里条数
	
	List<Users> getpaglist(int startNum,int endNum,String name);//用来
	
	
	List<Users> getRenList();//查询Users里所有的信息
	
	List<Users> getQuanList(int id,String username);//通过权限和id查询Users里信息
	
	PageBean<Users> findByPage(int currPage);
	
	Users See(Integer  xu_id);//查看
	
	void edit(Users user);//修改
	
	void delete(Integer id);

	void deletes(String values);//多选删除
	
}
