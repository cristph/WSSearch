package com.wssearch.model;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * Created by cristph on 2017/3/25.
 */
public class WsSsjlCtrId implements Serializable{
    private Integer ajxh;
    private Integer ctrbh;

    @Column(name = "AJXH", nullable = false)
    public Integer getAjxh() {
        return this.ajxh;
    }

    public void setAjxh(Integer ajxh) {
        this.ajxh = ajxh;
    }

    @Column(name = "CTRBH", nullable = false)
    public Integer getCtrbh() {
        return ctrbh;
    }

    public void setCtrbh(Integer ctrbh) {
        this.ctrbh = ctrbh;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof WsSsjlCtrId))
            return false;
        WsSsjlCtrId castOther = (WsSsjlCtrId) other;

        return ((this.getAjxh() == castOther.getAjxh()) || (this.getAjxh() != null
                && castOther.getAjxh() != null && this.getAjxh().equals(
                castOther.getAjxh())))
                && ((this.getCtrbh() == castOther.getCtrbh()) || (this
                .getCtrbh() != null && castOther.getCtrbh() != null && this
                .getCtrbh().equals(castOther.getCtrbh())));
    }


    public int hashCode() {
        int result = 17;
        result = 37 * result
                + (getAjxh() == null ? 0 : this.getAjxh().hashCode());
        result = 37 * result
                + (getCtrbh() == null ? 0 : this.getCtrbh().hashCode());
        return result;
    }
}
