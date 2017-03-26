package com.wssearch.model;

import javax.persistence.*;

/**
 * Created by cristph on 2017/3/25.
 */

@Entity
@Table(name = "WS_CPFXGC_LXQJ")
@IdClass(WsCpfxgcLxqjId.class)
public class WsCpfxgcLxqj implements java.io.Serializable {

    private Integer ajxh;//案件序号
    private Integer lxqjbh;//量刑情节编号
    private String lxqjzl;//量刑情节种类
    private String xgr;//相关人
    private String qj;//情节
    private String lxzl;//量刑种类

    @Id
    @Column(name = "AJXH", nullable = false)
    public Integer getAjxh() {
        return this.ajxh;
    }

    public void setAjxh(Integer ajxh) {
        this.ajxh = ajxh;
    }

    @Id
    @Column(name = "LXQJBH", nullable = false)
    public Integer getLxqjbh() {
        return lxqjbh;
    }

    public void setLxqjbh(Integer lxqjbh) {
        this.lxqjbh = lxqjbh;
    }
    @Column(name = "LXQJZL", length = 255)
    public String getLxqjzl() {
        return lxqjzl;
    }

    public void setLxqjzl(String lxqjzl) {
        this.lxqjzl = lxqjzl;
    }

    @Column(name = "XGR", length = 255)
    public String getXgr() {
        return xgr;
    }

    public void setXgr(String xgr) {
        this.xgr = xgr;
    }
    @Column(name = "QJ", length = 200)
    public String getQj() {
        return qj;
    }

    public void setQj(String qj) {
        this.qj = qj;
    }
    @Column(name = "LXZL", length = 20)
    public String getLxzl() {
        return lxzl;
    }

    public void setLxzl(String lxzl) {
        this.lxzl = lxzl;
    }
}
