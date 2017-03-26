package com.wssearch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by cristph on 2017/3/26.
 */

@Entity
@Table(name = "WS_AJJBQKXSYS")
public class WsAjjbqkxsys implements Serializable {

    private Integer ajxh;
    private String zkdl;
    private String bhdl;
    private String xsbssld;
    private String fdmsssqqd;
    private String zkss;
    private String zkzj;
    private String zkyj;

    @Id
    @Column(name = "AJXH", nullable = false)
    public Integer getAjxh() {
        return ajxh;
    }

    public void setAjxh(Integer ajxh) {
        this.ajxh = ajxh;
    }

    @Column(name = "ZKDL")
    public String getZkdl() {
        return zkdl;
    }

    public void setZkdl(String zkdl) {
        this.zkdl = zkdl;
    }

    @Column(name = "BHDL")
    public String getBhdl() {
        return bhdl;
    }

    public void setBhdl(String bhdl) {
        this.bhdl = bhdl;
    }

    @Column(name = "XSBSSLD")
    public String getXsbssld() {
        return xsbssld;
    }

    public void setXsbssld(String xsbssld) {
        this.xsbssld = xsbssld;
    }

    @Column(name = "FDMSSSQQD")
    public String getFdmsssqqd() {
        return fdmsssqqd;
    }

    public void setFdmsssqqd(String fdmsssqqd) {
        this.fdmsssqqd = fdmsssqqd;
    }

    @Column(name = "ZKSS")
    public String getZkss() {
        return zkss;
    }

    public void setZkss(String zkss) {
        this.zkss = zkss;
    }

    @Column(name = "ZKZJ")
    public String getZkzj() {
        return zkzj;
    }

    public void setZkzj(String zkzj) {
        this.zkzj = zkzj;
    }
    @Column(name = "ZKYJ")
    public String getZkyj() {
        return zkyj;
    }

    public void setZkyj(String zkyj) {
        this.zkyj = zkyj;
    }
}
