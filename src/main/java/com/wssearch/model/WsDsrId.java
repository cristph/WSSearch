package com.wssearch.model;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * Created by cristph on 2017/3/25.
 */
public class WsDsrId implements Serializable {
    private Integer ajxh;
    private Integer dsrbh;

    @Column(name = "AJXH", nullable = false)
    public Integer getAjxh() {
        return this.ajxh;
    }

    public void setAjxh(Integer ajxh) {
        this.ajxh = ajxh;
    }

    @Column(name = "DSRBH", nullable = false)
    public Integer getDsrbh() {
        return dsrbh;
    }

    public void setDsrbh(Integer dsrbh) {
        this.dsrbh = dsrbh;
    }

    @Override
    public int hashCode() {
        int result = 17;

        result = 37 * result
                + (getAjxh() == null ? 0 : this.getAjxh().hashCode());
        result = 37 * result
                + (getDsrbh() == null ? 0 : this.getDsrbh().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof WsDsrId))
            return false;
        WsDsrId castOther = (WsDsrId) other;

        return ((this.getAjxh() == castOther.getAjxh()) || (this.getAjxh() != null
                && castOther.getAjxh() != null && this.getAjxh().equals(
                castOther.getAjxh())))
                && ((this.getDsrbh() == castOther.getDsrbh()) || (this
                .getDsrbh() != null && castOther.getDsrbh() != null && this
                .getDsrbh().equals(castOther.getDsrbh())));
    }
}
