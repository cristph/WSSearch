package com.wssearch.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by cristph on 2017/3/25.
 */

@Table(name="WS_DSRB")
@Entity
@IdClass(WsDsrId.class)
public class WsDsr implements Serializable{

    private Integer ajxh;//案件序号
    private Integer dsrbh;//当事人编号
    private String ssdw;//诉讼地位
    private String ysssdw;//原审诉讼地位
    private String dsrlb;//当事人类别
    private String xm;//姓名
    private String xb;//性别
    private String mz;//民族
    private String gj; //国籍
    private String whcd;//文化程度
    private String zjlx;//证件类型
    private String zjhm;//证件号码
    private String zw; //职务
    private String dz;//地址
    private String sfzh;//是否再婚
    private String tshy;//特殊行业
    private String jgdbr;//机关代表人
    private String dwxz;//单位性质
    private String xzflgxzt;//行政法律关系主体
    private String xzglfw;//行政管理范围
    private String bglx;//被告类型
    private String zzjgdm;//组织机构代码
    private String sfbhr;//是否被害人
    private String zrrsf;//自然人身份
    private String  hjszd;//户籍所在地
    private String xjycs;//现羁押场所
    private String xszrnl;//刑事责任能力
    private String sfct;//是否出庭
    private String xw;//学位
    private String zzmm;//政治面貌

    @Id
    @Column(name = "AJXH", nullable = false)
    public Integer getAjxh() {
        return this.ajxh;
    }

    public void setAjxh(Integer ajxh) {
        this.ajxh = ajxh;
    }

    @Id
    @Column(name = "DSRBH", nullable = false)
    public Integer getDsrbh() {
        return this.dsrbh;
    }

    public void setDsrbh(Integer dsrbh) {
        this.dsrbh = dsrbh;
    }
    @Column(name = "SSDW", length = 10)
    public String getSsdw() {
        return ssdw;
    }

    public void setSsdw(String ssdw) {
        this.ssdw = ssdw;
    }
    @Column(name = "YSSSDW", length = 10)
    public String getYsssdw() {
        return ysssdw;
    }

    public void setYsssdw(String ysssdw) {
        this.ysssdw = ysssdw;
    }
    @Column(name = "DSRLB", length = 10)
    public String getDsrlb() {
        return dsrlb;
    }

    public void setDsrlb(String dsrlb) {
        this.dsrlb = dsrlb;
    }
    @Column(name = "XM", length = 50)
    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }
    @Column(name = "XB", length = 10)
    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb;
    }
    @Column(name = "MZ", length = 10)
    public String getMz() {
        return mz;
    }

    public void setMz(String mz) {
        this.mz = mz;
    }
    @Column(name = "GJ", length = 50)
    public String getGj() {
        return gj;
    }

    public void setGj(String gj) {
        this.gj = gj;
    }
    @Column(name = "WHCD", length = 10)
    public String getWhcd() {
        return whcd;
    }

    public void setWhcd(String whcd) {
        this.whcd = whcd;
    }
    @Column(name = "ZJLX", length = 10)
    public String getZjlx() {
        return zjlx;
    }

    public void setZjlx(String zjlx) {
        this.zjlx = zjlx;
    }
    @Column(name = "ZJHM", length = 50)
    public String getZjhm() {
        return zjhm;
    }

    public void setZjhm(String zjhm) {
        this.zjhm = zjhm;
    }
    @Column(name = "ZW", length = 10)
    public String getZw() {
        return zw;
    }

    public void setZw(String zw) {
        this.zw = zw;
    }
    @Column(name = "DZ", length = 200)
    public String getDz() {
        return dz;
    }

    public void setDz(String dz) {
        this.dz = dz;
    }
    @Column(name = "SFZH", length = 2)
    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }
    @Column(name = "TSHY", length = 20)
    public String getTshy() {
        return tshy;
    }

    public void setTshy(String tshy) {
        this.tshy = tshy;
    }
    @Column(name = "JGDBR", length = 20)
    public String getJgdbr() {
        return jgdbr;
    }

    public void setJgdbr(String jgdbr) {
        this.jgdbr = jgdbr;
    }
    @Column(name = "DWXZ", length = 20)
    public String getDwxz() {
        return dwxz;
    }

    public void setDwxz(String dwxz) {
        this.dwxz = dwxz;
    }
    @Column(name = "XZFLGXZT", length = 20)
    public String getXzflgxzt() {
        return xzflgxzt;
    }

    public void setXzflgxzt(String xzflgxzt) {
        this.xzflgxzt = xzflgxzt;
    }
    @Column(name = "XZGLFW", length = 20)
    public String getXzglfw() {
        return xzglfw;
    }

    public void setXzglfw(String xzglfw) {
        this.xzglfw = xzglfw;
    }
    @Column(name = "BGLX", length = 20)
    public String getBglx() {
        return bglx;
    }

    public void setBglx(String bglx) {
        this.bglx = bglx;
    }
    @Column(name = "ZZJGDM", length = 20)
    public String getZzjgdm() {
        return zzjgdm;
    }

    public void setZzjgdm(String zzjgdm) {
        this.zzjgdm = zzjgdm;
    }
    @Column(name = "SFBHR", length = 2)
    public String getSfbhr() {
        return sfbhr;
    }

    public void setSfbhr(String sfbhr) {
        this.sfbhr = sfbhr;
    }
    @Column(name = "ZRRSF", length = 10)
    public String getZrrsf() {
        return zrrsf;
    }

    public void setZrrsf(String zrrsf) {
        this.zrrsf = zrrsf;
    }
    @Column(name = "HJSZD", length = 200)
    public String getHjszd() {
        return hjszd;
    }

    public void setHjszd(String hjszd) {
        this.hjszd = hjszd;
    }
    @Column(name = "XJYCS", length = 100)
    public String getXjycs() {
        return xjycs;
    }

    public void setXjycs(String xjycs) {
        this.xjycs = xjycs;
    }
    @Column(name = "XSZRNL", length = 20)
    public String getXszrnl() {
        return xszrnl;
    }

    public void setXszrnl(String xszrnl) {
        this.xszrnl = xszrnl;
    }
    @Column(name = "SFCT", length = 10)
    public String getSfct() {
        return sfct;
    }

    public void setSfct(String sfct) {
        this.sfct = sfct;
    }
    @Column(name = "XW", length = 20)
    public String getXw() {
        return xw;
    }

    public void setXw(String xw) {
        this.xw = xw;
    }
    @Column(name = "ZZMM", length = 50)
    public String getZzmm() {
        return zzmm;
    }

    public void setZzmm(String zzmm) {
        this.zzmm = zzmm;
    }
}
