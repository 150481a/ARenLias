package com.oaec.ssh.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="x_message")
public class Message {
	@Id
	private Integer xm_id;
	@Column
	private String xm_title;
	@Column
	private String xm_addressor;
	@Column
	private String xm_accept;
	@Column
	private Date xm_ressortime;
	@Column
	private Date xm_accepttime;
	@Column
	private int xm_priority;
	@Column
	private int xm_status;
	@Column
	private int xm_genre;
	@Column
	private String xm_content;
	
	public Message() {
		super();
	}

	public Integer getXm_id() {
		return xm_id;
	}

	public void setXm_id(Integer xm_id) {
		this.xm_id = xm_id;
	}

	public String getXm_title() {
		return xm_title;
	}

	public void setXm_title(String xm_title) {
		this.xm_title = xm_title;
	}

	public String getXm_addressor() {
		return xm_addressor;
	}

	public void setXm_addressor(String xm_addressor) {
		this.xm_addressor = xm_addressor;
	}

	public String getXm_accept() {
		return xm_accept;
	}

	public void setXm_accept(String xm_accept) {
		this.xm_accept = xm_accept;
	}

	public Date getXm_ressortime() {
		return xm_ressortime;
	}

	public void setXm_ressortime(Date xm_ressortime) {
		this.xm_ressortime = xm_ressortime;
	}

	public Date getXm_accepttime() {
		return xm_accepttime;
	}

	public void setXm_accepttime(Date xm_accepttime) {
		this.xm_accepttime = xm_accepttime;
	}

	public int getXm_priority() {
		return xm_priority;
	}

	public void setXm_priority(int xm_priority) {
		this.xm_priority = xm_priority;
	}

	public int getXm_status() {
		return xm_status;
	}

	public void setXm_status(int xm_status) {
		this.xm_status = xm_status;
	}

	public int getXm_genre() {
		return xm_genre;
	}

	public void setXm_genre(int xm_genre) {
		this.xm_genre = xm_genre;
	}

	public String getXm_content() {
		return xm_content;
	}

	public void setXm_content(String xm_content) {
		this.xm_content = xm_content;
	}

	@Override
	public String toString() {
		return "Message [xm_id=" + xm_id + ", xm_title=" + xm_title
				+ ", xm_addressor=" + xm_addressor + ", xm_accept=" + xm_accept
				+ ", xm_ressortime=" + xm_ressortime + ", xm_accepttime="
				+ xm_accepttime + ", xm_priority=" + xm_priority
				+ ", xm_status=" + xm_status + ", xm_genre=" + xm_genre
				+ ", xm_content=" + xm_content + "]";
	}

	public Message(Integer xm_id, String xm_title, String xm_addressor,
			String xm_accept, Date xm_ressortime, Date xm_accepttime,
			int xm_priority, int xm_status, int xm_genre, String xm_content) {
		super();
		this.xm_id = xm_id;
		this.xm_title = xm_title;
		this.xm_addressor = xm_addressor;
		this.xm_accept = xm_accept;
		this.xm_ressortime = xm_ressortime;
		this.xm_accepttime = xm_accepttime;
		this.xm_priority = xm_priority;
		this.xm_status = xm_status;
		this.xm_genre = xm_genre;
		this.xm_content = xm_content;
	}
}
