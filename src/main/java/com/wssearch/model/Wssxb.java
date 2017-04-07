package com.wssearch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by cristph on 2017/4/7.
 */

@Entity
@Table(name = "WSXXB")
public class Wssxb {

    private Integer wsid;//文书id
    private String wsah;//文书案号
    private String wsmc;//文书名称
    private String wslx;//文书类型
    private String xmlName;//xml文件名
    private String xmlPath;//xml路径
    private String docName;//doc文件名
    private String docPath;//doc路径
    private String ajlb;//案件类别：民事等
    private Integer aycj;//案由层级 1234等
    private String yjaymc;//一级案由名称
    private String yjaydm;//一级案由代码
    private String ejaymc;//二级案由名称
    private String ejaydm;//二级案由代码
    private String sjaymc;//三级案由名称
    private String sjaydm;//三级案由代码
    private String sijaymc;//四级案由名称
    private String sijaydm;//四级案由代码
    private String fycj;//法院层级
    private String gymc;//高院名称
    private String zymc;//中院名称
    private String jcymc;//基层院名称
    private String cprq;//裁判日期
    private String cpnf;//裁判年份
    private String spcx;//审判程序
    private String spry;//审判人员
    private String yghzgsr;//原告或者公诉人
    private String bg;//被告
    private String ygsfct;//原告是否出庭
    private String bgsfct;//被告是否出庭
    private String lsmc;//律所名称
    private String lsxm;//律师姓名
    private String flyj;//法律依据

    @Id
    @Column(name = "WS_ID", unique = true, nullable = false)
    public Integer getWsid() {
        return wsid;
    }
    public void setWsid(Integer wsid) {
        this.wsid = wsid;
    }
    @Column(name = "WSAH", length = 100)
    public String getWsah() {
        return wsah;
    }
    public void setWsah(String wsah) {
        this.wsah = wsah;
    }
    @Column(name = "WSMC", length = 150)
    public String getWsmc() {
        return wsmc;
    }
    public void setWsmc(String wsmc) {
        this.wsmc = wsmc;
    }
    @Column(name = "WSLX", length = 20)
    public String getWslx() {
        return wslx;
    }
    public void setWslx(String wslx) {
        this.wslx = wslx;
    }
    @Column(name = "WS_XML_NAME", length = 50)
    public String getXmlName() {
        return xmlName;
    }
    public void setXmlName(String xmlName) {
        this.xmlName = xmlName;
    }
    @Column(name = "WS_XML_PATH", length = 255)
    public String getXmlPath() {
        return xmlPath;
    }
    public void setXmlPath(String xmlPath) {
        this.xmlPath = xmlPath;
    }
    @Column(name = "WS_DOC_NAME", length = 50)
    public String getDocName() {
        return docName;
    }
    public void setDocName(String docName) {
        this.docName = docName;
    }
    @Column(name = "WS_DOC_PATH", length = 255)
    public String getDocPath() {
        return docPath;
    }
    public void setDocPath(String docPath) {
        this.docPath = docPath;
    }
    @Column(name = "AJLB", length = 10)
    public String getAjlb() {
        return ajlb;
    }
    public void setAjlb(String ajlb) {
        this.ajlb = ajlb;
    }
    @Column(name = "AYCJ")
    public Integer getAycj() {
        return aycj;
    }
    public void setAycj(Integer aycj) {
        this.aycj = aycj;
    }
    @Column(name = "YJAYMC", length = 50)
    public String getYjaymc() {
        return yjaymc;
    }
    public void setYjaymc(String yjaymc) {
        this.yjaymc = yjaymc;
    }
    @Column(name = "YJAYDM", length = 10)
    public String getYjaydm() {
        return yjaydm;
    }
    public void setYjaydm(String yjaydm) {
        this.yjaydm = yjaydm;
    }
    @Column(name = "EJAYMC", length = 50)
    public String getEjaymc() {
        return ejaymc;
    }
    public void setEjaymc(String ejaymc) {
        this.ejaymc = ejaymc;
    }
    @Column(name = "EJAYDM", length = 10)
    public String getEjaydm() {
        return ejaydm;
    }
    public void setEjaydm(String ejaydm) {
        this.ejaydm = ejaydm;
    }
    @Column(name = "SJAYMC", length = 50)
    public String getSjaymc() {
        return sjaymc;
    }
    public void setSjaymc(String sjaymc) {
        this.sjaymc = sjaymc;
    }
    @Column(name = "SJAYDM", length = 10)
    public String getSjaydm() {
        return sjaydm;
    }
    public void setSjaydm(String sjaydm) {
        this.sjaydm = sjaydm;
    }
    @Column(name = "SiJAYMC", length = 50)
    public String getSijaymc() {
        return sijaymc;
    }
    public void setSijaymc(String sijaymc) {
        this.sijaymc = sijaymc;
    }
    @Column(name = "SiJAYDM", length = 10)
    public String getSijaydm() {
        return sijaydm;
    }
    public void setSijaydm(String sijaydm) {
        this.sijaydm = sijaydm;
    }
    @Column(name = "FYCJ", length = 10)
    public String getFycj() {
        return fycj;
    }
    public void setFycj(String fycj) {
        this.fycj = fycj;
    }
    @Column(name = "GYMC", length = 50)
    public String getGymc() {
        return gymc;
    }
    public void setGymc(String gymc) {
        this.gymc = gymc;
    }
    @Column(name = "ZYMC", length = 50)
    public String getZymc() {
        return zymc;
    }
    public void setZymc(String zymc) {
        this.zymc = zymc;
    }
    @Column(name = "JCYMC", length = 50)
    public String getJcymc() {
        return jcymc;
    }
    public void setJcymc(String jcymc) {
        this.jcymc = jcymc;
    }
    @Column(name = "CPRQ", length = 50)
    public String getCprq() {
        return cprq;
    }
    public void setCprq(String cprq) {
        this.cprq = cprq;
    }
    @Column(name = "CPNF", length = 20)
    public String getCpnf() {
        return cpnf;
    }
    public void setCpnf(String cpnf) {
        this.cpnf = cpnf;
    }
    @Column(name = "SPCX", length = 20)
    public String getSpcx() {
        return spcx;
    }
    public void setSpcx(String spcx) {
        this.spcx = spcx;
    }
    @Column(name = "SPRY", length =100)
    public String getSpry() {
        return spry;
    }
    public void setSpry(String spry) {
        this.spry = spry;
    }
    @Column(name = "YGHZGSR" )
    public String getYghzgsr() {
        return yghzgsr;
    }
    public void setYghzgsr(String yghzgsr) {
        this.yghzgsr = yghzgsr;
    }
    @Column(name = "BG" )
    public String getBg() {
        return bg;
    }
    public void setBg(String bg) {
        this.bg = bg;
    }
    @Column(name = "YGSFCT", length =10)
    public String getYgsfct() {
        return ygsfct;
    }
    public void setYgsfct(String ygsfct) {
        this.ygsfct = ygsfct;
    }
    @Column(name = "BGSFCT", length =10)
    public String getBgsfct() {
        return bgsfct;
    }
    public void setBgsfct(String bgsfct) {
        this.bgsfct = bgsfct;
    }
    @Column(name = "LSMC", length =100)
    public String getLsmc() {
        return lsmc;
    }
    public void setLsmc(String lsmc) {
        this.lsmc = lsmc;
    }
    @Column(name = "LSXM", length =50)
    public String getLsxm() {
        return lsxm;
    }
    public void setLsxm(String lsxm) {
        this.lsxm = lsxm;
    }
    @Column(name = "FLYJ" )
    public String getFlyj() {
        return flyj;
    }
    public void setFlyj(String flyj) {
        this.flyj = flyj;
    }

}
