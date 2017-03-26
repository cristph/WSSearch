package com.wssearch.model;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * WsXspjjgfzDOId entity. @author MyEclipse Persistence Tools
 */
public class WsXspjjgfzId implements Serializable {

	private Integer ajxh;
	private Integer fzbh;

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
	
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof WsXspjjgfzId))
			return false;
		WsXspjjgfzId castOther = (WsXspjjgfzId) other;

		return ((this.getAjxh() == castOther.getAjxh()) || (this.getAjxh() != null
				&& castOther.getAjxh() != null && this.getAjxh().equals(
				castOther.getAjxh())))
				&& ((this.getFzbh() == castOther.getFzbh()) || (this
						.getFzbh() != null && castOther.getFzbh() != null && this
						.getFzbh().equals(castOther.getFzbh())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getAjxh() == null ? 0 : this.getAjxh().hashCode());
		result = 37 * result
				+ (getFzbh() == null ? 0 : this.getFzbh().hashCode());
		return result;
	}

}