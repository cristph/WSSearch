package com.wssearch.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by cristph on 2017/3/25.
 */

@Entity
@Table(name = "WS_CPFXGC_FLFT")
@IdClass(WsCpfxgcFlftId.class)
public class WsCpfxgcFlft implements Serializable {

    private Integer ajxh;//案件序号
    private Integer ftbh;//法条编号
    private String ftmc;//名称
    private String tk;//条款

    @Id
    @Column(name = "AJXH", nullable = false)
    public Integer getAjxh() {
        return this.ajxh;
    }

    public void setAjxh(Integer ajxh) {
        this.ajxh = ajxh;
    }
    @Id
    @Column(name = "FTBH", nullable = false)
    public Integer getFtbh() {
        return ftbh;
    }

    public void setFtbh(Integer ftbh) {
        this.ftbh = ftbh;
    }
    @Column(name = "FTMC", length = 200)
    public String getFtmc() {
        return ftmc;
    }

    public void setFtmc(String ftmc) {
        this.ftmc = ftmc;
    }
    @Column(name = "TK", length = 255)
    public String getTk() {
        return tk;
    }

    public void setTk(String tk) {
        this.tk = tk;
    }
}
