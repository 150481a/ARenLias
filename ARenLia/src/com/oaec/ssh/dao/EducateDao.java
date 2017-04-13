package com.oaec.ssh.dao;

import java.util.List;

import com.oaec.ssh.domain.Educate;

public interface EducateDao {

	int fingCount();//查询条数

	List<Educate> findByPage(int begin, int pageSize);//分页查询

	boolean exists(String username);//进行权限查询

	void save(Educate educates);//进行保存

	Educate query(int id);//查询

	void update(Educate educateedit);//修改

	void delete(int parseInt);//删除

	void deletes(String delValues);//多项删除
}
