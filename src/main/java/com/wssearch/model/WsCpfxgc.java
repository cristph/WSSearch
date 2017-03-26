package com.wssearch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by cristph on 2017/3/25.
 */

@Entity
@Table(name = "WS_CPFXGC")
public class WsCpfxgc implements Serializable {
    private Integer ajxh;//案件序号
    private String Jafslx;//结案方式类型
    private String xzpc;// 行政赔偿，行政案件特有
    private String ysajly;//一审案件来源，一审案件特有
    private String sfjgxzfy;//是否经过行政复议
    private String xzxwwfbj;//行政行为违法补救
    private String ktqsqchss;//开庭前申请撤诉
    private String gtfz;// 共同犯罪
    private String bgrtyrzcx;//被告人同意认罪程序

    @Id
    @Column(name = "AJXH", unique = true, nullable = false)
    public Integer getAjxh() {
        return this.ajxh;
    }

    public void setAjxh(Integer ajxh) {
        this.ajxh = ajxh;
    }
    @Column(name = "JAFSLX",length = 100)
    public String getJafslx() {
        return Jafslx;
    }

    public void setJafslx(String jafslx) {
        Jafslx = jafslx;
    }
    @Column(name = "XZPC",length = 10)
    public String getXzpc() {
        return xzpc;
    }

    public void setXzpc(String xzpc) {
        this.xzpc = xzpc;
    }
    @Column(name = "YSAJLY",length = 100)
    public String getYsajly() {
        return ysajly;
    }

    public void setYsajly(String ysajly) {
        this.ysajly = ysajly;
    }
    @Column(name = "SFJGXZFY",length = 10)
    public String getSfjgxzfy() {
        return sfjgxzfy;
    }

    public void setSfjgxzfy(String sfjgxzfy) {
        this.sfjgxzfy = sfjgxzfy;
    }
    @Column(name = "XZXWWFBJ",length = 10)
    public String getXzxwwfbj() {
        return xzxwwfbj;
    }

    public void setXzxwwfbj(String xzxwwfbj) {
        this.xzxwwfbj = xzxwwfbj;
    }
    @Column(name = "KTQSQCHSS",length = 10)
    public String getKtqsqchss() {
        return ktqsqchss;
    }

    public void setKtqsqchss(String ktqsqchss) {
        this.ktqsqchss = ktqsqchss;
    }
    @Column(name = "GTFZ",length = 10)
    public String getGtfz() {
        return gtfz;
    }

    public void setGtfz(String gtfz) {
        this.gtfz = gtfz;
    }
    @Column(name = "BGRTYRZCX",length = 10)
    public String getBgrtyrzcx() {
        return bgrtyrzcx;
    }
    public void setBgrtyrzcx(String bgrtyrzcx) {
        this.bgrtyrzcx = bgrtyrzcx;
    }
}
