package com.oaec.ssh.domain;

public class XForeign {
	private Integer xu_id;
	private Integer xj_id;
	private Integer xe_id;
	private Integer xi_id;
	private Integer xs_id;
	private Integer xm_id;
	public Integer getXu_id() {
		return xu_id;
	}
	public void setXu_id(Integer xu_id) {
		this.xu_id = xu_id;
	}
	public Integer getXj_id() {
		return xj_id;
	}
	public void setXj_id(Integer xj_id) {
		this.xj_id = xj_id;
	}
	public Integer getXe_id() {
		return xe_id;
	}
	public void setXe_id(Integer xe_id) {
		this.xe_id = xe_id;
	}
	public Integer getXi_id() {
		return xi_id;
	}
	public void setXi_id(Integer xi_id) {
		this.xi_id = xi_id;
	}
	public Integer getXs_id() {
		return xs_id;
	}
	public void setXs_id(Integer xs_id) {
		this.xs_id = xs_id;
	}
	public Integer getXm_id() {
		return xm_id;
	}
	public void setXm_id(Integer xm_id) {
		this.xm_id = xm_id;
	}
	public XForeign(Integer xu_id, Integer xj_id, Integer xe_id, Integer xi_id,
			Integer xs_id, Integer xm_id) {
		super();
		this.xu_id = xu_id;
		this.xj_id = xj_id;
		this.xe_id = xe_id;
		this.xi_id = xi_id;
		this.xs_id = xs_id;
		this.xm_id = xm_id;
	}
	public XForeign() {
		super();
	}
	@Override
	public String toString() {
		return "XForeign [xu_id=" + xu_id + ", xj_id=" + xj_id + ", xe_id="
				+ xe_id + ", xi_id=" + xi_id + ", xs_id=" + xs_id + ", xm_id="
				+ xm_id + "]";
	}
}
