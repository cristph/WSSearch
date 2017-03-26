package com.wssearch.model;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * WsCpfxgcFlftDoId entity. @author MyEclipse Persistence Tools
 */
public class WsCpfxgcFlftId implements Serializable {
	private Integer ajxh;
	private Integer ftbh;

	@Column(name = "AJXH", nullable = false)
	public Integer getAjxh() {
		return this.ajxh;
	}

	public void setAjxh(Integer ajxh) {
		this.ajxh = ajxh;
	}

	@Column(name = "FTBH", nullable = false)
	public Integer getFtbh() {
		return ftbh;
	}

	public void setFtbh(Integer ftbh) {
		this.ftbh = ftbh;
	}
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof WsCpfxgcFlftId))
			return false;
		WsCpfxgcFlftId castOther = (WsCpfxgcFlftId) other;

		return ((this.getAjxh() == castOther.getAjxh()) || (this.getAjxh() != null
				&& castOther.getAjxh() != null && this.getAjxh().equals(
				castOther.getAjxh())))
				&& ((this.getFtbh() == castOther.getFtbh()) || (this
						.getFtbh() != null && castOther.getFtbh() != null && this
						.getFtbh().equals(castOther.getFtbh())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getAjxh() == null ? 0 : this.getAjxh().hashCode());
		result = 37 * result
				+ (getFtbh() == null ? 0 : this.getFtbh().hashCode());
		return result;
	}

}