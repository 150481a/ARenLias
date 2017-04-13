package com.oaec.ssh.action;

import java.util.Date;

import javax.annotation.Resource;

import oracle.net.aso.s;

import org.apache.struts2.ServletActionContext;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.oaec.ssh.domain.Message;
import com.oaec.ssh.domain.PageBean;
import com.oaec.ssh.domain.Users;
import com.oaec.ssh.service.MessageService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 *消息管理的action层的实现类
 *
 */
@Scope("prototype")  //是指刷新，每创建一次实体类便刷新一次
@Component("messageAction")//注解id
public class MessageAction  extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;//消息名称
	private String addressor;//发送者
	private String accept;//接受者
	private int priority;//消息等级
	private String content;//消息内容
	private String currPageStr;//获取当前页数
    private MessageService messageService;
    
    
	public String getCurrPageStr() {
		return currPageStr;
	}
	public void setCurrPageStr(String currPageStr) {
		this.currPageStr = currPageStr;
	}
	public String getAddressor() {
		return addressor;
	}
	public void setAddressor(String addressor) {
		this.addressor = addressor;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAccept() {
		return accept;
	}
	public void setAccept(String accept) {
		this.accept = accept;
	}
	
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public MessageService getMessageService() {
		return messageService;
	}
	@Resource(name="messageServiceImpl")
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	public MessageAction() {
		super();
	}
	/**
	 *进行发信息
	 */
	@Override
	public String execute() throws Exception {
		if(title.length()==0&&title!=null){
			this.addFieldError("title","消息标题不能为空！！！");
			return INPUT;
		}
		if(messageService.exists(accept)&&accept.equals((String) ActionContext.getContext().getSession().get("username"))){
			this.addFieldError("accept","接受者不存在或者不能给自己发送信息，请确认接受者！！！");
			return INPUT;
		}
		Message message=new Message();
		addressor=(String) ActionContext.getContext().getSession().get("username");
		message.setXm_title(title);
		message.setXm_addressor(addressor);
		message.setXm_accept(accept);
		message.setXm_priority(priority);
		message.setXm_accepttime(new Date());
		message.setXm_ressortime(new Date());
		message.setXm_content(content);
		messageService.register(message);
		ActionContext.getContext().getSession().put("message", message);
		return SUCCESS;
	}
	/**
	 *查询所有消息
	 */
	public  String Message_list() throws Exception{
		String currPageStr = ServletActionContext.getRequest().getParameter("currPageStr");//获取当前页数
		int currPage=1;
		if(currPageStr!=null){
			currPage = Integer.parseInt(currPageStr);
		}
		PageBean<Message> pageBean= messageService.findByPage(currPage);
		//将pagebean存入到值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		return SUCCESS;
	}
	/**
	 *发信息
	 */
	public  String Message_send() throws Exception{
		String usernames=(String) ActionContext.getContext().getSession().get("username");
		String currPageStr = ServletActionContext.getRequest().getParameter("currPageStr");//获取当前页数
		int currPage=1;
		if(currPageStr!=null){
			currPage = Integer.parseInt(currPageStr);
		}
		PageBean<Message> pageBean= messageService.findByPages(currPage,usernames);
		//将pagebean存入到值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		return SUCCESS;
	}
	/**
	 *收信息
	 */
	public  String Message_take() throws Exception{
		String usernamet=(String) ActionContext.getContext().getSession().get("username");
		String currPageStr = ServletActionContext.getRequest().getParameter("currPageStr");//获取当前页数
		int currPage=1;
		if(currPageStr!=null){
			currPage = Integer.parseInt(currPageStr);
		}
		PageBean<Message> pageBean= messageService.findByPaget(currPage,usernamet);
		//将pagebean存入到值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		return SUCCESS;
	}
	/**
	 *x信息查看
	 */
	public String Message_query() throws Exception{
		String id=ServletActionContext.getRequest().getParameter("mid");
		Message message=messageService.query(Integer.parseInt(id));
		ActionContext.getContext().put("message", message);
		return SUCCESS;
	}
	/**
	 *信息删除
	 */
	public String Message_delete() throws Exception{
		String id=ServletActionContext.getRequest().getParameter("mid");
		messageService.delete(Integer.parseInt(id));
		PageBean<Message> pageBean= messageService.findByPage(1);//需完善
		return SUCCESS;
	}
	public String Message_deletes() throws Exception{
		 String delValue = ServletActionContext.getRequest().getParameter("delValue");
		 String values=delValue.substring(1,delValue.length());
		 messageService.deletes(values);
		 return SUCCESS;
	}
}
