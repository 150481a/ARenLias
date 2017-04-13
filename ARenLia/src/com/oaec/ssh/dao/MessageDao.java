package com.oaec.ssh.dao;

import java.util.List;

import com.oaec.ssh.domain.Message;
import com.oaec.ssh.domain.Users;

/**
 *消息管理的dao层的接口
 */
public interface MessageDao {

	void save(Message message);//保存信息

	boolean exists(String accept);//判断接受者是否存在

	int fingCount();//查询所有信息条数
	
	int fingCounts(String username);//通过genre查询所有信息条数
	
	int fingCountt(String username);//通过genre查询所有信息条数

	List<Message> findByPage(int begin, int pageSize);//进行分页查询
	
	List<Message> findByPages(int begin, int pageSize,String username);
	
	List<Message> findByPaget(int begin, int pageSize,String username);

	Message query(Integer id);//信息查看

	void delete(int id);//信息删除

	void deletes(String delValue);


	

}
