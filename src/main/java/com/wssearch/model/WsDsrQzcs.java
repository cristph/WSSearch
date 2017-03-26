package com.wssearch.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by cristph on 2017/3/25.
 */
@Entity
@Table(name="WS_DSR_QZCS")
@IdClass(WsDsrQzcsId.class)
public class WsDsrQzcs implements Serializable{

    private Integer ajxh;//案件序号
    private Integer qzcsbh;//强制措施编号
    private Integer dsrbh;//当事人编号
    private String zl;//强制措施种类
    private String zxsj;//强制措施执行时间
    private String dw;//强制措施单位
    private String yy;//强制措施原因
    private String sfdb;//是否逮捕
    private String dbrq;//逮捕日期

    @Id
    @Column(name = "AJXH", nullable = false)
    public Integer getAjxh() {
        return this.ajxh;
    }

    public void setAjxh(Integer ajxh) {
        this.ajxh = ajxh;
    }

    @Id
    @Column(name = "QZCSBH", nullable = false)
    public Integer getQzcsbh() {
        return qzcsbh;
    }


    public void setQzcsbh(Integer qzcsbh) {
        this.qzcsbh = qzcsbh;
    }

    @Column(name = "DSRBH" )
    public Integer getDsrbh() {
        return dsrbh;
    }


    public void setDsrbh(Integer dsrbh) {
        this.dsrbh = dsrbh;
    }

    @Column(name = "ZL" ,length=200)
    public String getZl() {
        return zl;
    }


    public void setZl(String zl) {
        this.zl = zl;
    }

    @Column(name = "ZXSJ" ,length=50)
    public String getZxsj() {
        return zxsj;
    }


    public void setZxsj(String zxsj) {
        this.zxsj = zxsj;
    }

    @Column(name = "DW" ,length=100)
    public String getDw() {
        return dw;
    }


    public void setDw(String dw) {
        this.dw = dw;
    }

    @Column(name = "YY" ,length=200)
    public String getYy() {
        return yy;
    }


    public void setYy(String yy) {
        this.yy = yy;
    }

    @Column(name = "SFDB" ,length=10)
    public String getSfdb() {
        return sfdb;
    }


    public void setSfdb(String sfdb) {
        this.sfdb = sfdb;
    }

    @Column(name = "DBRQ" ,length=50)
    public String getDbrq() {
        return dbrq;
    }


    public void setDbrq(String dbrq) {
        this.dbrq = dbrq;
    }
}
