package com.oaec.ssh.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="x_institution")
public class Institution {
	@Id
	private Integer xi_id;
	@Column
	private String xi_name;
	@Column
	private String xi_reason;
	@Column
	private String xi_explains;
	@Column
	private Date xi_createtime;
	
	public Institution() {
		super();
	}

	public Integer getXi_id() {
		return xi_id;
	}

	public void setXi_id(Integer xi_id) {
		this.xi_id = xi_id;
	}

	public String getXi_name() {
		return xi_name;
	}

	public void setXi_name(String xi_name) {
		this.xi_name = xi_name;
	}

	public String getXi_reason() {
		return xi_reason;
	}

	public void setXi_reason(String xi_reason) {
		this.xi_reason = xi_reason;
	}

	public String getXi_explains() {
		return xi_explains;
	}

	public void setXi_explains(String xi_explains) {
		this.xi_explains = xi_explains;
	}

	public Date getXi_createtime() {
		return xi_createtime;
	}

	public void setXi_createtime(Date xi_createtime) {
		this.xi_createtime = xi_createtime;
	}

	public Institution(Integer xi_id, String xi_name, String xi_reason,
			String xi_explains, Date xi_createtime) {
		super();
		this.xi_id = xi_id;
		this.xi_name = xi_name;
		this.xi_reason = xi_reason;
		this.xi_explains = xi_explains;
		this.xi_createtime = xi_createtime;
	}

	@Override
	public String toString() {
		return "Institution [xi_id=" + xi_id + ", xi_name=" + xi_name
				+ ", xi_reason=" + xi_reason + ", xi_explains=" + xi_explains
				+ ", xi_createtime=" + xi_createtime + "]";
	}
	
    
}
