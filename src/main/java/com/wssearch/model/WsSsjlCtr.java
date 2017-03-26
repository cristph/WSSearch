package com.wssearch.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by cristph on 2017/3/25.
 */

@Entity
@Table(name = "WS_SSJL_CTR")
@IdClass(WsSsjlCtrId.class)
public class WsSsjlCtr implements Serializable {
    private Integer ajxh;//案件序号
    private Integer ctrbh;//出庭人编号
    private String ctlx;//出庭类型
    private String xm;//姓名
    private String sssf;//诉讼身份

    @Id
    @Column(name = "AJXH", nullable = false)
    public Integer getAjxh() {
        return this.ajxh;
    }

    public void setAjxh(Integer ajxh) {
        this.ajxh = ajxh;
    }
    @Id
    @Column(name = "CTRBH", nullable = false)
    public Integer getCtrbh() {
        return ctrbh;
    }

    public void setCtrbh(Integer ctrbh) {
        this.ctrbh = ctrbh;
    }
    @Column(name = "CTLX", length = 10)
    public String getCtlx() {
        return ctlx;
    }

    public void setCtlx(String ctlx) {
        this.ctlx = ctlx;
    }
    @Column(name = "XM", length = 100)
    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }
    @Column(name = "SSSF", length = 50)
    public String getSssf() {
        return sssf;
    }

    public void setSssf(String sssf) {
        this.sssf = sssf;
    }
}
