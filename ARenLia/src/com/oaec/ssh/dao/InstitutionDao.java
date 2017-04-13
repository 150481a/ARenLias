package com.oaec.ssh.dao;

import java.util.List;

import com.oaec.ssh.domain.Institution;

public interface InstitutionDao {

	boolean exists(String username);//权限查询

	void save(Institution institution);//保存信息

	int fingCount();//获取条数

	List<Institution> findByPage(int begin, int pageSize);//分页查询

	Institution query(int id);

	void update(Institution einstitution);

	void deletes(String delValues);//多项删除
}
