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
@Table(name = "WS_AJJBQKMSXZ")
public class WsAjjbqkmsxz implements Serializable{

    private Integer ajxh;
    private String qsdl;
    private String qsygscd;
    private String qsbgbcd;
    private String qsdsryjd;
    private String qsfsscd;
    private String qspjd;
    private String bsdl;
    private String ssrcsd;
    private String bsdsryjd;
    private String ygscd;
    private String bgbcd;
    private String dsryjd;
    private String fsscd;
    private String fsbcd;
    private String xzsszyd;

    @Id
    @Column(name = "AJXH", nullable = false)
    public Integer getAjxh() {
        return ajxh;
    }

    public void setAjxh(Integer ajxh) {
        this.ajxh = ajxh;
    }

    @Column(name = "QSDL")
    public String getQsdl() {
        return qsdl;
    }

    public void setQsdl(String qsdl) {
        this.qsdl = qsdl;
    }

    @Column(name = "QSYGSCD")
    public String getQsygscd() {
        return qsygscd;
    }

    public void setQsygscd(String qsygscd) {
        this.qsygscd = qsygscd;
    }

    @Column(name = "QSBGBCD")
    public String getQsbgbcd() {
        return qsbgbcd;
    }

    public void setQsbgbcd(String qsbgbcd) {
        this.qsbgbcd = qsbgbcd;
    }

    @Column(name = "QSDSRYJD")
    public String getQsdsryjd() {
        return qsdsryjd;
    }

    public void setQsdsryjd(String qsdsryjd) {
        this.qsdsryjd = qsdsryjd;
    }

    @Column(name = "QSFSSCD")
    public String getQsfsscd() {
        return qsfsscd;
    }

    public void setQsfsscd(String qsfsscd) {
        this.qsfsscd = qsfsscd;
    }

    @Column(name = "QSPJD")
    public String getQspjd() {
        return qspjd;
    }

    public void setQspjd(String qspjd) {
        this.qspjd = qspjd;
    }

    @Column(name = "BSDL")
    public String getBsdl() {
        return bsdl;
    }

    public void setBsdl(String bsdl) {
        this.bsdl = bsdl;
    }

    @Column(name = "SSRCSD")
    public String getSsrcsd() {
        return ssrcsd;
    }

    public void setSsrcsd(String ssrcsd) {
        this.ssrcsd = ssrcsd;
    }

    @Column(name = "BSDSRYJD")
    public String getBsdsryjd() {
        return bsdsryjd;
    }

    public void setBsdsryjd(String bsdsryjd) {
        this.bsdsryjd = bsdsryjd;
    }

    @Column(name = "YGSCD")
    public String getYgscd() {
        return ygscd;
    }

    public void setYgscd(String ygscd) {
        this.ygscd = ygscd;
    }

    @Column(name = "BGBCD")
    public String getBgbcd() {
        return bgbcd;
    }

    public void setBgbcd(String bgbcd) {
        this.bgbcd = bgbcd;
    }

    @Column(name = "DSRYJD")
    public String getDsryjd() {
        return dsryjd;
    }

    public void setDsryjd(String dsryjd) {
        this.dsryjd = dsryjd;
    }

    @Column(name = "FSSCD")
    public String getFsscd() {
        return fsscd;
    }

    public void setFsscd(String fsscd) {
        this.fsscd = fsscd;
    }

    @Column(name = "FSBCD")
    public String getFsbcd() {
        return fsbcd;
    }

    public void setFsbcd(String fsbcd) {
        this.fsbcd = fsbcd;
    }

    @Column(name = "XZSSZYD")
    public String getXzsszyd() {
        return xzsszyd;
    }

    public void setXzsszyd(String xzsszyd) {
        this.xzsszyd = xzsszyd;
    }
}
