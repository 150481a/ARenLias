package com.oaec.ssh.service;

import com.oaec.ssh.domain.PageBean;
import com.oaec.ssh.domain.Stipend;

public interface StipendService {

	boolean exists(String username);//查询权限

	void register(Stipend stipend);//保存信息

	PageBean<Stipend> findByPage(int currPage);//进行分页查询

	Stipend query(int id);//查询

	void edits(Stipend stipend);//修改

	void delete(int parseInt);//删除

	void deletes(String delValues);//多项删除

}
