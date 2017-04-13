package com.oaec.ssh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.oaec.ssh.dao.InstitutionDao;
import com.oaec.ssh.domain.Educate;
import com.oaec.ssh.domain.Institution;

@Component("institutionDaoImpl")
@Repository
public class InstitutionDaoImpl implements InstitutionDao{

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
	public void save(Institution institution) {
		Session session=currentSession();
		long count=(long) session.createQuery("select count(*) from Institution").uniqueResult();
		institution.setXi_id((int) (count+2));
		session.save(institution);
	}
	@Override
	public int fingCount() {
		long count=	(long) currentSession().createQuery("select count(*) from Institution").uniqueResult();
		if(count>0){
			int fingcout=(int) count;
			return fingcout;
		}
		return 0;
	}
	@Override
	public List<Institution> findByPage(int begin, int pageSize) {
		List<Institution> list=currentSession().createQuery(" from Institution i where i.xi_id between ? and ?").setParameter(0,begin).setParameter(1, pageSize).list();
		return list;
	}
	@Override
	@Transactional
	public Institution query(int id) {
		Institution institution=(Institution) currentSession().createQuery("from Institution i where i.xi_id=?").setParameter(0, id).uniqueResult();
		return institution;
	}
	@Override
	@Transactional
	public void update(Institution institution) {
		currentSession().update(institution);
	}
	@Override
	@Transactional
	public void deletes(String delValues) {
		StringBuffer sb=new StringBuffer("delete from Institution s where s.xi_id in(");
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
