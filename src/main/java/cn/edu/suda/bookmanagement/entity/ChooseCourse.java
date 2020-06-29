package cn.edu.suda.bookmanagement.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name = "choose_course")
//@org.hibernate.annotations.Proxy(lazy = false)
public class ChooseCourse implements java.io.Serializable{
    String XN;
    String XQ;
    String xkkh;
    String XH;
    String XM;
    String zymc;
    String XSF;
    String lsh;
    String jcyd;
    String KSSJ;
    String bz;
    String CXBJ;
    String JSBH;
    String JSMC;
    String HKBJ;
    String BZ2;
    String SKSJ;
    String XKSJ;
    String XKLB;
    String NJ;
    String ZWH;
    String FXBJ;
    String SYXMBJ;
    String QZD;
    String BZXX;
    String TQXXBJ;
    String PJBH;
    String DJC;
    String SFKP;
    String BCXXBJ;
    String SFKC;
    String SFRYXXK;
    String SFZXCX;
    String SXH;
    String KCMC;
    String INSERT_DATE;
    String TAG;
    String XZB;
    String XY;

    public ChooseCourse() {
    }

    public ChooseCourse(String XN, String XQ, String xkkh, String XH, String XM, String zymc, String XSF, String lsh, String jcyd, String KSSJ, String bz, String CXBJ, String JSBH, String JSMC, String HKBJ, String BZ2, String SKSJ, String XKSJ, String XKLB, String NJ, String ZWH, String FXBJ, String SYXMBJ, String QZD, String BZXX, String TQXXBJ, String PJBH, String DJC, String SFKP, String BCXXBJ, String SFKC, String SFRYXXK, String SFZXCX, String SXH, String KCMC, String INSERT_DATE, String TAG, String XZB, String XY) {
        this.XN = XN;
        this.XQ = XQ;
        this.xkkh = xkkh;
        this.XH = XH;
        this.XM = XM;
        this.zymc = zymc;
        this.XSF = XSF;
        this.lsh = lsh;
        this.jcyd = jcyd;
        this.KSSJ = KSSJ;
        this.bz = bz;
        this.CXBJ = CXBJ;
        this.JSBH = JSBH;
        this.JSMC = JSMC;
        this.HKBJ = HKBJ;
        this.BZ2 = BZ2;
        this.SKSJ = SKSJ;
        this.XKSJ = XKSJ;
        this.XKLB = XKLB;
        this.NJ = NJ;
        this.ZWH = ZWH;
        this.FXBJ = FXBJ;
        this.SYXMBJ = SYXMBJ;
        this.QZD = QZD;
        this.BZXX = BZXX;
        this.TQXXBJ = TQXXBJ;
        this.PJBH = PJBH;
        this.DJC = DJC;
        this.SFKP = SFKP;
        this.BCXXBJ = BCXXBJ;
        this.SFKC = SFKC;
        this.SFRYXXK = SFRYXXK;
        this.SFZXCX = SFZXCX;
        this.SXH = SXH;
        this.KCMC = KCMC;
        this.INSERT_DATE = INSERT_DATE;
        this.TAG = TAG;
        this.XZB = XZB;
        this.XY = XY;
    }

    public String getXN() {
        return XN;
    }

    public void setXN(String XN) {
        this.XN = XN;
    }

    public String getXQ() {
        return XQ;
    }

    public void setXQ(String XQ) {
        this.XQ = XQ;
    }

    public String getXkkh() {
        return xkkh;
    }

    public void setXkkh(String xkkh) {
        this.xkkh = xkkh;
    }

    public String getXH() {
        return XH;
    }

    public void setXH(String XH) {
        this.XH = XH;
    }

    public String getXM() {
        return XM;
    }

    public void setXM(String XM) {
        this.XM = XM;
    }

    public String getZymc() {
        return zymc;
    }

    public void setZymc(String zymc) {
        this.zymc = zymc;
    }

    public String getXSF() {
        return XSF;
    }

    public void setXSF(String XSF) {
        this.XSF = XSF;
    }

    public String getLsh() {
        return lsh;
    }

    public void setLsh(String lsh) {
        this.lsh = lsh;
    }

    public String getJcyd() {
        return jcyd;
    }

    public void setJcyd(String jcyd) {
        this.jcyd = jcyd;
    }

    public String getKSSJ() {
        return KSSJ;
    }

    public void setKSSJ(String KSSJ) {
        this.KSSJ = KSSJ;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getCXBJ() {
        return CXBJ;
    }

    public void setCXBJ(String CXBJ) {
        this.CXBJ = CXBJ;
    }

    public String getJSBH() {
        return JSBH;
    }

    public void setJSBH(String JSBH) {
        this.JSBH = JSBH;
    }

    public String getJSMC() {
        return JSMC;
    }

    public void setJSMC(String JSMC) {
        this.JSMC = JSMC;
    }

    public String getHKBJ() {
        return HKBJ;
    }

    public void setHKBJ(String HKBJ) {
        this.HKBJ = HKBJ;
    }

    public String getBZ2() {
        return BZ2;
    }

    public void setBZ2(String BZ2) {
        this.BZ2 = BZ2;
    }

    public String getSKSJ() {
        return SKSJ;
    }

    public void setSKSJ(String SKSJ) {
        this.SKSJ = SKSJ;
    }

    public String getXKSJ() {
        return XKSJ;
    }

    public void setXKSJ(String XKSJ) {
        this.XKSJ = XKSJ;
    }

    public String getXKLB() {
        return XKLB;
    }

    public void setXKLB(String XKLB) {
        this.XKLB = XKLB;
    }

    public String getNJ() {
        return NJ;
    }

    public void setNJ(String NJ) {
        this.NJ = NJ;
    }

    public String getZWH() {
        return ZWH;
    }

    public void setZWH(String ZWH) {
        this.ZWH = ZWH;
    }

    public String getFXBJ() {
        return FXBJ;
    }

    public void setFXBJ(String FXBJ) {
        this.FXBJ = FXBJ;
    }

    public String getSYXMBJ() {
        return SYXMBJ;
    }

    public void setSYXMBJ(String SYXMBJ) {
        this.SYXMBJ = SYXMBJ;
    }

    public String getQZD() {
        return QZD;
    }

    public void setQZD(String QZD) {
        this.QZD = QZD;
    }

    public String getBZXX() {
        return BZXX;
    }

    public void setBZXX(String BZXX) {
        this.BZXX = BZXX;
    }

    public String getTQXXBJ() {
        return TQXXBJ;
    }

    public void setTQXXBJ(String TQXXBJ) {
        this.TQXXBJ = TQXXBJ;
    }

    public String getPJBH() {
        return PJBH;
    }

    public void setPJBH(String PJBH) {
        this.PJBH = PJBH;
    }

    public String getDJC() {
        return DJC;
    }

    public void setDJC(String DJC) {
        this.DJC = DJC;
    }

    public String getSFKP() {
        return SFKP;
    }

    public void setSFKP(String SFKP) {
        this.SFKP = SFKP;
    }

    public String getBCXXBJ() {
        return BCXXBJ;
    }

    public void setBCXXBJ(String BCXXBJ) {
        this.BCXXBJ = BCXXBJ;
    }

    public String getSFKC() {
        return SFKC;
    }

    public void setSFKC(String SFKC) {
        this.SFKC = SFKC;
    }

    public String getSFRYXXK() {
        return SFRYXXK;
    }

    public void setSFRYXXK(String SFRYXXK) {
        this.SFRYXXK = SFRYXXK;
    }

    public String getSFZXCX() {
        return SFZXCX;
    }

    public void setSFZXCX(String SFZXCX) {
        this.SFZXCX = SFZXCX;
    }

    public String getSXH() {
        return SXH;
    }

    public void setSXH(String SXH) {
        this.SXH = SXH;
    }

    public String getKCMC() {
        return KCMC;
    }

    public void setKCMC(String KCMC) {
        this.KCMC = KCMC;
    }

    public String getINSERT_DATE() {
        return INSERT_DATE;
    }

    public void setINSERT_DATE(String INSERT_DATE) {
        this.INSERT_DATE = INSERT_DATE;
    }

    public String getTAG() {
        return TAG;
    }

    public void setTAG(String TAG) {
        this.TAG = TAG;
    }

    public String getXZB() {
        return XZB;
    }

    public void setXZB(String XZB) {
        this.XZB = XZB;
    }

    public String getXY() {
        return XY;
    }

    public void setXY(String XY) {
        this.XY = XY;
    }
}
