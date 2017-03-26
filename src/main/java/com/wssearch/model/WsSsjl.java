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
@Table(name="WS_SSJL")
public class WsSsjl implements Serializable {

    private Integer ajxh;//案件序号
    private String ay;//案由
    private String wzay;//完整案由
    private String ajly;//案件来源
    private String ajsj;//案件涉及
    private String ktsl;//开庭审理
    private String aydm;//案由代码
    private String ktrq;//开庭日期(;)
    private String qsah;//前审案号(;)
    private String qsfy;//前审法院
    private String ktslxx;//开庭审理信息
    private String bgkslyy;//不公开审理原因
    private String larq;//立案日期

    private String ysajsycx;//一审案件适用程序
    private String jyzpt;//简易转普通
    private String ysajly;//一审案件来源
    private String slrq;//受理日期
    private String spzz;//审判组织
    private String drsp;//独任审判
    private String sqcsrq;//申请撤诉日期
    //	private HashMap<String,String> qxrxx;//缺席人信息(单独)
    // 	private HashMap<String,String> ctrxx;//出庭人信息(单独)
    private String qsrq;//起诉日期
    private String bgzyldct;//被告主要领导出庭
    private String xzxwzl;//行政行为种类
    private String xzqqxwzl;//行政侵权行为种类

    private String jysyjycx;//建议适用简易程序
    private String msbfjxsl;//附带民事部分继续审理
    private String ssxz;//诉讼性质
    private String jcy;//检察员
    private String js;//检察员角色
    //	private ArrayList<WsssjlZkjlModel> wsssjlZkjl;//文书诉讼记录指控记录
    private String qszay;//起诉主案由
    private String gsjg;//公诉机关
    private String gsah;//公诉案号
    private String slztqfdmsss;//审理中提起附带民事诉讼
    private String jcyjyyqsl;//检察院建议延期审理
    private String snft;//少年法庭

    private String xzesqsah;//行政二审前审案号
    private String qsland;//前审立案年度
    private String qsfyjc;//前审法院简称
    private String fyjb;//前审法院级别
    private String qsahsxh;//前审案号顺序号
    private String qscpsj;//前审裁判时间
    private String qswszl;//前审文书种类
    private String qsajyl;//前审案件由来
    private String qsjafs;//前审结案方式
    private String qssj;//前审审级

    private String sshksfw;//上诉或抗诉范围
    private byte[] qspj;//前审判决
    private String xsesqsah;//刑事二审前审案号
    private String bzfymc;//标准法院名称
    private String qsgsjg;//原公诉机关

    @Id
    @Column(name = "AJXH", nullable = false)
    public Integer getAjxh() {
        return ajxh;
    }
    public void setAjxh(Integer ajxh) {
        this.ajxh = ajxh;
    }

    @Column(name = "AY", length = 100)
    public String getAy() {
        return ay;
    }
    public void setAy(String ay) {
        this.ay = ay;
    }
    @Column(name = "WZAY", length = 100)
    public String getWzay() {
        return wzay;
    }
    public void setWzay(String wzay) {
        this.wzay = wzay;
    }
    @Column(name = "AJLY", length = 30)
    public String getAjly() {
        return ajly;
    }
    public void setAjly(String ajly) {
        this.ajly = ajly;
    }
    @Column(name = "AJSJ", length = 30)
    public String getAjsj() {
        return ajsj;
    }
    public void setAjsj(String ajsj) {
        this.ajsj = ajsj;
    }
    @Column(name = "KTSL", length = 10)
    public String getKtsl() {
        return ktsl;
    }
    public void setKtsl(String ktsl) {
        this.ktsl = ktsl;
    }
    @Column(name = "AYDM", length = 20)
    public String getAydm() {
        return aydm;
    }
    public void setAydm(String aydm) {
        this.aydm = aydm;
    }
    @Column(name = "KTRQ", length = 100)
    public String getKtrq() {
        return ktrq;
    }
    public void setKtrq(String ktrq) {
        this.ktrq = ktrq;
    }
    @Column(name = "QSAH", length = 255)
    public String getQsah() {
        return qsah;
    }
    public void setQsah(String qsah) {
        this.qsah = qsah;
    }
    @Column(name = "QSFY", length = 100)
    public String getQsfy() {
        return qsfy;
    }
    public void setQsfy(String qsfy) {
        this.qsfy = qsfy;
    }
    @Column(name = "KTSLXX", length = 20)
    public String getKtslxx() {
        return ktslxx;
    }
    public void setKtslxx(String ktslxx) {
        this.ktslxx = ktslxx;
    }
    @Column(name = "BGKSLYY", length = 20)
    public String getBgkslyy() {
        return bgkslyy;
    }
    public void setBgkslyy(String bgkslyy) {
        this.bgkslyy = bgkslyy;
    }
    @Column(name = "LARQ", length = 50)
    public String getLarq() {
        return larq;
    }
    public void setLarq(String larq) {
        this.larq = larq;
    }
    @Column(name = "YSAJSYCX", length = 20)
    public String getYsajsycx() {
        return ysajsycx;
    }
    public void setYsajsycx(String ysajsycx) {
        this.ysajsycx = ysajsycx;
    }
    @Column(name = "JYZPT", length = 10)
    public String getJyzpt() {
        return jyzpt;
    }
    public void setJyzpt(String jyzpt) {
        this.jyzpt = jyzpt;
    }
    @Column(name = "YSAJLY", length = 30)
    public String getYsajly() {
        return ysajly;
    }
    public void setYsajly(String ysajly) {
        this.ysajly = ysajly;
    }
    @Column(name = "SLRQ", length = 50)
    public String getSlrq() {
        return slrq;
    }
    public void setSlrq(String slrq) {
        this.slrq = slrq;
    }
    @Column(name = "SPZZ", length = 20)
    public String getSpzz() {
        return spzz;
    }
    public void setSpzz(String spzz) {
        this.spzz = spzz;
    }
    @Column(name = "DRSP", length = 10)
    public String getDrsp() {
        return drsp;
    }
    public void setDrsp(String drsp) {
        this.drsp = drsp;
    }
    @Column(name = "SQCSRQ", length = 50)
    public String getSqcsrq() {
        return sqcsrq;
    }
    public void setSqcsrq(String sqcsrq) {
        this.sqcsrq = sqcsrq;
    }
    @Column(name = "QSRQ", length = 50)
    public String getQsrq() {
        return qsrq;
    }
    public void setQsrq(String qsrq) {
        this.qsrq = qsrq;
    }
    @Column(name = "BGZYLDCT", length = 10)
    public String getBgzyldct() {
        return bgzyldct;
    }
    public void setBgzyldct(String bgzyldct) {
        this.bgzyldct = bgzyldct;
    }
    @Column(name = "XZXWZL", length = 20)
    public String getXzxwzl() {
        return xzxwzl;
    }
    public void setXzxwzl(String xzxwzl) {
        this.xzxwzl = xzxwzl;
    }
    @Column(name = "XZQQXWZL", length = 20)
    public String getXzqqxwzl() {
        return xzqqxwzl;
    }
    public void setXzqqxwzl(String xzqqxwzl) {
        this.xzqqxwzl = xzqqxwzl;
    }
    @Column(name = "JYSYJYCX", length = 10)
    public String getJysyjycx() {
        return jysyjycx;
    }
    public void setJysyjycx(String jysyjycx) {
        this.jysyjycx = jysyjycx;
    }
    @Column(name = "MSBFJXSL", length = 10)
    public String getMsbfjxsl() {
        return msbfjxsl;
    }
    public void setMsbfjxsl(String msbfjxsl) {
        this.msbfjxsl = msbfjxsl;
    }
    @Column(name = "SSXZ", length = 20)
    public String getSsxz() {
        return ssxz;
    }
    public void setSsxz(String ssxz) {
        this.ssxz = ssxz;
    }
    @Column(name = "JCY", length = 50)
    public String getJcy() {
        return jcy;
    }
    public void setJcy(String jcy) {
        this.jcy = jcy;
    }
    @Column(name = "JS", length = 20)
    public String getJs() {
        return js;
    }
    public void setJs(String js) {
        this.js = js;
    }
    @Column(name = "QSZAY", length = 100)
    public String getQszay() {
        return qszay;
    }
    public void setQszay(String qszay) {
        this.qszay = qszay;
    }
    @Column(name = "GSJG", length =100)
    public String getGsjg() {
        return gsjg;
    }
    public void setGsjg(String gsjg) {
        this.gsjg = gsjg;
    }
    @Column(name = "GSAH", length =100)
    public String getGsah() {
        return gsah;
    }
    public void setGsah(String gsah) {
        this.gsah = gsah;
    }
    @Column(name = "SLZTQFDMSSS", length =10)
    public String getSlztqfdmsss() {
        return slztqfdmsss;
    }
    public void setSlztqfdmsss(String slztqfdmsss) {
        this.slztqfdmsss = slztqfdmsss;
    }
    @Column(name = "JCYJYYQSL", length =10)
    public String getJcyjyyqsl() {
        return jcyjyyqsl;
    }
    public void setJcyjyyqsl(String jcyjyyqsl) {
        this.jcyjyyqsl = jcyjyyqsl;
    }
    @Column(name = "SNFT", length =10)
    public String getSnft() {
        return snft;
    }
    public void setSnft(String snft) {
        this.snft = snft;
    }
    @Column(name = "XZESQSAH", length =100)
    public String getXzesqsah() {
        return xzesqsah;
    }
    public void setXzesqsah(String xzesqsah) {
        this.xzesqsah = xzesqsah;
    }
    @Column(name = "QSLAND", length =20)
    public String getQsland() {
        return qsland;
    }
    public void setQsland(String qsland) {
        this.qsland = qsland;
    }
    @Column(name = "QSQSFYJC", length =10)
    public String getQsfyjc() {
        return qsfyjc;
    }
    public void setQsfyjc(String qsfyjc) {
        this.qsfyjc = qsfyjc;
    }
    @Column(name = "FYJB", length =10)
    public String getFyjb() {
        return fyjb;
    }
    public void setFyjb(String fyjb) {
        this.fyjb = fyjb;
    }
    @Column(name = "QSAHSXH", length =20)
    public String getQsahsxh() {
        return qsahsxh;
    }

    public void setQsahsxh(String qsahsxh) {
        this.qsahsxh = qsahsxh;
    }

    @Column(name = "QSCPSJ", length =50)
    public String getQscpsj() {
        return qscpsj;
    }
    public void setQscpsj(String qscpsj) {
        this.qscpsj = qscpsj;
    }
    @Column(name = "QSWSZL", length =50)
    public String getQswszl() {
        return qswszl;
    }
    public void setQswszl(String qswszl) {
        this.qswszl = qswszl;
    }
    @Column(name = "QSAJYL", length =100)
    public String getQsajyl() {
        return qsajyl;
    }
    public void setQsajyl(String qsajyl) {
        this.qsajyl = qsajyl;
    }
    @Column(name = "QSJAFS", length =50)
    public String getQsjafs() {
        return qsjafs;
    }
    public void setQsjafs(String qsjafs) {
        this.qsjafs = qsjafs;
    }
    @Column(name = "QSSJ", length =50)
    public String getQssj() {
        return qssj;
    }
    public void setQssj(String qssj) {
        this.qssj = qssj;
    }
    @Column(name = "SSHKFFW", length =100)
    public String getSshksfw() {
        return sshksfw;
    }
    public void setSshksfw(String sshksfw) {
        this.sshksfw = sshksfw;
    }
    @Column(name = "QSPJ")
    public byte[] getQspj() {
        return qspj;
    }
    public void setQspj(byte[] qspj) {
        this.qspj = qspj;
    }
    @Column(name = "XSESQSAH", length =100)
    public String getXsesqsah() {
        return xsesqsah;
    }
    public void setXsesqsah(String xsesqsah) {
        this.xsesqsah = xsesqsah;
    }
    @Column(name = "BZFYMC", length =100)
    public String getBzfymc() {
        return bzfymc;
    }
    public void setBzfymc(String bzfymc) {
        this.bzfymc = bzfymc;
    }
    @Column(name = "QSGSJG", length =100)
    public String getQsgsjg() {
        return qsgsjg;
    }
    public void setQsgsjg(String qsgsjg) {
        this.qsgsjg = qsgsjg;
    }
}
