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
@Table(name = "WS_AJJBQKXSES")
public class WSAjjbqkxses implements Serializable {
    private Integer ajxh;
    private String xsbssld;
    private String xsqssld;
    private String qscpyzypjjg;
    private String qscmssyzj;
    private String ssssbhyj;
    private String jcjgyj;

    @Id
    @Column(name = "AJXH", nullable = false)
    public Integer getAjxh() {
        return ajxh;
    }

    public void setAjxh(Integer ajxh) {
        this.ajxh = ajxh;
    }

    @Column(name = "XSBSSLD")
    public String getXsbssld() {
        return xsbssld;
    }

    public void setXsbssld(String xsbssld) {
        this.xsbssld = xsbssld;
    }
    @Column(name = "XSQSSLD")
    public String getXsqssld() {
        return xsqssld;
    }

    public void setXsqssld(String xsqssld) {
        this.xsqssld = xsqssld;
    }

    @Column(name = "QSCPYZYPJJG")
    public String getQscpyzypjjg() {
        return qscpyzypjjg;
    }

    public void setQscpyzypjjg(String qscpyzypjjg) {
        this.qscpyzypjjg = qscpyzypjjg;
    }
    @Column(name = "QSCMSSYZJ")
    public String getQscmssyzj() {
        return qscmssyzj;
    }

    public void setQscmssyzj(String qscmssyzj) {
        this.qscmssyzj = qscmssyzj;
    }

    @Column(name = "SSSSBHYJ")
    public String getSsssbhyj() {
        return ssssbhyj;
    }

    public void setSsssbhyj(String ssssbhyj) {
        this.ssssbhyj = ssssbhyj;
    }

    @Column(name = "JCJGYJ")
    public String getJcjgyj() {
        return jcjgyj;
    }

    public void setJcjgyj(String jcjgyj) {
        this.jcjgyj = jcjgyj;
    }
}
