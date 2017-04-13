package com.oaec.ssh.dao;

import java.util.List;

import com.oaec.ssh.domain.Users;

/**
 *用户登录及用户管理的DAO层的接口
 */
public interface UsersDao {
  
	boolean exists(String username,String userpwd);
	
	boolean addexists(String username);//通过用户名查询表里数据
	
	void save(Users user);//直接查询表里数据并存储
	
	long num(String username);//通过用户名查询表里条数
	
	long num();
	
	List<Users> getpaglist(int startNum,int endNum,String username);//initial用来
	
	List<Users> getRenList();//查询Users里所有的信息
	
	List<Users> getQuanList(int id,String username);//通过权限和id查询Users里信息
	
	int getxu_isadmin(String username);//通过用户名查询权限
	
	List<Users> findByPage(int begin, int pageSize);//分页查询
	
	int fingCount();//查询表里条数
	
	Users See(Integer xu_id);//查看
	
	void saveedit(Users user);//修改
	
	void delete(Integer id);//删除

	void deletes(String values);//多选删除
	
}
