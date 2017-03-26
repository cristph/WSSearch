package com.wssearch.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by cristph on 2017/3/25.
 */
@Entity
@Table(name = "WS_XSPJJG_FJX")
@IdClass(WsXspjjgfjxId.class)
public class WsXspjjgfjx implements Serializable {

    private Integer ajxh;//案件序号
    private Integer fjxbh;// 附加刑编号
    private Integer fzbh;//分组编号
    private Integer pfbh;// 判罚编号
    private String lb;//类别
    private String se;//数额
    private String bz;//备注
    private String qx;//期限

    @Id
    @Column(name = "AJXH", nullable = false)
    public Integer getAjxh() {
        return this.ajxh;
    }

    public void setAjxh(Integer ajxh) {
        this.ajxh = ajxh;
    }

    @Id
    @Column(name = "FJXBH", nullable = false)
    public Integer getFjxbh() {
        return fjxbh;
    }

    public void setFjxbh(Integer fjxbh) {
        this.fjxbh = fjxbh;
    }
    @Column(name = "FZBH")
    public Integer getFzbh() {
        return fzbh;
    }

    public void setFzbh(Integer fzbh) {
        this.fzbh = fzbh;
    }
    @Column(name = "PFBH")
    public Integer getPfbh() {
        return pfbh;
    }

    public void setPfbh(Integer pfbh) {
        this.pfbh = pfbh;
    }
    @Column(name = "LB", length = 	10)
    public String getLb() {
        return lb;
    }

    public void setLb(String lb) {
        this.lb = lb;
    }
    @Column(name = "SE", length = 30)
    public String getSe() {
        return se;
    }

    public void setSe(String se) {
        this.se = se;
    }
    @Column(name = "BZ", length = 10)
    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }
    @Column(name = "QX", length = 20)
    public String getQx() {
        return qx;
    }

    public void setQx(String qx) {
        this.qx = qx;
    }
}
