package com.wssearch.model;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * WsCpfxgcLxqjDOId entity. @author MyEclipse Persistence Tools
 */
public class WsCpfxgcLxqjId implements Serializable {

	private Integer ajxh;
	private Integer lxqjbh;


	@Column(name = "AJXH", nullable = false)
	public Integer getAjxh() {
		return this.ajxh;
	}

	public void setAjxh(Integer ajxh) {
		this.ajxh = ajxh;
	}

	@Column(name = "LXQJBH", nullable = false)
	public Integer getLxqjbh() {
		return lxqjbh;
	}

	public void setLxqjbh(Integer lxqjbh) {
		this.lxqjbh = lxqjbh;
	}
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof WsCpfxgcLxqjId))
			return false;
		WsCpfxgcLxqjId castOther = (WsCpfxgcLxqjId) other;

		return ((this.getAjxh() == castOther.getAjxh()) || (this.getAjxh() != null
				&& castOther.getAjxh() != null && this.getAjxh().equals(
				castOther.getAjxh())))
				&& ((this.getLxqjbh() == castOther.getLxqjbh()) || (this
						.getLxqjbh() != null && castOther.getLxqjbh() != null && this
						.getLxqjbh().equals(castOther.getLxqjbh())));
	}

	

	

	

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getAjxh() == null ? 0 : this.getAjxh().hashCode());
		result = 37 * result
				+ (getLxqjbh() == null ? 0 : this.getLxqjbh().hashCode());
		return result;
	}

}