package com.oaec.ssh.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="x_educate")
public class Educate {
	@Id
	private Integer xe_id;
	@Column
	private String xe_name;
	@Column
	private String xe_purpose;
	@Column
	private Date xe_begintime;
	@Column
	private Date xe_endtime;
	@Column
	private String xe_datum;
	@Column
	private String xe_teacher;
	@Column
	private String xe_student;
	@Column
	private Date xe_createtime;
	@Column
	private int xe_educate;
	@Column
	private String xe_effect;
	@Column
	private String xe_summarize;
	
	public Educate() {
		super();
	}

	public Integer getXe_id() {
		return xe_id;
	}

	public void setXe_id(Integer xe_id) {
		this.xe_id = xe_id;
	}

	public String getXe_name() {
		return xe_name;
	}

	public void setXe_name(String xe_name) {
		this.xe_name = xe_name;
	}

	public String getXe_purpose() {
		return xe_purpose;
	}

	public void setXe_purpose(String xe_purpose) {
		this.xe_purpose = xe_purpose;
	}

	public Date getXe_begintime() {
		return xe_begintime;
	}

	public void setXe_begintime(Date xe_begintime) {
		this.xe_begintime = xe_begintime;
	}

	public Date getXe_endtime() {
		return xe_endtime;
	}

	public void setXe_endtime(Date xe_endtime) {
		this.xe_endtime = xe_endtime;
	}

	public String getXe_datum() {
		return xe_datum;
	}

	public void setXe_datum(String xe_datum) {
		this.xe_datum = xe_datum;
	}

	public String getXe_teacher() {
		return xe_teacher;
	}

	public void setXe_teacher(String xe_teacher) {
		this.xe_teacher = xe_teacher;
	}

	public String getXe_student() {
		return xe_student;
	}

	public void setXe_student(String xe_student) {
		this.xe_student = xe_student;
	}

	public Date getXe_createtime() {
		return xe_createtime;
	}

	public void setXe_createtime(Date xe_createtime) {
		this.xe_createtime = xe_createtime;
	}

	public int getXe_educate() {
		return xe_educate;
	}

	public void setXe_educate(int xe_educate) {
		this.xe_educate = xe_educate;
	}

	public String getXe_effect() {
		return xe_effect;
	}

	public void setXe_effect(String xe_effect) {
		this.xe_effect = xe_effect;
	}

	public String getXe_summarize() {
		return xe_summarize;
	}

	public void setXe_summarize(String xe_summarize) {
		this.xe_summarize = xe_summarize;
	}

	public Educate(Integer xe_id, String xe_name, String xe_purpose,
			Date xe_begintime, Date xe_endtime, String xe_datum,
			String xe_teacher, String xe_student, Date xe_createtime,
			int xe_educate, String xe_effect, String xe_summarize) {
		super();
		this.xe_id = xe_id;
		this.xe_name = xe_name;
		this.xe_purpose = xe_purpose;
		this.xe_begintime = xe_begintime;
		this.xe_endtime = xe_endtime;
		this.xe_datum = xe_datum;
		this.xe_teacher = xe_teacher;
		this.xe_student = xe_student;
		this.xe_createtime = xe_createtime;
		this.xe_educate = xe_educate;
		this.xe_effect = xe_effect;
		this.xe_summarize = xe_summarize;
	}

	@Override
	public String toString() {
		return "Educate [xe_id=" + xe_id + ", xe_name=" + xe_name
				+ ", xe_purpose=" + xe_purpose + ", xe_begintime="
				+ xe_begintime + ", xe_endtime=" + xe_endtime + ", xe_datum="
				+ xe_datum + ", xe_teacher=" + xe_teacher + ", xe_student="
				+ xe_student + ", xe_createtime=" + xe_createtime
				+ ", xe_educate=" + xe_educate + ", xe_effect=" + xe_effect
				+ ", xe_summarize=" + xe_summarize + "]";
	}
	
}
