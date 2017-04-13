package com.oaec.ssh.service;

import com.oaec.ssh.domain.Educate;
import com.oaec.ssh.domain.PageBean;

public interface EducateService {

	PageBean<Educate> findByPage(int currPage);//进行分页查询

	boolean exists(String username);//查询当前权限

	void register(Educate educates);//保存信息

	Educate query(int id);//查询

	void edit(Educate educateedit);//修改

	void delete(int id);//删除

	void deletes(String delValues);//多项删除

}
