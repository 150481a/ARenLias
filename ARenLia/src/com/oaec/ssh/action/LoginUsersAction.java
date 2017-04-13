package com.oaec.ssh.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.oaec.ssh.domain.PageBean;
import com.oaec.ssh.domain.Users;
import com.oaec.ssh.service.UsersService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 *用户登录及用户管理的逻辑层的实现类
 */
@Scope("prototype") //是指刷新，每创建一次实体类便刷新一次
@Component("login")//注解id
public class LoginUsersAction extends ActionSupport  {
	/**
	 *模型驱动！！！
	 */
	private String username;//用户名
	private String userpwd;//密码
	private String userpwd1;//确认密码
	private String name;//姓名
	private int sex;//性别
	private Date birthday;//出生日期
	private String content;//备注
	private String textfield;//验证码
	private int isadmin;//级别
	private Date edittime;
	private Date reatetime;
	private String currPageStr;
	private UsersService userservice;
	
	
	
	public Date getEdittime() {
		return edittime;
	}
	public void setEdittime(Date edittime) {
		this.edittime = edittime;
	}
	public String getCurrPageStr() {
		return currPageStr;
	}
	public void setCurrPageStr(String currPageStr) {
		this.currPageStr = currPageStr;
	}
	public UsersService getUserservice() {
		return userservice;
	}
	@Resource(name="userserviceimpl")//注入
	public void setUserservice(UsersService userservice) {
		this.userservice = userservice;
	}
	
	
	public int getIsadmin() {
		return isadmin;
	}
	public void setIsadmin(int isadmin) {
		this.isadmin = isadmin;
	}
	public Date getReatetime() {
		return reatetime;
	}
	public void setReatetime(Date reatetime) {
		this.reatetime = reatetime;
	}
	public String getUserpwd1() {
		return userpwd1;
	}
	public void setUserpwd1(String userpwd1) {
		this.userpwd1 = userpwd1;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getTextfield() {
		return textfield;
	}
	public void setTextfield(String textfield) {
		this.textfield = textfield;
	}
	public LoginUsersAction() {
		super();
	}
	/**
	 *登录
	 */
	@Override
	public String execute() throws Exception {
		if(!userservice.exists(username,userpwd)){
			this.addFieldError("username", "用户名或密码错误！！");
			return INPUT;
		}
		if(!ActionContext.getContext().getSession().get("rand").equals(textfield)){
			this.addFieldError("textfield", "验证码有误！！");
			return INPUT;
		}
		ActionContext.getContext().getSession().put("username", username);
		return SUCCESS;
	}
	/**
	 *存储
	 */
	public String renyuanzj_add() throws Exception{
		if(!userpwd1.equals(userpwd)){
			this.addFieldError("userpwd1","两次密码不一致！！");
			return INPUT;
		}
		if(userservice.addexists(username)){
			this.addFieldError("username", "该用户已被注册，请重新输入！！！");
			return INPUT;
		}
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		Users user=new Users();
		user.setXu_username(username);
		user.setXu_password(userpwd);
		user.setXu_name(name);
		user.setXu_sex(sex);
		user.setXu_birthday(sdf.parse(sdf.format(birthday)));
		user.setXu_createtime(new Date());
		user.setXu_content(content);
		System.out.println(user.toString());
		userservice.register(user);
		ActionContext.getContext().getSession().containsKey(user);
		return SUCCESS;
	}
	/**
	 *分页
	 */
	public  String renyuanzj_pag() throws Exception{
		String currPageStr = (String) ServletActionContext.getRequest().getAttribute("currPageStr");//获取当前页数
		int currPage=1;
		if(currPageStr!=null){
			currPage = Integer.parseInt(currPageStr);
		}
		PageBean<Users> pageBean= userservice.findByPage(currPage);
		//将pagebean存入到值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		return SUCCESS;
	}
	/**
	 *查看
	 */
	public String renyuanzj_See() throws Exception{
		String xu_id = ServletActionContext.getRequest().getParameter("xu_id");
		Users see = userservice.See(Integer.parseInt(xu_id));
		ActionContext.getContext().put("see", see);
		return SUCCESS;
	}
	/**
	 *修改
	 */
	public String renyuanzj_edit() throws Exception {
		String xu_id = ServletActionContext.getRequest().getParameter("xu_id");
		Users see = userservice.See(Integer.parseInt(xu_id));
		ActionContext.getContext().put("see", see);
		return SUCCESS;
		
	}
	
	 public String  renyuanzj_edits() throws Exception{
		    String xu_id = ServletActionContext.getRequest().getParameter("xu_id");
		    if(!userpwd1.equals(userpwd)){
				this.addFieldError("userpwd1","两次密码不一致！！");
				return INPUT;
			}
		    SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
			Users user=new Users();
			user.setXu_id(Integer.parseInt(xu_id));
			user.setXu_username(username);
			user.setXu_password(userpwd);
			user.setXu_name(name);
			user.setXu_sex(sex);
			user.setXu_birthday(sdf.parse(sdf.format(birthday)));
			user.setXu_createtime(sdf.parse(sdf.format(reatetime)));
			user.setXu_edittime(new Date());
			user.setXu_content(content);
			user.setXu_isadmin(isadmin);
			userservice.edit(user);
			return SUCCESS; 
	 }
	 public String renyuanzj_delete() throws Exception{
		 String xu_id = ServletActionContext.getRequest().getParameter("xu_id");
		 userservice.delete(Integer.parseInt(xu_id));
		 return SUCCESS;
	 }
	 public String renyuanzj_deletes() throws Exception{
		 String delValue = ServletActionContext.getRequest().getParameter("delValue");
		 String values=delValue.substring(1,delValue.length());
		 userservice.deletes(values);
		 return SUCCESS;
	 }
	 
	
}
