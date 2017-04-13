package com.oaec.ssh.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.oaec.ssh.domain.Message;
import com.oaec.ssh.domain.PageBean;
import com.oaec.ssh.domain.Stipend;
import com.oaec.ssh.service.StipendService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Component("stipendAction")
public class StipendAction  extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;//员工姓名
	private String person;//发款人
	private double basic;//基本资金
	private double eat;//饭补
	private double house;//房补
	private double duty;//赋税
	private double scot;//全勤奖
	private double punishment;//罚款
	private double other;//额外补助
	private Date granttime;//工资发放时间
	private double totalize;//总薪资
	private int  remarks;//员工类型
	private String  currPageStr;//当前页
	private StipendService stipendService;
	public StipendService getStipendService() {
		return stipendService;
	}
    @Resource(name="stipendServiceImpl")
	public void setStipendService(StipendService stipendService) {
		this.stipendService = stipendService;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public double getBasic() {
		return basic;
	}
	public void setBasic(double basic) {
		this.basic = basic;
	}
	public double getEat() {
		return eat;
	}
	public void setEat(double eat) {
		this.eat = eat;
	}
	public double getHouse() {
		return house;
	}
	public void setHouse(double house) {
		this.house = house;
	}
	public double getDuty() {
		return duty;
	}
	public void setDuty(double duty) {
		this.duty = duty;
	}
	public double getScot() {
		return scot;
	}
	public void setScot(double scot) {
		this.scot = scot;
	}
	public double getPunishment() {
		return punishment;
	}
	public void setPunishment(double punishment) {
		this.punishment = punishment;
	}
	public double getOther() {
		return other;
	}
	public void setOther(double other) {
		this.other = other;
	}
	public Date getGranttime() {
		return granttime;
	}
	public void setGranttime(Date granttime) {
		this.granttime = granttime;
	}
	public double getTotalize() {
		return totalize;
	}
	public void setTotalize(double totalize) {
		this.totalize = totalize;
	}
	public int getRemarks() {
		return remarks;
	}
	public void setRemarks(int remarks) {
		this.remarks = remarks;
	}
	public String getCurrPageStr() {
		return currPageStr;
	}
	public void setCurrPageStr(String currPageStr) {
		this.currPageStr = currPageStr;
	}
	public String stipendlist_add() throws Exception{
		if(!stipendService.exists((String) ActionContext.getContext().getSession().get("username"))){
			this.addFieldError("xu_id", "您的用户权限不足，不能进行员工信息添加！！");
			return INPUT;
		}else{
			Stipend addstipend=new Stipend();
			addstipend.setXs_name(name);
			addstipend.setXs_person(person);
			addstipend.setXs_basic(basic);
			addstipend.setXs_eat(eat);
			addstipend.setXs_house(house);
			addstipend.setXs_duty(duty);
			addstipend.setXs_scot(scot);
			addstipend.setXs_punishment(punishment);
			addstipend.setXs_other(other);
			addstipend.setXs_granttime(new Date());
			addstipend.setXs_totalize((basic+eat+house-duty+scot+-punishment+other));
			addstipend.setXs_remarks(remarks);
			stipendService.register(addstipend);
			ActionContext.getContext().getSession().put("addstipend", addstipend);
			return SUCCESS;
		}
	}
	public String stipendlist_ck() throws Exception{
		String currPageStr = ServletActionContext.getRequest().getParameter("currPageStr");//获取当前页数
		int currPage=1;
		if(currPageStr!=null){
			currPage = Integer.parseInt(currPageStr);
		}
		PageBean<Stipend> pageBean= stipendService.findByPage(currPage);
		//将pagebean存入到值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		return SUCCESS;
	}
	public String stipendlist_query() throws Exception{
		String sid=ServletActionContext.getRequest().getParameter("sid");
		Stipend stipendQ=stipendService.query(Integer.parseInt(sid));
		ActionContext.getContext().put("stipendQ", stipendQ);
		return SUCCESS;
	}
	public String stipendlist_edit() throws Exception{
		String sid=ServletActionContext.getRequest().getParameter("sid");
		Stipend stipendQ=stipendService.query(Integer.parseInt(sid));
		ActionContext.getContext().put("stipendQ", stipendQ);
		return SUCCESS;
	}
	public String stipendlist_edits() throws Exception{
		String sid=ServletActionContext.getRequest().getParameter("sid");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		Stipend stipend=new Stipend();
		stipend.setXs_id(Integer.parseInt(sid));
		stipend.setXs_name(name);
		stipend.setXs_person(person);
		stipend.setXs_basic(basic);
		stipend.setXs_eat(eat);
		stipend.setXs_house(house);
		stipend.setXs_duty(duty);
		stipend.setXs_scot(scot);
		stipend.setXs_punishment(punishment);
		stipend.setXs_other(other);
		stipend.setXs_granttime(sdf.parse(sdf.format(granttime)));
		stipend.setXs_totalize((basic+eat+house-duty+scot+-punishment+other));
		stipend.setXs_remarks(remarks);
		stipendService.edits(stipend);
		return SUCCESS;
	}
	public String stipendlist_delete() throws Exception{
		String sid=ServletActionContext.getRequest().getParameter("sid");
		System.out.println(sid+"sf ");
		stipendService.delete(Integer.parseInt(sid));
		return SUCCESS;
	}
	public String stipendlist_deletes() throws Exception{
		String delValue=ServletActionContext.getRequest().getParameter("delValue");
		String delValues=delValue.substring(1, delValue.length());
		stipendService.deletes(delValues);
		return SUCCESS;
	}
	
}
