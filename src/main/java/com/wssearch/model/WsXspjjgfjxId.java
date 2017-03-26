package com.wssearch.model;

import javax.persistence.Column;

/**
 * WsXspjjgfjxDOId entity. @author MyEclipse Persistence Tools
 */
public class WsXspjjgfjxId implements java.io.Serializable {

	private Integer ajxh;
	private Integer fjxbh;

	@Column(name = "AJXH", nullable = false)
	public Integer getAjxh() {
		return this.ajxh;
	}

	public void setAjxh(Integer ajxh) {
		this.ajxh = ajxh;
	}

	@Column(name = "FJXBH", nullable = false)
	public Integer getFjxbh() {
		return fjxbh;
	}

	public void setFjxbh(Integer fjxbh) {
		this.fjxbh = fjxbh;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof WsXspjjgfjxId))
			return false;
		WsXspjjgfjxId castOther = (WsXspjjgfjxId) other;

		return ((this.getAjxh() == castOther.getAjxh()) || (this.getAjxh() != null
				&& castOther.getAjxh() != null && this.getAjxh().equals(
				castOther.getAjxh())))
				&& ((this.getFjxbh() == castOther.getFjxbh()) || (this
						.getFjxbh() != null && castOther.getFjxbh() != null && this
						.getFjxbh().equals(castOther.getFjxbh())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getAjxh() == null ? 0 : this.getAjxh().hashCode());
		result = 37 * result
				+ (getFjxbh() == null ? 0 : this.getFjxbh().hashCode());
		return result;
	}

}