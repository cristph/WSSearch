package com.wssearch.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by cristph on 2017/3/25.
 */

@Entity
@Table(name = "WS_XSPJJGFZ")
@IdClass(WsXspjjgfzId.class)
public class WsXspjjgfz implements Serializable {
    private Integer ajxh;//案件序号
    private Integer fzbh;//分组编号
    private String sscyr;// 诉讼参与人
    private String pjjzm;// 判决主罪名
    private String zmdm;//罪名代码
    private String wzzm;//完整罪名
    private String xqksrq;//刑期开始日期
    private String xqjsrq;//刑期结束日期
    private String xqzdbf;//刑期折抵办法
    private String mzhwfsf;//免罪或无罪释放
    private String szbf;//数罪并罚
    private String hblx;//合并量刑

    @Id
    @Column(name = "AJXH", nullable = false)
    public Integer getAjxh() {
        return this.ajxh;
    }

    public void setAjxh(Integer ajxh) {
        this.ajxh = ajxh;
    }

    @Id
    @Column(name = "FZBH", nullable = false)
    public Integer getFzbh() {
        return fzbh;
    }

    public void setFzbh(Integer fzbh) {
        this.fzbh = fzbh;
    }
    @Column(name = "SSCYR", length = 50)
    public String getSscyr() {
        return sscyr;
    }

    public void setSscyr(String sscyr) {
        this.sscyr = sscyr;
    }
    @Column(name = "PJZZM", length = 50)
    public String getPjjzm() {
        return pjjzm;
    }

    public void setPjjzm(String pjjzm) {
        this.pjjzm = pjjzm;
    }
    @Column(name = "ZMDM", length = 50)
    public String getZmdm() {
        return zmdm;
    }

    public void setZmdm(String zmdm) {
        this.zmdm = zmdm;
    }
    @Column(name = "WZZM", length = 50)
    public String getWzzm() {
        return wzzm;
    }

    public void setWzzm(String wzzm) {
        this.wzzm = wzzm;
    }
    @Column(name = "XQKSRQ", length = 20)
    public String getXqksrq() {
        return xqksrq;
    }

    public void setXqksrq(String xqksrq) {
        this.xqksrq = xqksrq;
    }
    @Column(name = "XQJSRQ", length = 20)
    public String getXqjsrq() {
        return xqjsrq;
    }

    public void setXqjsrq(String xqjsrq) {
        this.xqjsrq = xqjsrq;
    }
    @Column(name = "XQZDBF", length = 20)
    public String getXqzdbf() {
        return xqzdbf;
    }

    public void setXqzdbf(String xqzdbf) {
        this.xqzdbf = xqzdbf;
    }
    @Column(name = "MZHWZSF", length = 2)
    public String getMzhwfsf() {
        return mzhwfsf;
    }

    public void setMzhwfsf(String mzhwfsf) {
        this.mzhwfsf = mzhwfsf;
    }
    @Column(name = "SZBF", length = 2)
    public String getSzbf() {
        return szbf;
    }

    public void setSzbf(String szbf) {
        this.szbf = szbf;
    }
    @Column(name = "HBLX", length = 2)
    public String getHblx() {
        return hblx;
    }

    public void setHblx(String hblx) {
        this.hblx = hblx;
    }
}
