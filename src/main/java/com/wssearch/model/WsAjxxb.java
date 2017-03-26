package com.wssearch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by cristph on 2017/3/25.
 */
@Table(name="WS_AJJBXXB")
@Entity
public class WsAjxxb implements Serializable{

    @Id
    private Integer ajxh;//案件序号
    private String ah;//案号
    private String ajxz;//案件性质
    private String spcx;//审判程序
    private String wsmc;//文书名称
    private String wszl;//文书种类
    private String wszzdw;//文书制作单位
    private String jbfy;//经办法院
    private String fyjb;//法院级别
    private String xzqhsh;//行政区划 省
    private String xzqhs;//行政区划 市
    private String land;//立案年度
    private String tcgxqyy;//是否提出管辖权异议
    private String jafs;//结案方式
    private String pjsj;//判决时间
    private String jand;//结案年度
    private String jayf;//结案月份
    private String kssz;//可上诉至
    private String ssqx;//上诉期限
    private String sstjcl;//上诉提交材料
    private String sffhcs;//是否发回重审
    private String fhccyy;//发回重审原因
    private String jazbd;//结案总标的

    @Id
    @Column(name = "AJXH", unique = true, nullable = false)
    public Integer getAjxh() {
        return this.ajxh;
    }

    public void setAjxh(Integer ajxh) {
        this.ajxh = ajxh;
    }

    @Column(name = "AJXZ", length = 10)
    public String getAjxz() {
        return this.ajxz;
    }

    public void setAjxz(String ajxz) {
        this.ajxz = ajxz;
    }

    @Column(name = "SPCX", length = 10)
    public String getSpcx() {
        return this.spcx;
    }

    public void setSpcx(String spcx) {
        this.spcx = spcx;
    }
    @Column(name = "AH", length = 40)
    public String getAh() {
        return ah;
    }

    public void setAh(String ah) {
        this.ah = ah;
    }
    @Column(name = "WSMC", length = 50)
    public String getWsmc() {
        return wsmc;
    }

    public void setWsmc(String wsmc) {
        this.wsmc = wsmc;
    }
    @Column(name = "WSZL", length = 30)
    public String getWszl() {
        return wszl;
    }

    public void setWszl(String wszl) {
        this.wszl = wszl;
    }
    @Column(name = "WSZZDW", length = 30)
    public String getWszzdw() {
        return wszzdw;
    }

    public void setWszzdw(String wszzdw) {
        this.wszzdw = wszzdw;
    }
    @Column(name = "JBFY", length = 30)
    public String getJbfy() {
        return jbfy;
    }

    public void setJbfy(String jbfy) {
        this.jbfy = jbfy;
    }
    @Column(name = "FYJB", length = 10)
    public String getFyjb() {
        return fyjb;
    }

    public void setFyjb(String fyjb) {
        this.fyjb = fyjb;
    }
    @Column(name = "XZQHSH", length = 10)
    public String getXzqhsh() {
        return xzqhsh;
    }

    public void setXzqhsh(String xzqhsh) {
        this.xzqhsh = xzqhsh;
    }
    @Column(name = "XZQHS", length = 20)
    public String getXzqhs() {
        return xzqhs;
    }

    public void setXzqhs(String xzqhs) {
        this.xzqhs = xzqhs;
    }
    @Column(name = "LAND", length = 10)
    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }
    @Column(name = "TCGXQYY", length = 10)
    public String getTcgxqyy() {
        return tcgxqyy;
    }

    public void setTcgxqyy(String tcgxqyy) {
        this.tcgxqyy = tcgxqyy;
    }
    @Column(name = "JAFS", length = 30)
    public String getJafs() {
        return jafs;
    }

    public void setJafs(String jafs) {
        this.jafs = jafs;
    }
    @Column(name = "PJSJ", length = 50)
    public String getPjsj() {
        return pjsj;
    }

    public void setPjsj(String pjsj) {
        this.pjsj = pjsj;
    }
    @Column(name = "JAND", length = 10)
    public String getJand() {
        return jand;
    }

    public void setJand(String jand) {
        this.jand = jand;
    }
    @Column(name = "JAYF", length = 10)
    public String getJayf() {
        return jayf;
    }

    public void setJayf(String jayf) {
        this.jayf = jayf;
    }
    @Column(name = "KSSZ", length = 20)
    public String getKssz() {
        return kssz;
    }

    public void setKssz(String kssz) {
        this.kssz = kssz;
    }
    @Column(name = "SSQX", length = 10)
    public String getSsqx() {
        return ssqx;
    }

    public void setSsqx(String ssqx) {
        this.ssqx = ssqx;
    }
    @Column(name = "SSTJCL", length = 100)
    public String getSstjcl() {
        return sstjcl;
    }

    public void setSstjcl(String sstjcl) {
        this.sstjcl = sstjcl;
    }
    @Column(name = "SFFHCS", length = 2)
    public String getSffhcs() {
        return sffhcs;
    }

    public void setSffhcs(String sffhcs) {
        this.sffhcs = sffhcs;
    }
    @Column(name = "FHCSYY", length = 20)
    public String getFhccyy() {
        return fhccyy;
    }

    public void setFhccyy(String fhccyy) {
        this.fhccyy = fhccyy;
    }
    @Column(name = "JAZBD", length = 50)
    public String getJazbd() {
        return jazbd;
    }

    public void setJazbd(String jazbd) {
        this.jazbd = jazbd;
    }

    @Override
    public String toString() {
        return "WsAjxxb{" +
                "ajxh=" + ajxh +
                ", ah='" + ah + '\'' +
                ", ajxz='" + ajxz + '\'' +
                ", spcx='" + spcx + '\'' +
                ", wsmc='" + wsmc + '\'' +
                ", wszl='" + wszl + '\'' +
                ", wszzdw='" + wszzdw + '\'' +
                ", jbfy='" + jbfy + '\'' +
                ", fyjb='" + fyjb + '\'' +
                ", xzqhsh='" + xzqhsh + '\'' +
                ", xzqhs='" + xzqhs + '\'' +
                ", land='" + land + '\'' +
                ", tcgxqyy='" + tcgxqyy + '\'' +
                ", jafs='" + jafs + '\'' +
                ", pjsj='" + pjsj + '\'' +
                ", jand='" + jand + '\'' +
                ", jayf='" + jayf + '\'' +
                ", kssz='" + kssz + '\'' +
                ", ssqx='" + ssqx + '\'' +
                ", sstjcl='" + sstjcl + '\'' +
                ", sffhcs='" + sffhcs + '\'' +
                ", fhccyy='" + fhccyy + '\'' +
                ", jazbd='" + jazbd + '\'' +
                '}';
    }
}
