package com.wssearch.model;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * Created by cristph on 2017/3/25.
 */
public class WsSsjlZkzmId implements Serializable{
    private Integer ajxh;
    private Integer zmbh;

    @Column(name = "AJXH", nullable = false)
    public Integer getAjxh() {
        return this.ajxh;
    }

    public void setAjxh(Integer ajxh) {
        this.ajxh = ajxh;
    }

    @Column(name = "ZMBH", nullable = false)
    public Integer getZmbh() {
        return zmbh;
    }

    public void setZmbh(Integer zmbh) {
        this.zmbh = zmbh;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof WsSsjlZkzmId))
            return false;
        WsSsjlZkzmId castOther = (WsSsjlZkzmId) other;

        return ((this.getAjxh() == castOther.getAjxh()) || (this.getAjxh() != null
                && castOther.getAjxh() != null && this.getAjxh().equals(
                castOther.getAjxh())))
                && ((this.getZmbh() == castOther.getZmbh()) || (this
                .getZmbh() != null && castOther.getZmbh() != null && this
                .getZmbh().equals(castOther.getZmbh())));
    }



    public int hashCode() {
        int result = 17;
        result = 37 * result
                + (getAjxh() == null ? 0 : this.getAjxh().hashCode());
        result = 37 * result
                + (getZmbh() == null ? 0 : this.getZmbh().hashCode());
        return result;
    }
}
