package com.oaec.ssh.dao.impl;


import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Id;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.oaec.ssh.dao.JobDao;
import com.oaec.ssh.domain.Job;
import com.oaec.ssh.domain.Message;

/**
 *招聘管理的dao层的实现类
 */
@Component("jobDaoImpl")
@Repository
public class JobDaoImpl implements JobDao {
	private SessionFactory sessionFactory;
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

    @Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

    private Session currentSession(){
    	return sessionFactory.getCurrentSession();
    }
    /**
     *@param username用户名 通过用户名来获取权限级别
     *@return boolean
     *
     */
	@Override
	public boolean exists(String username) {
	    int isadmin=(int) currentSession().createQuery("select xu_isadmin from Users u where u.xu_username=? ").setParameter(0, username).uniqueResult();
	 	if(isadmin==2){
	 		return true;
	 	}else{
	 		return false;
	 	}
	}

	/**
	 *@param addjob
	 *进行信息存储
	 */
	@Override
	public void save(Job addjob) {
		Session session=currentSession();
		Integer count=(Integer) session.createQuery("select max(xj_id)from Job").uniqueResult();
		if(count==0){
			count+=2;
		}else{
			count+=1;
		}
		addjob.setXj_id(count);
		session.save(addjob);
	}

	/**
	 *查询条数
	 */
	@Override
	public int fingCount() {
		long count=	(long) currentSession().createQuery("select count(*) from Job").uniqueResult();
		if(count>0){
			int fingcout=(int) count;
			return fingcout;
		}
		return 0;
	}

	/**
	 *进行分页查询
	 */
	@Override
	public List<Job> findByPage(int begin, int pageSize) {
		List<Job> list=currentSession().createQuery(" from Job j where j.xj_id between ? and ?").setParameter(0,begin).setParameter(1, pageSize).list();
		return list;
	}

	@Override
	public int fingCount(int isstock) {
		long count=	(long) currentSession().createQuery("select count(*) from Job j where j.xj_isstock=?").setParameter(0, isstock).uniqueResult();
		if(count>0){
			int fingcout=(int) count;
			return fingcout;
		}
		return 0;
	}

	/**
	 *分页查询
	 */
	@Override
	public List<Job> findByPage(int begin, int pageSize, int isstock) {
		List<Job> list=currentSession().createQuery(" from Job j where j.xj_id between ? and ? and j.xj_isstock=?").setParameter(0,begin).setParameter(1, pageSize).setParameter(2, isstock).list();
		return list;
	}

	/**
	 *查询
	 */
	@Override
	@Transactional
	public Job query(int id) {
		Job job=(Job) currentSession().createQuery("from Job j where j.xj_id=?").setParameter(0, id).uniqueResult();
		return job;
	}
	 /**
     *修改
     */
	@Override
	@Transactional
	public void edits(Job editjob) {
		currentSession().update(editjob);
	}
    /**
     *删除
     */
	@Override
	@Transactional
	public void delete(int parseInt) {
		currentSession().createQuery("delete from Job j where j.xj_id=?").setParameter(0, parseInt).executeUpdate();
	}
	 /**
     *多项删除
     */
	@Override
	@Transactional
	public void deletes(String delValues) {
		StringBuffer sb=new StringBuffer("delete from Job j where j.xj_id in(");
		String[] del=delValues.split(",");
		for (String string : del) {
		}
		for (int i = 0; i < del.length; i++) {
			if(i<del.length-1){
				sb.append(Integer.parseInt(del[i])+",");
			}else{
				sb.append(Integer.parseInt(del[i]));
			}
		}
		sb.append(")");
		currentSession().createQuery(sb.toString()).executeUpdate();
	}

}
