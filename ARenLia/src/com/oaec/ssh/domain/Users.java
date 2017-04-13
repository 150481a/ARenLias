package com.oaec.ssh.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *用户管理的domain
 */
@Entity
@Table(name = "x_users")
public class Users {
	@Id
	private Integer xu_id;
	@Column
	private String xu_username;
	@Column
	private String xu_password;
	@Column
	private String xu_name;
	@Column
	private int xu_sex;
	@Column
	private Date xu_birthday;
	@Column
	private  Date xu_createtime;
	@Column
	private Date xu_edittime;
	@Column
	private int xu_isadmin;
	@Column
	private String xu_content;

	public Users() {
		super();
	}

	public Integer getXu_id() {
		return xu_id;
	}

	public void setXu_id(Integer xu_id) {
		this.xu_id = xu_id;
	}

	public String getXu_username() {
		return xu_username;
	}

	public void setXu_username(String xu_username) {
		this.xu_username = xu_username;
	}

	public String getXu_password() {
		return xu_password;
	}
    
	public Date getXu_createtime() {
		return xu_createtime;
	}

	public void setXu_createtime(Date xu_createtime) {
		this.xu_createtime = xu_createtime;
	}

	public int getXu_isadmin() {
		return xu_isadmin;
	}

	public void setXu_isadmin(int xu_isadmin) {
		this.xu_isadmin = xu_isadmin;
	}

	public void setXu_password(String xu_password) {
		this.xu_password = xu_password;
	}

	public String getXu_name() {
		return xu_name;
	}

	public void setXu_name(String xu_name) {
		this.xu_name = xu_name;
	}

	public int getXu_sex() {
		return xu_sex;
	}

	public void setXu_sex(int xu_sex) {
		this.xu_sex = xu_sex;
	}

	public Date getXu_birthday() {
		return xu_birthday;
	}

	public void setXu_birthday(Date xu_birthday) {
		this.xu_birthday = xu_birthday;
	}


	public String getXu_content() {
		return xu_content;
	}

	public void setXu_content(String xu_content) {
		this.xu_content = xu_content;
	}

	public Date getXu_edittime() {
		return xu_edittime;
	}

	public void setXu_edittime(Date xu_edittime) {
		this.xu_edittime = xu_edittime;
	}

	@Override
	public String toString() {
		return "Users [xu_id=" + xu_id + ", xu_username=" + xu_username
				+ ", xu_password=" + xu_password + ", xu_name=" + xu_name
				+ ", xu_sex=" + xu_sex + ", xu_birthday=" + xu_birthday
				+ ", xu_createtime=" + xu_createtime + ", xu_edittime="
				+ xu_edittime + ", xu_isadmin=" + xu_isadmin + ", xu_content="
				+ xu_content + "]";
	}

	public Users(Integer xu_id, String xu_username, String xu_password,
			String xu_name, int xu_sex, Date xu_birthday, Date xu_createtime,
			Date xu_edittime, int xu_isadmin, String xu_content) {
		super();
		this.xu_id = xu_id;
		this.xu_username = xu_username;
		this.xu_password = xu_password;
		this.xu_name = xu_name;
		this.xu_sex = xu_sex;
		this.xu_birthday = xu_birthday;
		this.xu_createtime = xu_createtime;
		this.xu_edittime = xu_edittime;
		this.xu_isadmin = xu_isadmin;
		this.xu_content = xu_content;
	}
    
}
