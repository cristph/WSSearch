package com.wssearch.model;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * Created by cristph on 2017/3/25.
 */
public class WsDsrQzcsId implements Serializable{

    private Integer ajxh;
    private Integer qzcsbh;

    @Column(name = "AJXH", nullable = false)
    public Integer getAjxh() {
        return this.ajxh;
    }

    public void setAjxh(Integer ajxh) {
        this.ajxh = ajxh;
    }

    @Column(name = "QZCSBH", nullable = false)
    public Integer getQzcsbh() {
        return qzcsbh;
    }

    public void setQzcsbh(Integer qzcsbh) {
        this.qzcsbh = qzcsbh;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof WsDsrQzcsId))
            return false;
        WsDsrQzcsId castOther = (WsDsrQzcsId) other;

        return ((this.getAjxh() == castOther.getAjxh()) || (this.getAjxh() != null
                && castOther.getAjxh() != null && this.getAjxh().equals(
                castOther.getAjxh())))
                && ((this.getQzcsbh() == castOther.getQzcsbh()) || (this
                .getQzcsbh() != null && castOther.getQzcsbh() != null && this
                .getQzcsbh().equals(castOther.getQzcsbh())));
    }

    public int hashCode() {
        int result = 17;
        result = 37 * result
                + (getAjxh() == null ? 0 : this.getAjxh().hashCode());
        result = 37 * result
                + (getQzcsbh() == null ? 0 : this.getQzcsbh().hashCode());
        return result;
    }
}
