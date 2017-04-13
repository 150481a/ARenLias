package com.oaec.ssh.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.oaec.ssh.domain.Educate;
import com.oaec.ssh.domain.Job;
import com.oaec.ssh.domain.PageBean;
import com.oaec.ssh.service.EducateService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Component("educateAction")
public class EducateAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;//培训名称
	private String purpose;//培训目的
	private Date  begintime;//培训开始时间
	private Date endtime;//培训结束时间
	private String datum;//培训材料
	private String teacher;//培训讲师
	private String student;//培训人员
	private Date createtime;//创建时间
	private int educate;//0:未完成 1:完成
	private String effect;//培训效果
	private String summarize;//培训总结
	private String currPageStr;//获取当前页数
	private EducateService educateService;

	public EducateService getEducateService() {
		return educateService;
	}
    @Resource(name="educateServiceImpl")
	public void setEducateService(EducateService educateService) {
		this.educateService = educateService;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public Date getBegintime() {
		return begintime;
	}
	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public String getDatum() {
		return datum;
	}
	public void setDatum(String datum) {
		this.datum = datum;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getStudent() {
		return student;
	}
	public void setStudent(String student) {
		this.student = student;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public int getEducate() {
		return educate;
	}
	public void setEducate(int educate) {
		this.educate = educate;
	}
	public String getEffect() {
		return effect;
	}
	public void setEffect(String effect) {
		this.effect = effect;
	}
	public String getSummarize() {
		return summarize;
	}
	public void setSummarize(String summarize) {
		this.summarize = summarize;
	}
	public String getCurrPageStr() {
		return currPageStr;
	}
	public void setCurrPageStr(String currPageStr) {
		this.currPageStr = currPageStr;
	}
	public String educatelist_ck() throws Exception{
		String currPageStr = (String) ServletActionContext.getRequest().getAttribute("currPageStr");//获取当前页数
		int currPage=1;
		if(currPageStr!=null){
			currPage = Integer.parseInt(currPageStr);
		}
		PageBean<Educate> pageBean= educateService.findByPage(currPage);
		//将pagebean存入到值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		return SUCCESS;
	}
	public String educatelist_add() throws Exception{
		if(!educateService.exists((String) ActionContext.getContext().getSession().get("username"))){
			this.addActionError("您的用户权限不足，不能进行员工信息添加！！");
			return INPUT;
		}else{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
			Educate educates=new Educate();
			begintime=sdf.parse(sdf.format(begintime));
	    	endtime=sdf.parse(sdf.format(endtime));
			if(endtime.getTime()-begintime.getTime()<0){
	    		this.addActionError("结束时间必须大于开始时间！！");
	    		return INPUT;
	    	}
			educates.setXe_name(name);
			educates.setXe_purpose(purpose);
			educates.setXe_begintime(begintime);
			educates.setXe_endtime(endtime);
			educates.setXe_datum(datum);
			educates.setXe_teacher(teacher);
			educates.setXe_student(student);
			educates.setXe_createtime(new Date());
			educates.setXe_educate(educate);
			educates.setXe_effect(effect);
			educates.setXe_summarize(summarize);
			educateService.register(educates);
			ActionContext.getContext().getSession().put("educates", educates);
			return SUCCESS;
		}
	}
	/**
	 *查询
	 */
	public String educatelist_query() throws Exception{
		String eid=ServletActionContext.getRequest().getParameter("eid");
		Educate educateQ=educateService.query(Integer.parseInt(eid));
		ActionContext.getContext().put("educateQ", educateQ);
		return SUCCESS;
		
	}
	/**
	 *修改前的查询
	 */
    public String educatelist_edit() throws Exception{
    	String eid=ServletActionContext.getRequest().getParameter("eid");
		Educate educateQ=educateService.query(Integer.parseInt(eid));
		ActionContext.getContext().put("educateQ", educateQ);
		return SUCCESS;
    }
    /**
     *修改
     */
    public String educatelist_edits() throws Exception{
    	String eid=ServletActionContext.getRequest().getParameter("eid");
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
    	begintime=sdf.parse(sdf.format(begintime));
    	endtime=sdf.parse(sdf.format(endtime));
    	if(endtime.getTime()-begintime.getTime()<0){
    		this.addActionError("结束时间必须大于开始时间！！");
    		return INPUT;
    	}
    	Educate educateedit=new Educate();
    	educateedit.setXe_id(Integer.parseInt(eid));
    	educateedit.setXe_name(name);
    	educateedit.setXe_purpose(purpose);
    	educateedit.setXe_begintime(begintime);
    	educateedit.setXe_endtime(endtime);
    	educateedit.setXe_datum(datum);
    	educateedit.setXe_teacher(teacher);
    	educateedit.setXe_student(student);
    	educateedit.setXe_createtime(sdf.parse(sdf.format(createtime)));
    	educateedit.setXe_educate(educate);
    	educateedit.setXe_effect(effect);
    	educateedit.setXe_summarize(summarize);
		educateService.edit(educateedit);
		ActionContext.getContext().put("educateedit", educateedit);
		return SUCCESS;
    }
    public String educatelist_delete() throws Exception{
    	String eid=ServletActionContext.getRequest().getParameter("eid");
    	educateService.delete(Integer.parseInt(eid));
    	return SUCCESS;
    }
    public String educatelist_deletes() throws Exception{
    	String delValue=ServletActionContext.getRequest().getParameter("delValue");
    	String delValues=delValue.substring(1,delValue.length());
    	educateService.deletes(delValues);
    	return SUCCESS;
    }
}
