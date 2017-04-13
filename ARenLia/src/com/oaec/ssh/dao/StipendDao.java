package com.oaec.ssh.dao;

import java.util.List;

import com.oaec.ssh.domain.Stipend;

public interface StipendDao {

	boolean exists(String username);//查询权限

	void save(Stipend stipend);//信息存储

	int fingCount();//查询条数

	List<Stipend> findByPage(int begin, int pageSize);//进行分页查询

	Stipend query(int id);//查询

	void edits(Stipend stipend);//修改

	void delete(int parseInt);//删除

	void deletes(String delValues);//多项删除

}
