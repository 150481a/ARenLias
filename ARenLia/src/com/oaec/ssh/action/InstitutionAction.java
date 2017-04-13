package com.oaec.ssh.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.oaec.ssh.domain.Institution;
import com.oaec.ssh.domain.Job;
import com.oaec.ssh.domain.PageBean;
import com.oaec.ssh.service.InstitutionService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Scope("protopyte")
@Component("institutionAction")
public class InstitutionAction  extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;//奖罚名称
	private String reason;//奖罚原因
	private String explains;//奖罚说明
	private Date createtime;//创建时间
	private String currPageStr;//获取当前页数
	private InstitutionService institutionService;

	public InstitutionService getInstitutionService() {
		return institutionService;
	}
    @Resource(name="institutionServiceImpl")
	public void setInstitutionService(InstitutionService institutionService) {
		this.institutionService = institutionService;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getExplains() {
		return explains;
	}
	public void setExplains(String explains) {
		this.explains = explains;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getCurrPageStr() {
		return currPageStr;
	}
	public void setCurrPageStr(String currPageStr) {
		this.currPageStr = currPageStr;
	}
	public String institutionlist_add() throws Exception{
		if(!institutionService.exists((String) ActionContext.getContext().getSession().get("username"))){
			this.addFieldError("xu_id", "您的用户权限不足，不能进行员工信息添加！！");
			return INPUT;
		}else{
			Institution institution=new Institution();
			institution.setXi_name(name);
			institution.setXi_reason(reason);
			institution.setXi_explains(explains);
			institution.setXi_createtime(new Date());
			institutionService.register(institution);
			ActionContext.getContext().getSession().put("institution", institution);
			return SUCCESS;
		}
	}
	public String institutionlist_ck() throws Exception{
		String currPageStr = (String) ServletActionContext.getRequest().getAttribute("currPageStr");//获取当前页数
		int currPage=1;
		if(currPageStr!=null){
			currPage = Integer.parseInt(currPageStr);
		}
		PageBean<Institution> pageBean= institutionService.findByPage(currPage);
		//将pagebean存入到值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		return SUCCESS;
	}
	public String institutionlist_query() throws Exception{
		String ied=ServletActionContext.getRequest().getParameter("ied");
		Institution institutionQ=institutionService.query(Integer.parseInt(ied));
		ActionContext.getContext().put("institutionQ", institutionQ);
		return SUCCESS;
	}
	public String institutionlist_edit() throws Exception{
		String ied=ServletActionContext.getRequest().getParameter("ied");
		Institution institutionQ=institutionService.query(Integer.parseInt(ied));
		ActionContext.getContext().put("institutionQ", institutionQ);
		return SUCCESS;
	}
	public String institutionlist_edits() throws Exception{
		String ieds=ServletActionContext.getRequest().getParameter("iedsa");//包空值！！
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		Institution einstitution=new Institution();
		createtime=sdf.parse(sdf.format(createtime));
		Date entime=new Date();
		if(createtime.getTime()>entime.getTime()){
    		this.addActionError("结束时间必须大于开始时间！！");
    		return INPUT;
    	}
		einstitution.setXi_id(Integer.parseInt(ieds));
		einstitution.setXi_name(name);
		einstitution.setXi_reason(reason);
		einstitution.setXi_explains(explains);
		einstitution.setXi_createtime(sdf.parse(sdf.format(createtime)));
		institutionService.edit(einstitution);
		return SUCCESS;
	}
	public String institutionlist_deletes() throws Exception{
        String delValue=ServletActionContext.getRequest().getParameter("delValue");
        String delValues=delValue.substring(1,delValue.length());
        institutionService.deletes(delValues);
		return SUCCESS;
		
	}
}
