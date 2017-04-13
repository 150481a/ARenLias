package com.oaec.ssh.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="x_stipend")
public class Stipend {
	@Id
	private Integer xs_id;
	@Column
	private String xs_name;
	@Column
	private String xs_person;
	@Column
	private double xs_basic;
	@Column
	private double xs_eat;
	@Column
	private double xs_house;
	@Column
	private double xs_duty;
	@Column
	private double xs_scot;
	@Column
	private double xs_punishment;
	@Column
	private double xs_other;
	@Column
	private Date xs_granttime;
	@Column
	private double xs_totalize;
	@Column
	private int xs_remarks;
	
	public Stipend() {
		super();
	}

	public Integer getXs_id() {
		return xs_id;
	}

	public void setXs_id(Integer xs_id) {
		this.xs_id = xs_id;
	}

	public String getXs_name() {
		return xs_name;
	}

	public void setXs_name(String xs_name) {
		this.xs_name = xs_name;
	}

	public String getXs_person() {
		return xs_person;
	}

	public void setXs_person(String xs_person) {
		this.xs_person = xs_person;
	}

	public double getXs_basic() {
		return xs_basic;
	}

	public void setXs_basic(double xs_basic) {
		this.xs_basic = xs_basic;
	}

	public double getXs_eat() {
		return xs_eat;
	}

	public void setXs_eat(double xs_eat) {
		this.xs_eat = xs_eat;
	}

	public double getXs_house() {
		return xs_house;
	}

	public void setXs_house(double xs_house) {
		this.xs_house = xs_house;
	}

	public double getXs_duty() {
		return xs_duty;
	}

	public void setXs_duty(double xs_duty) {
		this.xs_duty = xs_duty;
	}

	public double getXs_scot() {
		return xs_scot;
	}

	public void setXs_scot(double xs_scot) {
		this.xs_scot = xs_scot;
	}

	public double getXs_punishment() {
		return xs_punishment;
	}

	public void setXs_punishment(double xs_punishment) {
		this.xs_punishment = xs_punishment;
	}

	public double getXs_other() {
		return xs_other;
	}

	public void setXs_other(double xs_other) {
		this.xs_other = xs_other;
	}

	public Date getXs_granttime() {
		return xs_granttime;
	}

	public void setXs_granttime(Date xs_granttime) {
		this.xs_granttime = xs_granttime;
	}

	public double getXs_totalize() {
		return xs_totalize;
	}

	public void setXs_totalize(double xs_totalize) {
		this.xs_totalize = xs_totalize;
	}

	public int getXs_remarks() {
		return xs_remarks;
	}

	public void setXs_remarks(int xs_remarks) {
		this.xs_remarks = xs_remarks;
	}

	public Stipend(Integer xs_id, String xs_name, String xs_person,
			double xs_basic, double xs_eat, double xs_house, double xs_duty,
			double xs_scot, double xs_punishment, double xs_other,
			Date xs_granttime, double xs_totalize, int xs_remarks) {
		super();
		this.xs_id = xs_id;
		this.xs_name = xs_name;
		this.xs_person = xs_person;
		this.xs_basic = xs_basic;
		this.xs_eat = xs_eat;
		this.xs_house = xs_house;
		this.xs_duty = xs_duty;
		this.xs_scot = xs_scot;
		this.xs_punishment = xs_punishment;
		this.xs_other = xs_other;
		this.xs_granttime = xs_granttime;
		this.xs_totalize = xs_totalize;
		this.xs_remarks = xs_remarks;
	}
	@Override
	public String toString() {
		return "Stipend [xs_id=" + xs_id + ", xs_name=" + xs_name
				+ ", xs_person=" + xs_person + ", xs_basic=" + xs_basic
				+ ", xs_eat=" + xs_eat + ", xs_house=" + xs_house
				+ ", xs_duty=" + xs_duty + ", xs_scot=" + xs_scot
				+ ", xs_punishment=" + xs_punishment + ", xs_other=" + xs_other
				+ ", xs_granttime=" + xs_granttime + ", xs_totalize="
				+ xs_totalize + ", xs_remarks=" + xs_remarks + "]";
	}
	
}
