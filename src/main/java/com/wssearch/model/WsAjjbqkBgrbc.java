package com.wssearch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WS_AJJBQK_BGRBC")
public class WsAjjbqkBgrbc {
    private Integer ajxh;
    private Integer bh;
    private String nr;

	@Column(name = "AJXH", nullable = false)
    public Integer getAjxh() {
        return ajxh;
    }

    public void setAjxh(Integer ajxh) {
        this.ajxh = ajxh;
    }
    @Id
    @Column(name = "BH", nullable = false)
    public Integer getBh() {
        return bh;
    }

    public void setBh(Integer bh) {
        this.bh = bh;
    }

    @Column(name = "NR")
    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }
}
