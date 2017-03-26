package com.wssearch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by cristph on 2017/3/25.
 */
public class WsDsrQkId implements Serializable {
    private Integer ajxh;
    private Integer qkbh;

    @Column(name = "AJXH", nullable = false)
    public Integer getAjxh() {
        return this.ajxh;
    }

    public void setAjxh(Integer ajxh) {
        this.ajxh = ajxh;
    }

    @Column(name = "QKBH", nullable = false)
    public Integer getQkbh() {
        return qkbh;
    }

    public void setQkbh(Integer qkbh) {
        this.qkbh = qkbh;
    }


    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof WsDsrQkId))
            return false;
        WsDsrQkId castOther = (WsDsrQkId) other;
        return ((this.getAjxh() == castOther.getAjxh()) || (this.getAjxh() != null
                && castOther.getAjxh() != null && this.getAjxh().equals(
                castOther.getAjxh())))
                && ((this.getQkbh() == castOther.getQkbh()) || (this
                .getQkbh() != null && castOther.getQkbh() != null && this
                .getQkbh().equals(castOther.getQkbh())));
    }


    public int hashCode() {
        int result = 17;
        result = 37 * result
                + (getAjxh() == null ? 0 : this.getAjxh().hashCode());
        result = 37 * result
                + (getQkbh() == null ? 0 : this.getQkbh().hashCode());
        return result;
    }
}