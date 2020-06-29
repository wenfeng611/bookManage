package cn.edu.suda.bookmanagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "termbookplan")
@org.hibernate.annotations.Proxy(lazy = false)
public class TermBookPlan implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    String sxh;
    String xn;
    String xq;
    String xkkh;
    String jcsxh;
    String xsysl;
    String jsysl;
    String xglb;
    String xgr;
    String xgrq;
    String sh;
    String shr;
    String shrq;
    String h_jcmc;
    String h_jczz;
    String h_bbh;
    String h_cbs;
    double h_price=0d;
    double h_zhekou;
    String h_bzsh;
    String bz;
    String show_in_lsd;
    String h_kcinfo;
    String jc_type ;
    double jc_webprice;
    boolean isdel;

    public TermBookPlan(boolean isdel,String sxh, String xn, String xq, String xkkh, String jcsxh, String xsysl, String jsysl, String xglb, String xgr, String xgrq, String sh, String shr, String shrq, String h_jcmc, String h_jczz, String h_bbh, String h_cbs, double h_price, double h_zhekou, String h_bzsh, String bz, String show_in_lsd, String h_kcinfo, String jc_type, double jc_webprice) {
        this.isdel=isdel;
        this.sxh = sxh;
        this.xn = xn;
        this.xq = xq;
        this.xkkh = xkkh;
        this.jcsxh = jcsxh;
        this.xsysl = xsysl;
        this.jsysl = jsysl;
        this.xglb = xglb;
        this.xgr = xgr;
        this.xgrq = xgrq;
        this.sh = sh;
        this.shr = shr;
        this.shrq = shrq;
        this.h_jcmc = h_jcmc;
        this.h_jczz = h_jczz;
        this.h_bbh = h_bbh;
        this.h_cbs = h_cbs;
        this.h_price = h_price;
        this.h_zhekou = h_zhekou;
        this.h_bzsh = h_bzsh;
        this.bz = bz;
        this.show_in_lsd = show_in_lsd;
        this.h_kcinfo = h_kcinfo;
        this.jc_type = jc_type;
        this.jc_webprice = jc_webprice;
    }

    public double getJc_webprice() {
        return jc_webprice;
    }

    public void setJc_webprice(double jc_webprice) {
        this.jc_webprice = jc_webprice;
    }

    public TermBookPlan() {
    }

    public String getSxh() {
        return sxh;
    }

    public void setSxh(String sxh) {
        this.sxh = sxh;
    }

    public String getXn() {
        return xn;
    }

    public void setXn(String xn) {
        this.xn = xn;
    }

    public boolean isIsdel() {
        return isdel;
    }

    public void setIsdel(boolean isdel) {
        this.isdel = isdel;
    }
    public String getXq() {
        return xq;
    }

    public void setXq(String xq) {
        this.xq = xq;
    }

    public String getXkkh() {
        return xkkh;
    }

    public void setXkkh(String xkkh) {
        this.xkkh = xkkh;
    }

    public String getJcsxh() {
        return jcsxh;
    }

    public void setJcsxh(String jcsxh) {
        this.jcsxh = jcsxh;
    }

    public String getXsysl() {
        return xsysl;
    }

    public void setXsysl(String xsysl) {
        this.xsysl = xsysl;
    }

    public String getJsysl() {
        return jsysl;
    }

    public void setJsysl(String jsysl) {
        this.jsysl = jsysl;
    }

    public String getXglb() {
        return xglb;
    }

    public void setXglb(String xglb) {
        this.xglb = xglb;
    }

    public String getXgr() {
        return xgr;
    }

    public void setXgr(String xgr) {
        this.xgr = xgr;
    }

    public String getXgrq() {
        return xgrq;
    }

    public void setXgrq(String xgrq) {
        this.xgrq = xgrq;
    }

    public String getSh() {
        return sh;
    }

    public void setSh(String sh) {
        this.sh = sh;
    }

    public String getShr() {
        return shr;
    }

    public void setShr(String shr) {
        this.shr = shr;
    }

    public String getShrq() {
        return shrq;
    }

    public void setShrq(String shrq) {
        this.shrq = shrq;
    }

    public String getH_jcmc() {
        return h_jcmc;
    }

    public void setH_jcmc(String h_jcmc) {
        this.h_jcmc = h_jcmc;
    }

    public String getH_jczz() {
        return h_jczz;
    }

    public void setH_jczz(String h_jczz) {
        this.h_jczz = h_jczz;
    }

    public String getH_bbh() {
        return h_bbh;
    }

    public void setH_bbh(String h_bbh) {
        this.h_bbh = h_bbh;
    }

    public String getH_cbs() {
        return h_cbs;
    }

    public void setH_cbs(String h_cbs) {
        this.h_cbs = h_cbs;
    }

    public double getH_price() {
        return h_price;
    }

    public void setH_price(double h_price) {
        this.h_price = h_price;
    }

    public double getH_zhekou() {
        return h_zhekou;
    }

    public void setH_zhekou(double h_zhekou) {
        this.h_zhekou = h_zhekou;
    }

    public String getH_bzsh() {
        return h_bzsh;
    }

    public void setH_bzsh(String h_bzsh) {
        this.h_bzsh = h_bzsh;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getShow_in_lsd() {
        return show_in_lsd;
    }

    public void setShow_in_lsd(String show_in_lsd) {
        this.show_in_lsd = show_in_lsd;
    }

    public String getH_kcinfo() {
        return h_kcinfo;
    }

    public void setH_kcinfo(String h_kcinfo) {
        this.h_kcinfo = h_kcinfo;
    }

    public String getJc_type() {
        return jc_type;
    }

    public void setJc_type(String jc_type) {
        this.jc_type = jc_type;
    }

}
