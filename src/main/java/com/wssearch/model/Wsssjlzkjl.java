package com.wssearch.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by cristph on 2017/3/25.
 */
@Entity
@Table(name = "WS_SSJL_ZKJL")
@IdClass(WsssjlzkjlId.class)
public class Wsssjlzkjl implements Serializable {
    private Integer ajxh;//案件序号
    private Integer zkjlbh;// 指控编号
    private String xgr;//相关人

    @Id
    @Column(name = "AJXH", nullable = false)
    public Integer getAjxh() {
        return this.ajxh;
    }

    public void setAjxh(Integer ajxh) {
        this.ajxh = ajxh;
    }
    @Id
    @Column(name = "ZKJLBH", nullable = false)
    public Integer getZkjlbh() {
        return zkjlbh;
    }

    public void setZkjlbh(Integer zkjlbh) {
        this.zkjlbh = zkjlbh;
    }

    @Column(name = "XGR", length =255)
    public String getXgr() {
        return xgr;
    }

    public void setXgr(String xgr) {
        this.xgr = xgr;
    }
}
