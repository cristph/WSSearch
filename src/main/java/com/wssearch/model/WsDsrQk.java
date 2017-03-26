package com.wssearch.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by cristph on 2017/3/25.
 */

@Table(name="WS_DSR_QK")
@Entity
@IdClass(WsDsrQkId.class)
public class WsDsrQk implements Serializable{

    private Integer ajxh;//案件序号
    private Integer qkbh;//前科编号
    private Integer dsrbh;//当事人编号
    private String qklb;//前科类别
    private String cftime;//处罚时间
    private String cfyy;//处罚原因
    private String cfdw;//处罚单位
    private String cfxs;//处罚形式
    private String cfxq;//处罚刑期
    private String xmsfsj;//刑满释放日期

    @Id
    @Column(name = "AJXH", nullable = false)
    public Integer getAjxh() {
        return this.ajxh;
    }

    public void setAjxh(Integer ajxh) {
        this.ajxh = ajxh;
    }

    @Id
    @Column(name = "QKBH", nullable = false)
    public Integer getQkbh() {
        return qkbh;
    }

    public void setQkbh(Integer qkbh) {
        this.qkbh = qkbh;
    }
    @Column(name = "DSRBH")
    public Integer getDsrbh() {
        return this.dsrbh;
    }

    public void setDsrbh(Integer dsrbh) {
        this.dsrbh = dsrbh;
    }
    @Column(name = "QKLB",length = 50)
    public String getQklb() {
        return qklb;
    }
    public void setQklb(String qklb) {
        this.qklb = qklb;
    }

    @Column(name = "CFTIME",length = 50)
    public String getCftime() {
        return cftime;
    }

    public void setCftime(String cftime) {
        this.cftime = cftime;
    }

    @Column(name = "CFYY",length = 255)
    public String getCfyy() {
        return cfyy;
    }



    public void setCfyy(String cfyy) {
        this.cfyy = cfyy;
    }


    @Column(name = "SFDW",length = 200)
    public String getCfdw() {
        return cfdw;
    }



    public void setCfdw(String cfdw) {
        this.cfdw = cfdw;
    }


    @Column(name = "CFXS",length = 100)
    public String getCfxs() {
        return cfxs;
    }



    public void setCfxs(String cfxs) {
        this.cfxs = cfxs;
    }


    @Column(name = "CFRQ",length = 200)
    public String getCfxq() {
        return cfxq;
    }

    public void setCfxq(String cfxq) {
        this.cfxq = cfxq;
    }


    @Column(name = "XMSFSJ",length = 200)
    public String getXmsfsj() {
        return xmsfsj;
    }

    public void setXmsfsj(String xmsfsj) {
        this.xmsfsj = xmsfsj;
    }
}
