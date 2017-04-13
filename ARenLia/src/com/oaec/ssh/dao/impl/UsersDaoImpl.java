package com.oaec.ssh.dao.impl;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.oaec.ssh.dao.UsersDao;
import com.oaec.ssh.domain.Users;

/**
 *用户登录及用户管理的DAO层的实现类
 */
@Component("userDaoImpl")
@Repository//用来标注数据访问组件，即dao包组件
public class UsersDaoImpl implements UsersDao {
	private SessionFactory sessionfactory;//创建Session对象
	
	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}
	//注解，自动装配和@Autowired用法差不多。可以代替设置，
    @Resource
	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}
    
	private Session currentSession(){
		return sessionfactory.getCurrentSession();
	}

	/**
	 *@return boolean
	 *@param username,userpwd
	 *用HQL对数据库进行查询
	 */
	@Override
	public boolean exists(String username,String userpwd) {
	long count=(long) currentSession().createQuery("select count(*) from Users  u where u.xu_username=? and u.xu_password=?").setParameter(0,username).setParameter(1,userpwd).uniqueResult();
	if(count>0){
		return true;
	}
		return false;
	}
	/**
	 *通过用户名来查询是否存在该用户
	 */
	@Override
	public boolean addexists(String username) {
		System.out.println(username);
		long count=(long) currentSession().createQuery("select count(*) from Users u where u.xu_username= ?").setParameter(0, username).uniqueResult();
		if(count>0){
			return true;
		}
		return false;
	}
	/**
	 *查询表里记录，并添加新的id,保存
	 *
	 */
	@Override
	public void save(Users user) {
		Session session=currentSession();
		Integer count=(Integer) session.createQuery("select max(xu_id) from Users").uniqueResult();
		if(count==0){
			count+=2;
		}
		else{
			count+=1;
		}
		user.setXu_id(count);
		session.save(user);
	}
	/**
	 *通过get方法用来获取集合，
	 *@return List<Users>
	 *
	 */
	@Override
	public List<Users> getRenList() {
		List<Users> usrenlist=new ArrayList<>();
		for (int i =2; i < num()+2; i++) {
			usrenlist.add((Users) currentSession().get(Users.class,i ));
		}
		return usrenlist;
	}
	@Override
	public List<Users> getQuanList(int id, String username) {
		return  currentSession().createQuery("from Users u where u.xu_id=? and u.xu_username=?").setParameter(0, id).setParameter(1, username).list();
	}
	@Override
	public long num(String username) {
		long count = 0;
		if(getxu_isadmin(username)==1){
			 count= (long)currentSession().createQuery("select count(*) from Users u where u.xu_username=? ").setParameter(0, username).uniqueResult();
		}else if(getxu_isadmin(username)==2){
			 count= (long)currentSession().createQuery("select count(*) from Users ").uniqueResult();
		}
		return count;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Users> getpaglist(int startNum,int endNum,String username) {
		return	currentSession().createSQLQuery("select * from (select n.*,rownum row_num from (select * from Users) n )b where b.row_num between ? and ? and xu_isadmin<=(select xu_isadmin from x_users where xu_username=?").setParameter(0, startNum).setParameter(1, endNum).setParameter(3, username).list();
	}
	@Override
	public int getxu_isadmin(String username) {
	     int isadmin=(int) currentSession().createQuery("select xu_isadmin from Users u where u.xu_username=?").setParameter(0, username).uniqueResult();
		return isadmin;
	}
	@Override
	public long num() {
	long count=	(long) currentSession().createQuery("select count(*) from Users").uniqueResult();
		return count;
	}
	@Override
	public List<Users> findByPage(int begin, int pageSize) {
		 
		List<Users> list=currentSession().createQuery(" from Users u where u.xu_id between ? and ?").setParameter(0,begin).setParameter(1, pageSize).list();
		return list;
	}
	@Override
	public int fingCount() {
		long count=	(long) currentSession().createQuery("select count(*) from Users").uniqueResult();
		if(count>0){
			int fingcout=(int) count;
			return fingcout;
		}
		return 0;
	}
	@Override
	@Transactional
	public Users See(Integer xu_id) {
		Users users = (Users) currentSession().createQuery("from Users u where u.xu_id=?").setParameter(0, xu_id).uniqueResult();
		return users;
	}
	/**
	 *修改
	 */
	@Override
	@Transactional
	public void saveedit(Users user) {
		currentSession().update(user);
		
	}
	@Override
	@Transactional
	public void delete(Integer id) {
		currentSession().createQuery("delete from Users u where u.xu_id=?").setParameter(0, id).executeUpdate();
	}
	/**
	 *多选删除！！！
	 */
	@Override
	@Transactional
	public void deletes(String values) {
		StringBuffer sb=new StringBuffer("delete from Users u where u.xu_id in (");
		String[] del=values.split(",");
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
