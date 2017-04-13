package com.oaec.ssh.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.oaec.ssh.dao.MessageDao;
import com.oaec.ssh.domain.Message;
import com.oaec.ssh.domain.Users;
import com.opensymphony.xwork2.ActionContext;

/**
 *消息管理的dao层的实现类
 */
@Component("messageDaoImpl")
@Repository
public class MessageDaoImpl implements MessageDao {
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
	 * @param Message
	 * 
	 */
	@Override
	public void save(Message message) {
		Session session=currentSession();
		Integer count=(Integer) session.createQuery("select max(xm_id) from Message").uniqueResult();
		if(count==0){
			count+=2;
		}else{
			count+=1;
		}
		message.setXm_id(count);//添加ID
		message.setXm_genre(0);//0为发信息,1为收信息
		session.save(message);
		
	}
	/**
	 *判断发信人是否存在
	 *@param accept 
	 */
	@Override
	public boolean exists(String accept) {
		long count=(long) currentSession().createQuery("select count(*) from Users u where u.xu_username=?").setParameter(0, accept).uniqueResult();
		if(count>0){
			return true;
		}
		return false;
	}
	/**
	 *通过查询表里条数进行查询
	 */
	@Override
	public int fingCount() {
		long count=	(long) currentSession().createQuery("select count(*) from Message").uniqueResult();
		if(count>0){
			int fingcout=(int) count;
			return fingcout;
		}
		return 0;
	}
	@Override
	public List<Message> findByPage(int begin, int pageSize) {
		List<Message> list=currentSession().createQuery("from Message m where m.xm_id between ? and ?").setParameter(0,begin).setParameter(1, pageSize).list();
		return list;
	}
	
	/**
	 *通过判断当前用户是发信人。则查询发信表，反正收信息
	 */
	@Override
	public int fingCounts(String username) {
	   long count=(long) currentSession().createQuery("select count(*) from Message m where m.xm_accept=?").setParameter(0, username).uniqueResult();
		if(count>0){
			int fingcout=(int) count;
			return fingcout;
		}
		return 0;
	}
	/**
	 *通过判断当前用户是发信人。则查询发信表，反正收信息
	 */
	@Override
	public List<Message> findByPages(int begin, int pageSize, String username) {
		List<Message> list=currentSession().createQuery(" from Message m where m.xm_id between ? and ? and m.xm_accept=? ").setParameter(0, begin).setParameter(1, pageSize).setParameter(2, username).list();
		return list;
	}
	/**
	 *通过判断当前用户是收信人。则查询发信表，反正收信息
	 */
	@Override
	public int fingCountt(String username) {
		long count=(long) currentSession().createQuery("select count(*) from Message m where m.xm_addressor=?").setParameter(0, username).uniqueResult();
		if(count>0){
			int fingcout=(int) count;
			return fingcout;
		}
		return 0;
	}
	/**
	 *通过判断当前用户是收信人。则查询发信表，反正收信息
	 */
	@Override
	public List<Message> findByPaget(int begin, int pageSize, String username) {
		List<Message> list=currentSession().createQuery("from Message m where m.xm_id between ? and ? and m.xm_addressor=?").setParameter(0, begin).setParameter(1, pageSize).setParameter(2, username).list();
		return list;
	}
	/**
	 *信息查看
	 */
	@Override
	@Transactional
	public Message query(Integer id) {
		Message message = (Message) currentSession().createQuery(" from Message m where m.xm_id=? ").setParameter(0, id).uniqueResult();
		return message;
	}
	/**
	 *信息删除 
	 */
	@Override
	@Transactional
	public void delete(int id) {
	    currentSession().createQuery("delete from  Message m where m.xm_id=?").setParameter(0, id).executeUpdate();
	}
	/**
	 *多项信息删除 
	 */
	@Override
	@Transactional
	public void deletes(String delValue) {
		StringBuffer sb=new StringBuffer("delete from Message s where s.xm_id in(");
		String[] del=delValue.split(",");
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
