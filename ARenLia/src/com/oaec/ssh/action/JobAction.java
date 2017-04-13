package com.oaec.ssh.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.oaec.ssh.domain.Job;
import com.oaec.ssh.domain.PageBean;
import com.oaec.ssh.service.JobService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 招聘管理的action层的实现类
 */
@Scope("prototype")
// 是指刷新，每创建一次实体类便刷新一次
@Component("jobAction")
// 注解id
public class JobAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;//姓名
	private int sex;//0:为男 1:为女
	private Integer age;//应聘人员年龄
	private String job;//应聘人员职位
	private String idcad;//应聘人员身份证
	private String specialty;//所学专业
	private String experience;//工作经验
	private String studyeffort;//学历
	private String school;//毕业学校
	private long tel;//电话号码
	private String email;//Email地址
	private Date createtime;//创建时间
	private String content;//详细经历
	private int isstock;//0:为未存库 1：为存库
	private String currPageStr;//获取当前页数
	private JobService jobService;
	
	public JobService getJobService() {
		return jobService;
	}

	@Resource(name="jobServiceImpl")
	public void setJobService(JobService jobService) {
		this.jobService = jobService;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getIdcad() {
		return idcad;
	}

	public void setIdcad(String idcad) {
		this.idcad = idcad;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getStudyeffort() {
		return studyeffort;
	}

	public void setStudyeffort(String studyeffort) {
		this.studyeffort = studyeffort;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public long getTel() {
		return tel;
	}

	public void setTel(long tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getIsstock() {
		return isstock;
	}

	public void setIsstock(int isstock) {
		this.isstock = isstock;
	}

	public String getCurrPageStr() {
		return currPageStr;
	}

	public void setCurrPageStr(String currPageStr) {
		this.currPageStr = currPageStr;
	}
	@Override
	public String execute() throws Exception {
		return super.execute();
	}
	/**
	 *进行信息添加！
	 */
	public String joblist_add() throws Exception{
		if(!jobService.exists((String) ActionContext.getContext().getSession().get("username"))){
			this.addFieldError("xu_id", "您的用户权限不足，不能进行员工信息添加！！");
			return INPUT;
		}else{
			Job addjob=new Job();
			addjob.setXj_name(name);
			addjob.setXj_sex(sex);
			addjob.setXj_age(age);
			addjob.setXj_job(job);
			addjob.setXj_idcad(idcad);
			addjob.setXj_specialty(specialty);
			addjob.setXj_experience(experience);
			addjob.setXj_studyeffort(studyeffort);
			addjob.setXj_school(school);
			addjob.setXj_tel(tel);
			addjob.setXj_email(email);
			addjob.setXj_createtime(new Date());
			addjob.setXj_content(content);
            addjob.setXj_isstock(isstock);
            System.out.println(isstock+"ruku?");
            jobService.register(addjob);
            ActionContext.getContext().put("addjob", addjob);
            return SUCCESS;
		}
	}
	/**
	 *进行分页查询 
	 */
	public String joblist_list() throws Exception{
		String currPageStr = (String) ServletActionContext.getRequest().getAttribute("currPageStr");//获取当前页数
		int currPage=1;
		if(currPageStr!=null){
			currPage = Integer.parseInt(currPageStr);
		}
		PageBean<Job> pageBean= jobService.findByPage(currPage);
		//将pagebean存入到值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		return SUCCESS;
	}
	public String joblist_rc() throws Exception{
		String currPageStr = (String) ServletActionContext.getRequest().getAttribute("currPageStr");//获取当前页数
		int currPage=1;
		if(currPageStr!=null){
			currPage = Integer.parseInt(currPageStr);
		}
		PageBean<Job> pageBean= jobService.findByPage(currPage,1);
		//将pagebean存入到值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		return SUCCESS;
	}
	/**
	 *进行查询
	 */
	public String joblist_query() throws Exception{
		String jid=ServletActionContext.getRequest().getParameter("jid");
		Job job=jobService.query(Integer.parseInt(jid));
		ActionContext.getContext().put("job", job);
		return SUCCESS;
	}
	public String joblist_edits() throws Exception{
		String jids=ServletActionContext.getRequest().getParameter("jids");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		Job editjob=new Job();
		createtime=sdf.parse(sdf.format(createtime));
		Date entime=new Date();
		if(createtime.getTime()>entime.getTime()){
			this.addActionError("时间必须小于等于当前时间！！");
			return INPUT;
		}
		editjob.setXj_id(Integer.parseInt(jids));
		editjob.setXj_name(name);
		editjob.setXj_sex(sex);
		editjob.setXj_age(age);
		editjob.setXj_job(job);
		editjob.setXj_idcad(idcad);
		editjob.setXj_specialty(specialty);
		editjob.setXj_experience(experience);
		editjob.setXj_studyeffort(studyeffort);
		editjob.setXj_school(school);
		editjob.setXj_tel(tel);
		editjob.setXj_email(email);
		editjob.setXj_createtime(sdf.parse(sdf.format(createtime)));
		editjob.setXj_content(content);
		editjob.setXj_isstock(isstock);
        jobService.edits(editjob);
        return SUCCESS;
	}
	public String joblist_edit() throws Exception{
		String jids=ServletActionContext.getRequest().getParameter("jid");
		Job jobs=jobService.query(Integer.parseInt(jids));
		ActionContext.getContext().put("jobs", jobs);
		return SUCCESS;
	}
	public String joblist_delete() throws Exception{
		String jids=ServletActionContext.getRequest().getParameter("jid");
		jobService.delete(Integer.parseInt(jids));
		return SUCCESS;
	}
	public String joblist_deletes() throws Exception{
		String delValue=ServletActionContext.getRequest().getParameter("delValue");
		String delValues=delValue.substring(1, delValue.length());
		jobService.deletes(delValues);
		return SUCCESS;
	}
	
}
