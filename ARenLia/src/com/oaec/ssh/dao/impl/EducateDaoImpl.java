package com.oaec.ssh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.oaec.ssh.dao.EducateDao;
import com.oaec.ssh.domain.Educate;
import com.oaec.ssh.domain.Job;

@Component("educateDaoImpl")
@Repository
public class EducateDaoImpl implements EducateDao {
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
	public int fingCount() {
		long count=	(long) currentSession().createQuery("select count(*) from Educate").uniqueResult();
		if(count>0){
			int fingcout=(int) count;
			return fingcout;
		}
		return 0;
	}
	@Override
	public List<Educate> findByPage(int begin, int pageSize) {
		List<Educate> list=currentSession().createQuery(" from Educate e where e.xe_id between ? and ?").setParameter(0,begin).setParameter(1, pageSize).list();
		return list;
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
	public void save(Educate educates) {
		Session session=currentSession();
		long count=(long) session.createQuery("select count(*)from Educate").uniqueResult();
		educates.setXe_id((int) (count+2));
		session.save(educates);
	}
	@Override
	@Transactional
	public Educate query(int id) {
		Educate educate=(Educate) currentSession().createQuery("from Educate e where e.xe_id=?").setParameter(0, id).uniqueResult();
		return educate;
	}
	@Override
	@Transactional
	public void update(Educate educateedit) {
		currentSession().update(educateedit);
	}
	@Override
	@Transactional
	public void delete(int id) {
		currentSession().createQuery("delete from Educate e where e.xe_id=?").setParameter(0, id).executeUpdate();
	}
	@Override
	@Transactional
	public void deletes(String delValues) {
		StringBuffer sb=new StringBuffer("delete from Educate e where e.xe_id in(");
		String [] del=delValues.split(",");
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
