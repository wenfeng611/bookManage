package cn.edu.suda.bookmanagement.entity;

import javax.persistence.*;

//教材征订计划
@Entity
@Table(name = "termtakeplan")
@org.hibernate.annotations.Proxy(lazy = false)
public class TermTakePlan implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    String id;

    String xn;
    String xq;
    String xkkh;
    String jcsxh;
    String kkxy;
    String skxy;
    String kcdm;
    String kcmc;
    String jcmc;
    String jczz;
    String bbh;
    String cbs;
    String price;
    String bzsh;
    String xsysl;
    String jsysl;
    String xiaoqu;
    String syzy;
    String sybj;
    String xslb;
    String tjsj;
    String zhekou;
    String sh;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSh() {
        return sh;
    }

    public void setSh(String sh) {
        this.sh = sh;
    }

    public String getXn() {
        return xn;
    }

    public void setXn(String xn) {
        this.xn = xn;
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

    public String getKkxy() {
        return kkxy;
    }

    public void setKkxy(String kkxy) {
        this.kkxy = kkxy;
    }

    public String getSkxy() {
        return skxy;
    }

    public void setSkxy(String skxy) {
        this.skxy = skxy;
    }

    public String getKcdm() {
        return kcdm;
    }

    public void setKcdm(String kcdm) {
        this.kcdm = kcdm;
    }

    public String getKcmc() {
        return kcmc;
    }

    public void setKcmc(String kcmc) {
        this.kcmc = kcmc;
    }

    public String getJcmc() {
        return jcmc;
    }

    public void setJcmc(String jcmc) {
        this.jcmc = jcmc;
    }

    public String getJczz() {
        return jczz;
    }

    public void setJczz(String jczz) {
        this.jczz = jczz;
    }

    public String getBbh() {
        return bbh;
    }

    public void setBbh(String bbh) {
        this.bbh = bbh;
    }

    public String getCbs() {
        return cbs;
    }

    public void setCbs(String cbs) {
        this.cbs = cbs;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBzsh() {
        return bzsh;
    }

    public void setBzsh(String bzsh) {
        this.bzsh = bzsh;
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

    public String getXiaoqu() {
        return xiaoqu;
    }

    public void setXiaoqu(String xiaoqu) {
        this.xiaoqu = xiaoqu;
    }

    public String getSyzy() {
        return syzy;
    }

    public void setSyzy(String syzy) {
        this.syzy = syzy;
    }

    public String getSybj() {
        return sybj;
    }

    public void setSybj(String sybj) {
        this.sybj = sybj;
    }

    public String getXslb() {
        return xslb;
    }

    public void setXslb(String xslb) {
        this.xslb = xslb;
    }

    public String getTjsj() {
        return tjsj;
    }

    public void setTjsj(String tjsj) {
        this.tjsj = tjsj;
    }

    public String getZhekou() {
        return zhekou;
    }

    public void setZhekou(String zhekou) {
        this.zhekou = zhekou;
    }

    public TermTakePlan() {
    }

    public TermTakePlan(String sh,String xn, String xq, String xkkh, String jcsxh, String kkxy, String skxy, String kcdm, String kcmc, String jcmc, String jczz, String bbh, String cbs, String price, String bzsh, String xsysl, String jsysl, String xiaoqu, String syzy, String sybj, String xslb, String tjsj, String zhekou) {
        this.sh=sh;
        this.xn = xn;
        this.xq = xq;
        this.xkkh = xkkh;
        this.jcsxh = jcsxh;
        this.kkxy = kkxy;
        this.skxy = skxy;
        this.kcdm = kcdm;
        this.kcmc = kcmc;
        this.jcmc = jcmc;
        this.jczz = jczz;
        this.bbh = bbh;
        this.cbs = cbs;
        this.price = price;
        this.bzsh = bzsh;
        this.xsysl = xsysl;
        this.jsysl = jsysl;
        this.xiaoqu = xiaoqu;
        this.syzy = syzy;
        this.sybj = sybj;
        this.xslb = xslb;
        this.tjsj = tjsj;
        this.zhekou = zhekou;
    }
}

