package com.wssearch.model;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * Created by cristph on 2017/3/25.
 */
public class WsssjlzkjlId implements Serializable{
    private Integer ajxh;
    private Integer zkjlbh;

    @Column(name = "AJXH", nullable = false)
    public Integer getAjxh() {
        return this.ajxh;
    }

    public void setAjxh(Integer ajxh) {
        this.ajxh = ajxh;
    }

    @Column(name = "ZKJLBH", nullable = false)
    public Integer getZkjlbh() {
        return zkjlbh;
    }

    public void setZkjlbh(Integer zkjlbh) {
        this.zkjlbh = zkjlbh;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof WsssjlzkjlId))
            return false;
        WsssjlzkjlId castOther = (WsssjlzkjlId) other;

        return ((this.getAjxh() == castOther.getAjxh()) || (this.getAjxh() != null
                && castOther.getAjxh() != null && this.getAjxh().equals(
                castOther.getAjxh())))
                && ((this.getZkjlbh() == castOther.getZkjlbh()) || (this
                .getZkjlbh() != null && castOther.getZkjlbh() != null && this
                .getZkjlbh().equals(castOther.getZkjlbh())));
    }



    public int hashCode() {
        int result = 17;
        result = 37 * result
                + (getAjxh() == null ? 0 : this.getAjxh().hashCode());
        result = 37 * result
                + (getZkjlbh() == null ? 0 : this.getZkjlbh().hashCode());
        return result;
    }
}
