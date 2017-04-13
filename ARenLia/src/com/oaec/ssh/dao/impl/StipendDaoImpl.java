package com.oaec.ssh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.oaec.ssh.dao.StipendDao;
import com.oaec.ssh.domain.Message;
import com.oaec.ssh.domain.Stipend;

@Component("stipendDaoImpl")
@Repository
public class StipendDaoImpl  implements StipendDao{
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
	@Override
	public boolean exists(String username) {
		int isadmin=(int) currentSession().createQuery("select xu_isadmin from Users u where u.xu_username=? ").setParameter(0, username).uniqueResult();
	 	if(isadmin==2){
	 		return true;
	 	}else{
	 		return false;
	 	}
	}
	@Override
	public void save(Stipend stipend) {
		Session session=currentSession();
		Integer count=(Integer) session.createQuery("select max(xs_id) from Stipend").uniqueResult();
		if(count==0){
			count+=2;
		}else{
			count+=1;
		}
		stipend.setXs_id(count);
		session.save(stipend);
	}
	/**
	 *查询条数
	 */
	@Override
	public int fingCount() {
		long count=	(long) currentSession().createQuery("select count(*) from Stipend").uniqueResult();
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
	public List<Stipend> findByPage(int begin, int pageSize) {
		List<Stipend> list=currentSession().createQuery(" from Stipend s where s.xs_id between ? and ?").setParameter(0,begin).setParameter(1, pageSize).list();
		return list;
	}
	/**
	 *查询 
	 */
	@Override
	@Transactional
	public Stipend query(int id) {
		Stipend stipend=(Stipend) currentSession().createQuery("from Stipend s where s.xs_id=?").setParameter(0, id).uniqueResult();
		return stipend;
	}
	/**
	 *修改 
	 */
	@Override
	@Transactional
	public void edits(Stipend stipend) {
		currentSession().update(stipend);
	}
	@Override
	@Transactional
	public void delete(int id) {
		currentSession().createQuery("delete from Stipend s where s.xs_id=?").setParameter(0, id).executeUpdate();
	}
	@Override
	@Transactional
	public void deletes(String delValues) {
		StringBuffer sb=new StringBuffer("delete from Stipend s where s.xs_id in(");
		String[] del=delValues.split(",");
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
