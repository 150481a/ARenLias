package com.oaec.ssh.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *招聘管理的DAO层的domain
 */
@Entity
@Table(name="x_job")
public class Job {
	@Id
	private Integer xj_id;
	@Column
	private String xj_name;
	@Column
	private int xj_sex;
	@Column
	private Integer xj_age;
	@Column
	private String xj_job;
	@Column
	private String xj_idcad;
	@Column
	private String xj_specialty;
	@Column
	private String xj_experience;
	@Column
	private String xj_studyeffort;
	@Column
	private String xj_school;
	@Column
	private long xj_tel;
	@Column
	private String xj_email;
	@Column
	private Date xj_createtime;
	@Column
	private String xj_content;
	@Column
	private int xj_isstock;
	
	public String getXj_idcad() {
		return xj_idcad;
	}

	public void setXj_idcad(String xj_idcad) {
		this.xj_idcad = xj_idcad;
	}

	public Job() {
		super();
	}

	public Integer getXj_id() {
		return xj_id;
	}

	public void setXj_id(Integer xj_id) {
		this.xj_id = xj_id;
	}

	public String getXj_name() {
		return xj_name;
	}

	public void setXj_name(String xj_name) {
		this.xj_name = xj_name;
	}

	public int getXj_sex() {
		return xj_sex;
	}

	public void setXj_sex(int xj_sex) {
		this.xj_sex = xj_sex;
	}

	public Integer getXj_age() {
		return xj_age;
	}

	public void setXj_age(Integer xj_age) {
		this.xj_age = xj_age;
	}

	public String getXj_job() {
		return xj_job;
	}

	public void setXj_job(String xj_job) {
		this.xj_job = xj_job;
	}

	public String getXj_specialty() {
		return xj_specialty;
	}

	public void setXj_specialty(String xj_specialty) {
		this.xj_specialty = xj_specialty;
	}

	public String getXj_experience() {
		return xj_experience;
	}

	public void setXj_experience(String xj_experience) {
		this.xj_experience = xj_experience;
	}

	public String getXj_studyeffort() {
		return xj_studyeffort;
	}

	public void setXj_studyeffort(String xj_studyeffort) {
		this.xj_studyeffort = xj_studyeffort;
	}

	public String getXj_school() {
		return xj_school;
	}

	public void setXj_school(String xj_school) {
		this.xj_school = xj_school;
	}

	public long getXj_tel() {
		return xj_tel;
	}
	public void setXj_tel(long xj_tel) {
		this.xj_tel = xj_tel;
	}

	public String getXj_email() {
		return xj_email;
	}

	public void setXj_email(String xj_email) {
		this.xj_email = xj_email;
	}

	public Date getXj_createtime() {
		return xj_createtime;
	}

	public void setXj_createtime(Date xj_createtime) {
		this.xj_createtime = xj_createtime;
	}

	public String getXj_content() {
		return xj_content;
	}

	public void setXj_content(String xj_content) {
		this.xj_content = xj_content;
	}

	public int getXj_isstock() {
		return xj_isstock;
	}

	public void setXj_isstock(int xj_isstock) {
		this.xj_isstock = xj_isstock;
	}

	@Override
	public String toString() {
		return "Job [xj_id=" + xj_id + ", xj_name=" + xj_name + ", xj_sex="
				+ xj_sex + ", xj_age=" + xj_age + ", xj_job=" + xj_job
				+ ", xj_idcad=" + xj_idcad + ", xj_specialty=" + xj_specialty
				+ ", xj_experience=" + xj_experience + ", xj_studyeffort="
				+ xj_studyeffort + ", xj_school=" + xj_school + ", xj_tel="
				+ xj_tel + ", xj_email=" + xj_email + ", xj_createtime="
				+ xj_createtime + ", xj_content=" + xj_content
				+ ", xj_isstock=" + xj_isstock + "]";
	}

	public Job(Integer xj_id, String xj_name, int xj_sex, Integer xj_age,
			String xj_job, String xj_idcad, String xj_specialty,
			String xj_experience, String xj_studyeffort, String xj_school,
			long xj_tel, String xj_email, Date xj_createtime,
			String xj_content, int xj_isstock) {
		super();
		this.xj_id = xj_id;
		this.xj_name = xj_name;
		this.xj_sex = xj_sex;
		this.xj_age = xj_age;
		this.xj_job = xj_job;
		this.xj_idcad = xj_idcad;
		this.xj_specialty = xj_specialty;
		this.xj_experience = xj_experience;
		this.xj_studyeffort = xj_studyeffort;
		this.xj_school = xj_school;
		this.xj_tel = xj_tel;
		this.xj_email = xj_email;
		this.xj_createtime = xj_createtime;
		this.xj_content = xj_content;
		this.xj_isstock = xj_isstock;
	}
}
