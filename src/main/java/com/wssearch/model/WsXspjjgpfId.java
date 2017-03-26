package com.wssearch.model;

import javax.persistence.Column;

/**
 * WsXspjjgpfDOId entity. @author MyEclipse Persistence Tools
 */
public class WsXspjjgpfId implements java.io.Serializable {

	private Integer ajxh;
	private Integer fzbh;
	private Integer pfbh;

	@Column(name = "AJXH", nullable = false)
	public Integer getAjxh() {
		return this.ajxh;
	}

	public void setAjxh(Integer ajxh) {
		this.ajxh = ajxh;
	}

	@Column(name = "FZBH", nullable = false)
	public Integer getFzbh() {
		return fzbh;
	}

	public void setFzbh(Integer fzbh) {
		this.fzbh = fzbh;
	}
	@Column(name = "PFBH", nullable = false)
	public Integer getPfbh() {
		return pfbh;
	}

	public void setPfbh(Integer pfbh) {
		this.pfbh = pfbh;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof WsXspjjgpfId))
			return false;
		WsXspjjgpfId castOther = (WsXspjjgpfId) other;

		return ((this.getAjxh() == castOther.getAjxh()) || (this.getAjxh() != null
				&& castOther.getAjxh() != null && this.getAjxh().equals(
				castOther.getAjxh())))
				&& ((this.getFzbh() == castOther.getFzbh()) || (this
						.getFzbh() != null && castOther.getFzbh() != null && this
						.getFzbh().equals(castOther.getFzbh())))
				&& ((this.getPfbh() == castOther.getPfbh()) || (this
								.getPfbh() != null && castOther.getPfbh() != null && this
								.getPfbh().equals(castOther.getPfbh())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getAjxh() == null ? 0 : this.getAjxh().hashCode());
		result = 37 * result
				+ (getFzbh() == null ? 0 : this.getFzbh().hashCode());
		result = 37 * result
				+ (getPfbh() == null ? 0 : this.getPfbh().hashCode());
		return result;
	}

}