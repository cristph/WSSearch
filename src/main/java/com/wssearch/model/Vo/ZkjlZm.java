package com.wssearch.model.Vo;

/**
 * Created by cristph on 2017/3/29.
 */
public class ZkjlZm {
    private Integer ajxh;//案件序号
    private Integer zkjlbh;// 指控编号
    private String xgr;//相关人

    private Integer zmbh;// 罪名编号
    private String zm;
    private String zmdm;
    private String wzzm;

    public Integer getAjxh() {
        return ajxh;
    }

    public void setAjxh(Integer ajxh) {
        this.ajxh = ajxh;
    }

    public Integer getZkjlbh() {
        return zkjlbh;
    }

    public void setZkjlbh(Integer zkjlbh) {
        this.zkjlbh = zkjlbh;
    }

    public String getXgr() {
        return xgr;
    }

    public void setXgr(String xgr) {
        this.xgr = xgr;
    }

    public Integer getZmbh() {
        return zmbh;
    }

    public void setZmbh(Integer zmbh) {
        this.zmbh = zmbh;
    }

    public String getZm() {
        return zm;
    }

    public void setZm(String zm) {
        this.zm = zm;
    }

    public String getZmdm() {
        return zmdm;
    }

    public void setZmdm(String zmdm) {
        this.zmdm = zmdm;
    }

    public String getWzzm() {
        return wzzm;
    }

    public void setWzzm(String wzzm) {
        this.wzzm = wzzm;
    }

    @Override
    public String toString() {
        return "ZkjlZm{" +
                "ajxh=" + ajxh +
                ", zkjlbh=" + zkjlbh +
                ", xgr='" + xgr + '\'' +
                ", zmbh=" + zmbh +
                ", zm='" + zm + '\'' +
                ", zmdm='" + zmdm + '\'' +
                ", wzzm='" + wzzm + '\'' +
                '}';
    }
}
