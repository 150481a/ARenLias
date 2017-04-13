package com.oaec.ssh.service;

import com.oaec.ssh.domain.Institution;
import com.oaec.ssh.domain.PageBean;

public interface InstitutionService {

	boolean exists(String username);//进行权限查询

	void register(Institution institution);//保存信息

	PageBean<Institution> findByPage(int currPage);//分页查询

	Institution query(int id);

	void edit(Institution einstitution);

	void deletes(String delValues);//删除

}
