package com.wssearch.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by cristph on 2017/3/25.
 */

@Entity
@Table(name = "WS_SSJL_ZKJL_ZM")
@IdClass(WsSsjlZkzmId.class)
public class WsSsjlZkzm implements Serializable {
    private Integer ajxh;//案件序号
    private Integer zmbh;// 罪名编号
    private Integer zkjlbh;//指控记录编号
    private String zm;
    private String zmdm;
    private String wzzm;

    @Id
    @Column(name = "AJXH", nullable = false)
    public Integer getAjxh() {
        return this.ajxh;
    }

    public void setAjxh(Integer ajxh) {
        this.ajxh = ajxh;
    }
    @Id
    @Column(name = "ZMBH", nullable = false)
    public Integer getZmbh() {
        return zmbh;
    }

    public void setZmbh(Integer zmbh) {
        this.zmbh = zmbh;
    }
    @Column(name = "ZKJLBH")
    public Integer getZkjlbh() {
        return zkjlbh;
    }

    public void setZkjlbh(Integer zkjlbh) {
        this.zkjlbh = zkjlbh;
    }
    @Column(name = "ZM", length = 100)
    public String getZm() {
        return zm;
    }

    public void setZm(String zm) {
        this.zm = zm;
    }
    @Column(name = "ZMDM", length = 50)
    public String getZmdm() {
        return zmdm;
    }

    public void setZmdm(String zmdm) {
        this.zmdm = zmdm;
    }
    @Column(name = "WZZM", length = 100)
    public String getWzzm() {
        return wzzm;
    }

    public void setWzzm(String wzzm) {
        this.wzzm = wzzm;
    }
}
