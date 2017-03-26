package com.wssearch.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by cristph on 2017/3/25.
 */
@Entity
@Table(name = "WS_XSPJJG_PF")
@IdClass(WsXspjjgpfId.class)
public class WsXspjjgpf implements Serializable {

    private Integer ajxh;//案件序号
    private Integer fzbh;//分组编号
    private Integer pfbh;//判罚编号
    private String pflx;//判罚类型
    private String zm;//罪名
    private String zmdm;//罪名代码
    private String wzzm;//完整罪名
    private String zxlb;//主刑类别
    private String zxqx;//主刑期限
    private String hxlb;//缓刑类别
    private String hbqx;//缓刑期限
    private String pjjglx;//判决结果类型
    private String yzszbf;//原罪数罪并罚

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
    @Id
    @Column(name = "PFBH", nullable = false)
    public Integer getPfbh() {
        return pfbh;
    }

    public void setPfbh(Integer pfbh) {
        this.pfbh = pfbh;
    }
    @Column(name = "PFLX", length = 20)
    public String getPflx() {
        return pflx;
    }

    public void setPflx(String pflx) {
        this.pflx = pflx;
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
    @Column(name = "ZXLB", length = 20)
    public String getZxlb() {
        return zxlb;
    }

    public void setZxlb(String zxlb) {
        this.zxlb = zxlb;
    }
    @Column(name = "ZXXQ", length = 50)
    public String getZxqx() {
        return zxqx;
    }

    public void setZxqx(String zxqx) {
        this.zxqx = zxqx;
    }

    @Column(name = "HXLB", length = 20)
    public String getHxlb() {
        return hxlb;
    }

    public void setHxlb(String hxlb) {
        this.hxlb = hxlb;
    }
    @Column(name = "HXXQ", length = 50)
    public String getHbqx() {
        return hbqx;
    }

    public void setHbqx(String hbqx) {
        this.hbqx = hbqx;
    }
    @Column(name = "PJJGLX", length = 30)
    public String getPjjglx() {
        return pjjglx;
    }

    public void setPjjglx(String pjjglx) {
        this.pjjglx = pjjglx;
    }
    @Column(name = "YZSZBF", length = 2)
    public String getYzszbf() {
        return yzszbf;
    }

    public void setYzszbf(String yzszbf) {
        this.yzszbf = yzszbf;
    }

}
